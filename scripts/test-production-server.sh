#!/usr/bin/env bash

set -euo pipefail

if [[ "$#" -lt 3 || "$#" -gt 6 ]]; then
    echo "Usage: $0 <minecraft-version> <fabric-api-version> <mod-jar> [java-major] [loader-version] [fabric-language-kotlin-version]" >&2
    exit 2
fi

minecraft_version="$1"
fabric_api_version="$2"
mod_jar="$3"
java_major="${4:-25}"
loader_version="${5:-0.20.1}"
fabric_kotlin_version="${6:-1.14.2+kotlin.2.4.21}"

resolve_java_home() {
    if [[ -n "${SERVER_JAVA_HOME:-}" && -x "${SERVER_JAVA_HOME}/bin/java" ]]; then
        echo "${SERVER_JAVA_HOME}"
        return
    fi
    local named="JAVA_HOME_${java_major}_X64"
    if [[ -n "${!named:-}" && -x "${!named}/bin/java" ]]; then
        echo "${!named}"
        return
    fi
    local candidate
    for candidate in \
        "${HOME}/.jdks/jdk-${java_major}" \
        "/usr/lib/jvm/java-${java_major}-openjdk-amd64" \
        "/usr/lib/jvm/temurin-${java_major}-jdk-amd64"
    do
        if [[ -x "${candidate}/bin/java" ]]; then
            echo "${candidate}"
            return
        fi
    done
    echo "No JDK ${java_major} found. Set SERVER_JAVA_HOME." >&2
    exit 2
}

JAVA_HOME="$(resolve_java_home)"
export JAVA_HOME

if [[ ! -f "$mod_jar" ]]; then
    echo "Mod JAR not found: $mod_jar" >&2
    exit 2
fi

java_version="$("$JAVA_HOME/bin/java" -version 2>&1 | sed -n '1s/.*version "\([0-9]*\).*/\1/p')"
if [[ "$java_version" != "$java_major" ]]; then
    echo "Expected JDK ${java_major}, got ${java_version}" >&2
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
    -loader "$loader_version" \
    -downloadMinecraft

curl -fsSL "https://maven.fabricmc.net/net/fabricmc/fabric-api/fabric-api/${fabric_api_version}/fabric-api-${fabric_api_version}.jar" \
    -o "$server_dir/mods/fabric-api.jar"
# Older Fabric API publications on Maven are the base module only. The bundled jar players install
# is the Modrinth release with the same version number.
if ! unzip -l "$server_dir/mods/fabric-api.jar" | grep -q 'META-INF/jars/'; then
    bundle_url="$(curl -fsSL -G "https://api.modrinth.com/v2/project/P7dR8mSH/version" \
        --data-urlencode "game_versions=[\"${minecraft_version}\"]" \
        --data-urlencode 'loaders=["fabric"]' | python3 -c '
import json, sys
wanted = sys.argv[1]
for item in json.load(sys.stdin):
    if item.get("version_number") == wanted:
        print(item["files"][0]["url"])
        break
' "$fabric_api_version")"
    test -n "$bundle_url"
    curl -fsSL "$bundle_url" -o "$server_dir/mods/fabric-api.jar"
fi
curl -fsSL "https://maven.fabricmc.net/net/fabricmc/fabric-language-kotlin/${fabric_kotlin_version}/fabric-language-kotlin-${fabric_kotlin_version}.jar" \
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
    "Loading Minecraft $minecraft_version with Fabric Loader $loader_version"
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
