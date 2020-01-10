import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
	kotlin("multiplatform") version "1.3.61" apply false
	id("de.undercouch.download") version ("4.0.2") apply false
}

group = "com.kotlin-imgui"
version = "1.0-SNAPSHOT"

subprojects {
	group = rootProject.group
	version = rootProject.version

	repositories {
		mavenCentral()
		jcenter()
		maven("https://dl.bintray.com/dominaezzz/kotlin-native")
	}

	plugins.withId("org.jetbrains.kotlin.multiplatform") {
		configure<KotlinMultiplatformExtension> {
			sourceSets.all {
				languageSettings.run {
					useExperimentalAnnotation("kotlin.Experimental")
					useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes")
					useExperimentalAnnotation("com.imgui.ImGuiInternal")

					enableLanguageFeature("InlineClasses")
				}
			}
		}
	}
}
