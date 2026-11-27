Build 1.0.6 for Minecraft 1.19 through 26.3 from one Stonecutter source tree.

- One jar per range that already shared an API, data pack layout, and Java level.
- Official Mojang mappings on every node.
- Create splashing for crushed raw silver loads only when Create is installed.

Port to Fabric for Minecraft 26.3.

- Require Java 25 and use the unobfuscated Loom toolchain.
- Port ore features, placed features, loot counts, and recipe generation to 26.3 APIs.
- Add JAR validation and production dedicated-server compatibility tests.
