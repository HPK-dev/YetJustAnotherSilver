import dev.kikugie.loomx.LoomCompatDependencyExtension
import dev.kikugie.loomx.LoomCompatProjectExtension
import groovy.json.JsonSlurper
import net.fabricmc.loom.api.fabricapi.FabricApiExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.zip.ZipFile

plugins {
    id("dev.kikugie.loom-back-compat")
    kotlin("jvm")
    `maven-publish`
}

val javaVersion = property("java_version").toString().toInt()
val minecraftDependencyJson = property("minecraft_dependency_json").toString()
val javaDependency = property("java_dependency").toString()

version = "${property("mod_version")}+mc${property("mc_version_range")}"
group = property("maven_group").toString()

base {
    archivesName.set(property("archives_base_name").toString())
}

sourceSets.named("main") {
    resources.srcDir(rootProject.file("src/create-recipes/${property("create_recipe_set")}"))
}

val loomProject = extensions.getByType(LoomCompatProjectExtension::class.java)

repositories {
    maven("https://maven.fabricmc.net/") { name = "Fabric" }
    mavenCentral()
}

dependencies {
    val loomDeps = this.extensions.getByType(LoomCompatDependencyExtension::class.java)
    "minecraft"("com.mojang:minecraft:${property("minecraft_version")}")
    "modImplementation"("net.fabricmc:fabric-loader:${property("loader_version")}")
    "modImplementation"("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")
    "modImplementation"("net.fabricmc:fabric-language-kotlin:${property("fabric_kotlin_version")}")
    loomDeps.applyMojangMappings()
}

extensions.configure<FabricApiExtension>("fabricApi") {
    configureDataGeneration {
        client.set(true)
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
    withSourcesJar()
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    targetCompatibility = JavaVersion.toVersion(javaVersion)
}

kotlin {
    jvmToolchain(javaVersion)
    compilerOptions {
        jvmTarget.set(
            when (javaVersion) {
                17 -> JvmTarget.JVM_17
                21 -> JvmTarget.JVM_21
                else -> JvmTarget.JVM_25
            }
        )
        val metadata = findProperty("kotlin_metadata_version")?.toString()
        if (!metadata.isNullOrBlank()) {
            freeCompilerArgs.add("-Xmetadata-version=$metadata")
        }
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(javaVersion)
}

tasks.named<ProcessResources>("processResources") {
    val modVersion = project.version.toString()
    val loaderDependency = project.property("loader_dependency").toString()
    val fabricModId = project.property("fabric_mod_id").toString()
    val kotlinDependency = project.property("kotlin_dependency").toString()
    val minecraftJson = minecraftDependencyJson
    val javaDep = javaDependency
    inputs.property("version", modVersion)
    inputs.property("minecraft", minecraftJson)
    filesMatching("fabric.mod.json") {
        filter { line ->
            line.replace("\"@VERSION@\"", "\"$modVersion\"")
                .replace("\"@LOADER@\"", "\"$loaderDependency\"")
                .replace("\"@MINECRAFT@\"", minecraftJson)
                .replace("\"@JAVA@\"", "\"$javaDep\"")
                .replace("\"@FABRIC_ID@\"", "\"$fabricModId\"")
                .replace("\"@KOTLIN@\"", "\"$kotlinDependency\"")
        }
    }
}

tasks.named("sourcesJar") {
    dependsOn("runDatagen")
}

tasks.named<Jar>("jar") {
    dependsOn("runDatagen")
    from(rootProject.file("LICENSE")) {
        rename { "${it}_${archiveBaseName.get()}" }
    }
}

val checkJar = tasks.register("checkJar") {
    group = "verification"
    description = "Verifies metadata, Java bytecode, generated data, and bundled contents."
    dependsOn(loomProject.modJar)
    val archive = loomProject.modJar.flatMap { it.archiveFile }
    val requiredEntries = project.property("check_entries").toString().split('|').filter { it.isNotBlank() }
    val expectedMajor = project.property("class_major").toString().toInt()
    val expectedMinecraft = JsonSlurper().parseText(minecraftDependencyJson)
    inputs.file(archive)
    inputs.property("entries", requiredEntries.joinToString("|"))

    doLast {
        val jarFile = archive.get().asFile

        ZipFile(jarFile).use { zip ->
            val metadataEntry = zip.getEntry("fabric.mod.json")
                ?: throw GradleException("JAR is missing fabric.mod.json")
            val mainClassEntry = zip.getEntry("team/hpk/yjas/ModMain.class")
                ?: throw GradleException("JAR is missing ModMain.class")

            val metadata = zip.getInputStream(metadataEntry).reader(Charsets.UTF_8).use {
                JsonSlurper().parse(it) as Map<*, *>
            }
            if (metadata["id"] != "yjas" || metadata["version"] != project.version.toString()) {
                throw GradleException("JAR contains invalid or unexpanded Fabric metadata")
            }
            val depends = metadata["depends"] as Map<*, *>
            if (depends["minecraft"] != expectedMinecraft || depends["java"] != javaDependency) {
                throw GradleException(
                    "JAR dependency metadata ${depends["minecraft"]} / ${depends["java"]} " +
                        "does not match $expectedMinecraft / $javaDependency"
                )
            }

            val classHeader = zip.getInputStream(mainClassEntry).use { it.readNBytes(8) }
            val majorVersion = ((classHeader[6].toInt() and 0xff) shl 8) or (classHeader[7].toInt() and 0xff)
            if (majorVersion != expectedMajor) {
                throw GradleException("Expected class major version $expectedMajor, got $majorVersion")
            }

            requiredEntries.forEach { entry ->
                if (zip.getEntry(entry) == null) {
                    throw GradleException("Missing required JAR entry: $entry")
                }
            }

            val bundledCreate = zip.entries().asSequence().firstOrNull { entry ->
                entry.name.matches(Regex("(?i)(^|/)(create|flywheel)[^/]*\\.jar$"))
            }
            if (bundledCreate != null) {
                throw GradleException("Create integration must not be bundled: ${bundledCreate.name}")
            }
        }

        logger.lifecycle("Verified $jarFile")
    }
}

tasks.check {
    dependsOn(checkJar)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = property("archives_base_name").toString()
            from(components["java"])
        }
    }
}
