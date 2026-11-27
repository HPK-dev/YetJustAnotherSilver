pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/") { name = "Fabric" }
        maven("https://maven.kikugie.dev/releases") { name = "KikuGie" }
        maven("https://maven.kikugie.dev/snapshots") { name = "KikuGie Snapshots" }
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.10"
    id("dev.kikugie.loom-back-compat") version "0.4.2"
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

stonecutter {
    create(rootProject) {
        versions(
            // Each node is the widest range whose bytecode, data pack paths, and Java level
            // match the existing mc* branch that already shipped one jar for that range.
            "1.19-1.19.1" to "1.19",
            "1.19.2" to "1.19.2",
            "1.19.3" to "1.19.3",
            "1.19.4" to "1.19.4",
            "1.20-1.20.1" to "1.20.1",
            "1.20.2" to "1.20.2",
            "1.20.3-1.20.4" to "1.20.4",
            "1.20.5-1.20.6" to "1.20.6",
            "1.21-1.21.1" to "1.21.1",
            "1.21.2-1.21.3" to "1.21.3",
            "1.21.4-1.21.5" to "1.21.4",
            "1.21.6-1.21.8" to "1.21.8",
            "1.21.9-1.21.10" to "1.21.10",
            "1.21.11" to "1.21.11",
            "26.1" to "26.1.2",
            "26.2" to "26.2",
            "26.3" to "26.3",
        )
        vcsVersion = "26.3"
    }
}

rootProject.name = "YetJustAnotherSilver"
