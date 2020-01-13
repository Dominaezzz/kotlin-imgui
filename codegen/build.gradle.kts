plugins {
    kotlin("jvm")
    application
    id("org.jetbrains.kotlin.plugin.serialization") version "1.3.61"
}

val imGuiVersion: String by rootProject.extra

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.squareup:kotlinpoet:1.4.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.14.0")
}

application {
    mainClassName = "MainKt"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    run.configure {
        workingDir(rootProject.projectDir.resolve("imgui/src/generated/kotlin"))
        args(project(":cimgui").buildDir.resolve("downloads/cimgui-${imGuiVersion}/generator/output"))
    }
}
