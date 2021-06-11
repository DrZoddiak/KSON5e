plugins {
    java
    maven
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "2.0.4"
}

repositories {
    mavenCentral()
    jcenter()
}

configurations {
    compileClasspath.get().extendsFrom to project.shadow
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

tasks {
    shadowJar {
        archiveBaseName.set("Kson5e")
        archiveClassifier.set("dev")
        configurations {
            create("exposedAPI") {
                isCanBeConsumed = true
            }.extendsFrom to project.shadow
        }
        relocate(
            "com.squareup.retrofit2",
            "dev.divinegenesis.retrofit2"
        )
        relocate("com.google.code", "dev.divinegenesis.code")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "dev.divinegenesis.JTK"))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}