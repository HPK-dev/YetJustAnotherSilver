# Yet Just Another Silver

## Motivation

Many modded recipes use the conventional `c` silver tags, but a lightweight source of silver is not always available. This mod adds silver without requiring a larger content or technology mod.

## Features

Adds silver ore, deepslate silver ore, raw silver, silver ingots, silver nuggets, and blocks of silver.

## Compatibility

One source tree builds a Fabric jar for every supported range from Minecraft 1.19 through 26.3. Each `versions/<node>` directory selects the Minecraft, Java, and loader versions for that jar. Version `1.0.6+mc26.3` requires Java 25. Ranges on Java 21 and Java 17 are separate jars because the bytecode level and data pack layout differ.

## Verification

Generate data, then build every node as a separate Gradle run so the generated files are packaged:

```shell
./gradlew runDatagen
./gradlew build
```

`build` runs `checkJar` for each node. Production server checks use `scripts/test-production-server.sh` and run per node in CI before artifacts are published.
