# Yet Just Another Silver

## Motivation

Many modded recipes use the conventional `c` silver tags, but a lightweight source of silver is not always available. This mod adds silver without requiring a larger content or technology mod.

## Features

Adds silver ore, deepslate silver ore, raw silver, silver ingots, silver nuggets, and blocks of silver.

## Compatibility

The Minecraft 26.2 artifact supports Fabric on exactly Minecraft 26.2 and requires Java 25.

## Verification

Run data generation and the build as separate steps:

```shell
./gradlew clean runDatagen
./gradlew build
```

`build` runs `checkJar`, which validates the expanded metadata, Java 25 bytecode, required generated resources, and the absence of bundled Create integration.

Production server checks are available through `scripts/test-production-server.sh` and run for Minecraft 26.2 in CI before artifacts are published.
