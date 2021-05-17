import org.jetbrains.kotlin.gradle.tasks.*

plugins {
	`java-gradle-plugin`
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.serialization") version "1.3.72"
}

repositories {
	mavenCentral()
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}

dependencies {
	implementation("com.squareup:kotlinpoet:1.6.0")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
}
