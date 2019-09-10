import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
}

group = "net.jemzart"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit:junit:4.12")
    testImplementation("io.mockk:mockk:1.9.3.kotlin12")
    testImplementation("org.amshove.kluent:kluent:1.54")
}

tasks.withType< KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}