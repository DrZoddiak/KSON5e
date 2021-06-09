plugins {
    java
    maven
    application
    kotlin("jvm") version "1.4.21"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.7")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.8.0")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.jar { // Otherwise you'll get a "No main manifest attribute" error
    manifest {
        attributes["Main-Class"] = "dev.divinegenesis.JTK"
    }

    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}