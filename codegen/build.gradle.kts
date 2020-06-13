plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.3.72"
    application
}

val imGuiVersion: String by rootProject.extra

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.squareup:kotlinpoet:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
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
        workingDir(rootProject.projectDir.resolve("imgui/src"))
        args(project(":cimgui").buildDir.resolve("downloads/cimgui-${imGuiVersion}/generator/output"))
    }
}
