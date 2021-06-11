import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar


plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

project.group = "dev.divinegenesis"
project.version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    api("com.google.code.gson:gson:2.8.7") {
        isTransitive = true
    }
    api("com.squareup.retrofit2:retrofit:2.9.0") {
        isTransitive = true
    }
    api("com.squareup.retrofit2:converter-gson:2.9.0") {
        isTransitive = true
    }
    compileOnly("com.squareup.okhttp3:logging-interceptor:3.8.0")
    compileOnly(kotlin("stdlib-jdk8"))
}

val shadowJar: ShadowJar by tasks
val jar: Jar by tasks
val clean: Task by tasks
val build: Task by tasks

shadowJar.archiveClassifier.set("FatJar")



val minimalJar = task<ShadowJar>("minimalJar") {
    dependsOn(shadowJar)
    minimize()
    archiveClassifier.set("${shadowJar.archiveClassifier}-min")
    configurations = shadowJar.configurations
    from(sourceSets["main"].output)
    manifest.inheritFrom(jar.manifest)
}

tasks.withType<ShadowJar> {
    exclude("*.pom")
    relocate("com.squareup.retrofit","dev.divinegenesis.retrofit")
}

jar.apply {
    archiveBaseName.set(project.name)
    manifest.attributes(mapOf(
        "Implementation-Version" to "1.0"))
}

build.apply {
    dependsOn(jar)
    dependsOn(shadowJar)
    dependsOn(minimalJar)

    jar.mustRunAfter(clean)
    shadowJar.mustRunAfter(jar)
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}