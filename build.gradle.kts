import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.mpp.*
import org.jetbrains.kotlin.konan.target.*
import java.io.*

plugins {
	kotlin("multiplatform") version "1.4.10" apply false
	id("de.undercouch.download") version ("4.0.2") apply false
}

val stdout = ByteArrayOutputStream()
exec {
	commandLine("git", "describe", "--tags")
	standardOutput = stdout
}

group = "com.kotlin-imgui"
version = stdout.toString().trim()

val useSingleTarget: Boolean by extra { System.getProperty("idea.active") == "true" }
val imGuiVersion: String by extra("1.77")
val kglVersion: String by extra("0.1.11")

subprojects {
	group = rootProject.group
	version = rootProject.version

	repositories {
		mavenCentral()
		maven("https://maven.pkg.github.com/Dominaezzz/kgl") {
			credentials {
				username = System.getenv("GITHUB_USER")
				password = System.getenv("GITHUB_TOKEN")
			}
		}
	}

	plugins.withId("org.jetbrains.kotlin.multiplatform") {
		configure<KotlinMultiplatformExtension> {
			sourceSets.all {
				languageSettings.apply {
					enableLanguageFeature("InlineClasses")
					useExperimentalAnnotation("kotlin.RequiresOptIn")
					useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes")
					useExperimentalAnnotation("com.imgui.ImGuiInternal")
				}
			}

			// Hack until https://youtrack.jetbrains.com/issue/KT-30498
			// Cross-Platform builds are generally disabled, but linux targets can apparently be built
			// on both macOS and Windows, which breaks on both of those platforms, so we disable the
			// cinterop, compile, and link tasks for any non-host native target
			targets.withType<KotlinNativeTarget> {
				if (!HostManager().isEnabled(konanTarget)) {
					compilations.all {
						cinterops.all { tasks[interopProcessingTaskName].enabled = false }
						compileKotlinTask.enabled = false
					}
					binaries.all { linkTask.enabled = false }
				}
			}
		}
	}

	plugins.withId("maven-publish") {
		configure<PublishingExtension> {
			repositories {
				maven("https://maven.pkg.github.com/Dominaezzz/${rootProject.name}") {
					name = "GitHubPackages"
					credentials {
						username = System.getenv("GITHUB_USER")
						password = System.getenv("GITHUB_TOKEN")
					}
				}
			}

			publications.withType<MavenPublication> {
				val vcs = "https://github.com/Dominaezzz/kotlin-imgui"
				pom {
					name.set(project.name)
					description.set(project.description)
					url.set(vcs)
					licenses {
						license {
							name.set("The Apache Software License, Version 2.0")
							url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
							distribution.set("repo")
						}
					}
					developers {
						developer {
							id.set("Dominaezzz")
							name.set("Dominic Fischer")
						}
					}
					scm {
						connection.set("$vcs.git")
						developerConnection.set("$vcs.git")
						url.set(vcs)
					}
				}
			}
		}

		val taskPrefixes = when {
			HostManager.hostIsLinux -> listOf(
				"publishLinux",
				"publishJs",
				"publishJvmPublication",
				"publishJvmLinux",
				"publishMetadata",
				"publishKotlinMultiplatform"
			)
			HostManager.hostIsMac -> listOf(
				"publishMacos",
				"publishIos",
				"publishJvmMacos"
			)
			HostManager.hostIsMingw -> listOf(
				"publishMingw",
				"publishJvmMingw"
			)
			else -> error("unknown host")
		}

		val publishTasks = tasks.withType<PublishToMavenRepository>().matching { task ->
			taskPrefixes.any { task.name.startsWith(it) }
		}

		tasks.register("smartPublish") {
			dependsOn(publishTasks)
		}
	}
}
