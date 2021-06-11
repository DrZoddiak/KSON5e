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
val build: Task by tasks

shadowJar.archiveClassifier.set("FatJar")

tasks.withType<ShadowJar> {
    archiveBaseName.set("Kson5e")
    exclude("*.pom")
    relocate("com.squareup.retrofit","dev.divinegenesis.retrofit")
    mergeServiceFiles()
    manifest {
        attributes(mapOf("Main-Class" to "dev.divinegenesis.JTK"))
    }
}

build.apply {
    dependsOn(shadowJar)
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}