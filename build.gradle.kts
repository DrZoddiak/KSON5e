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
}

dependencies {
    api("com.google.code.gson:gson:2.8.7")
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.8.0")
    shadow(kotlin("stdlib-jdk8"))
}

val shadowJar: ShadowJar by tasks
val jar: Jar by tasks
val build: Task by tasks


shadowJar.archiveClassifier.set("FatJar")

jar.manifest {
    attributes(mapOf("Main-Class" to "dev.divinegenesis.JTK"))
}
jar.enabled = false

build.dependsOn(shadowJar)

tasks.withType<ShadowJar> {
    mergeServiceFiles()
    archiveBaseName.set("Kson5e")
    archiveClassifier.set("")
    archiveVersion.set("1.0")
    relocate("retrofit2","dev.divinegenesis.retrofit2")
    relocate("com.google","dev.divinegenesis.google")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}