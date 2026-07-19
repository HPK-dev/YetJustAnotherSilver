#!/usr/bin/env bash

set -euo pipefail

if [[ "$#" -ne 3 ]]; then
    echo "Usage: $0 <minecraft-version> <fabric-api-version> <mod-jar>" >&2
    exit 2
fi

minecraft_version="$1"
fabric_api_version="$2"
mod_jar="$3"

if [[ -z "${JAVA_HOME:-}" || ! -x "$JAVA_HOME/bin/java" ]]; then
    echo "JAVA_HOME must point to JDK 25" >&2
    exit 2
fi

if [[ ! -f "$mod_jar" ]]; then
    echo "Mod JAR not found: $mod_jar" >&2
    exit 2
fi

java_version="$($JAVA_HOME/bin/java -version 2>&1 | sed -n '1s/.*version "\([0-9]*\).*/\1/p')"
if [[ "$java_version" != "25" ]]; then
    echo "Expected JDK 25, got $java_version" >&2
    exit 2
fi

root_dir="$(mktemp -d "${TMPDIR:-/tmp}/yjas-server-${minecraft_version}.XXXXXX")"
server_dir="$root_dir/server"
installer_jar="$root_dir/fabric-installer.jar"
log_file="$root_dir/server.log"
input_fifo="$root_dir/server-input"
server_pid=""

cleanup() {
    if [[ -n "$server_pid" ]] && kill -0 "$server_pid" 2>/dev/null; then
        kill "$server_pid" 2>/dev/null || true
    fi
    rm -rf "$root_dir"
}
trap cleanup EXIT

mkdir -p "$server_dir/mods"

curl -fsSL "https://maven.fabricmc.net/net/fabricmc/fabric-installer/1.1.1/fabric-installer-1.1.1.jar" -o "$installer_jar"
"$JAVA_HOME/bin/java" -jar "$installer_jar" server \
    -dir "$server_dir" \
    -mcversion "$minecraft_version" \
    -loader 0.19.3 \
    -downloadMinecraft

curl -fsSL "https://maven.fabricmc.net/net/fabricmc/fabric-api/fabric-api/${fabric_api_version}/fabric-api-${fabric_api_version}.jar" \
    -o "$server_dir/mods/fabric-api.jar"
curl -fsSL "https://maven.fabricmc.net/net/fabricmc/fabric-language-kotlin/1.13.13+kotlin.2.4.10/fabric-language-kotlin-1.13.13+kotlin.2.4.10.jar" \
    -o "$server_dir/mods/fabric-language-kotlin.jar"
cp "$mod_jar" "$server_dir/mods/yjas.jar"

printf 'eula=true\n' > "$server_dir/eula.txt"
printf 'online-mode=false\nserver-port=0\nview-distance=2\nsimulation-distance=2\n' > "$server_dir/server.properties"

mkfifo "$input_fifo"
(
    cd "$server_dir"
    exec "$JAVA_HOME/bin/java" -Xms512M -Xmx1G -jar fabric-server-launch.jar nogui < "$input_fifo"
) > "$log_file" 2>&1 &
server_pid="$!"
exec 3> "$input_fifo"

server_ready=false
for _ in $(seq 1 180); do
    if grep -Fq "Done (" "$log_file"; then
        server_ready=true
        break
    fi

    if ! kill -0 "$server_pid" 2>/dev/null; then
        break
    fi

    sleep 1
done

if [[ "$server_ready" == true ]]; then
    printf 'stop\n' >&3
else
    kill "$server_pid" 2>/dev/null || true
fi
exec 3>&-

server_exit=0
wait "$server_pid" || server_exit="$?"
server_pid=""
cat "$log_file"

if [[ "$server_ready" != true || "$server_exit" -ne 0 ]]; then
    echo "Production server did not start and stop cleanly for $minecraft_version" >&2
    exit 1
fi

required_messages=(
    "Loading Minecraft $minecraft_version with Fabric Loader 0.19.3"
    "- yjas "
    "We add silver to your game!"
    "Done ("
    "Stopping server"
)

for message in "${required_messages[@]}"; do
    if ! grep -Fq -- "$message" "$log_file"; then
        echo "Production server check failed for $minecraft_version: missing '$message'" >&2
        exit 1
    fi
done

if grep -Eq "Could not execute entrypoint|Mod resolution encountered an incompatible mod set|Failed to start the minecraft server" "$log_file"; then
    echo "Production server check failed for $minecraft_version" >&2
    exit 1
fi

echo "Verified production server startup for Minecraft $minecraft_version"
