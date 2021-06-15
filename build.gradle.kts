import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

val versionObj = Version(
    "0",
    "1",
    "5"
)

project.group = "dev.divinegenesis"
project.version = versionObj

val mavenPublishingUrl = "https://dev.freeloli.com/releases"

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
val clean: Task by tasks

shadowJar.archiveClassifier.set("fatjar")

tasks.shadowJar {
    exclude("org/**", "kotlin/**", "okhttp3/**", "okio/**")
    relocate("retrofit2", "dev.divinegenesis.retrofit2")
    relocate("com.google", "dev.divinegenesis.google")
    mergeServiceFiles()
    manifest {
        attributes(mapOf("Main-Class" to "dev.divinegenesis.Kson5e"))
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenPublish") {
            from(components["java"])
            artifactId = "Kson5e"
            groupId = project.group as String
            version = project.version.toString()

            repositories {
                maven {
                    setUrl(mavenPublishingUrl)
                    credentials {
                        username = project.properties["mavenUser"] as String
                        password = project.properties["mavenPassword"] as String
                    }
                    authentication {
                        create<BasicAuthentication>("basic")
                    }
                }
            }
        }
    }
}

val publishMavenPublishPublicationToMavenRepository: Task by tasks

publishMavenPublishPublicationToMavenRepository.apply {
    dependsOn(clean)
    dependsOn(build)
    build.mustRunAfter(clean)
}

jar.dependsOn(shadowJar)

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

fun getBuild(): String {
    return System.getenv("BUILD_NUMBER")
        ?: System.getProperty("BUILD_NUMBER")
        ?: System.getenv("GIT_COMMIT")?.substring(0,7)
        ?: System.getProperty("GIT_COMMIT")?.substring(0,7)
        ?: "DEV"
}

class Version (
    private val major: String,
    private val minor: String,
    private val revision: String) {

    override fun toString() = "$major.$minor.${revision}_${getBuild()}"
}

