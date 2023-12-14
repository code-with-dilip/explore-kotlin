val coroutinesVersion : String by project
plugins {
    kotlin("jvm") version "1.9.20"
    java
}

group = "com.learnkotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation((project(":kotlin-playground")))
    implementation(kotlin("stdlib"))
    implementation ("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.1")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.0")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
}



