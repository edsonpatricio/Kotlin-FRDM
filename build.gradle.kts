plugins {
    kotlin("jvm") version "1.4.30"
}

group = "br.dev.edsonpatricio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("script-runtime"))
}
