import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

project.group = "dev.divinegenesis"
project.version = "1.0-SNAPSHOT"
group = "com.github.DrZoddiak"


repositories {
    mavenCentral()
}

dependencies {
    api("com.google.code.gson:gson:2.8.7")
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.8.0")
    implementation(kotlin("stdlib-jdk8"))
}

val shadowJar: ShadowJar by tasks
val jar: Jar by tasks
val build: Task by tasks
val compileJava: JavaCompile by tasks
val clean: Task by tasks

jar.manifest {
    attributes(mapOf("Main-Class" to "dev.divinegenesis.JTK"))
}
jar.enabled = false

tasks.withType<ShadowJar> {
    exclude("org/**","kotlin/**","okhttp3/**","okio/**")
    mergeServiceFiles()
    archiveBaseName.set("Kson5e")
    archiveClassifier.set("")
    archiveVersion.set("1.0")
    relocate("retrofit2","dev.divinegenesis.retrofit2")
    relocate("com.google","dev.divinegenesis.google")
}

tasks {
    kotlinSourcesJar {
        typeOf<Jar>()
        dependsOn(classes)
        archiveClassifier.set("sources")
        from(project.sourceSets["main"].allSource)
    }
}

artifacts {
    archives(tasks.kotlinSourcesJar)
    archives(shadowJar)
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

build.apply {
    dependsOn(jar)
    dependsOn(shadowJar)

    jar.mustRunAfter(clean)
    shadowJar.mustRunAfter(jar)
}

