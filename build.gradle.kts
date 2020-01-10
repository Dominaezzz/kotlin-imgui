import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.KonanTarget
import java.io.ByteArrayOutputStream

plugins {
	kotlin("multiplatform") version "1.3.61" apply false
	id("de.undercouch.download") version ("4.0.2") apply false
}

val stdout = ByteArrayOutputStream()
exec {
	commandLine("git", "describe", "--tags")
	standardOutput = stdout
}

version = stdout.toString().trim()
group = "com.kotlin-imgui"

val useSingleTarget: Boolean by extra { System.getProperty("idea.active") == "true" }

val konanUserDir: File by extra {
	file(System.getenv("KONAN_DATA_DIR") ?: "${System.getProperty("user.home")}/.konan")
}
val toolChainFolderMap: Map<KonanTarget, File> by extra {
	val deps = konanUserDir.resolve("dependencies")

	mapOf(
			KonanTarget.LINUX_X64 to "clang-llvm-8.0.0-linux-x86-64",
			KonanTarget.MACOS_X64 to "clang-llvm-apple-8.0.0-darwin-macos",
			KonanTarget.MINGW_X64 to "msys2-mingw-w64-x86_64-clang-llvm-lld-compiler_rt-8.0.1"
	).mapValues { deps.resolve(it.value) }
}

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

			// Hack until https://youtrack.jetbrains.com/issue/KT-30498
			targets.withType<KotlinNativeTarget> {
				// Disable cross-platform build
				if (konanTarget != HostManager.host) {
					compilations.all {
						cinterops.all {
							tasks.named(interopProcessingTaskName).configure {
								enabled = false
							}
						}
						compileKotlinTask.enabled = false
					}
					binaries.all {
						linkTask.enabled = false
					}
				}
			}
		}
	}

	plugins.withId("maven-publish") {
		configure<PublishingExtension> {
			val vcs: String by project
			val bintrayOrg: String by project
			val bintrayRepository: String by project

			repositories {
				maven("https://api.bintray.com/maven/$bintrayOrg/$bintrayRepository/kotlin-imgui/;publish=0;override=0") {
					name = "bintray"
					credentials {
						username = System.getenv("BINTRAY_USER")
						password = System.getenv("BINTRAY_API_KEY")
					}
				}
			}

			publications.withType<MavenPublication> {
				pom {
					name.set(project.name)
					description.set(project.description)
					url.set(vcs)
					licenses {
						license {
							name.set("The Apache Software License, Version 2.0")
							url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
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

		val publishTasks = tasks.withType<PublishToMavenRepository>()
				.matching {
					when {
						HostManager.hostIsMingw -> it.name.startsWith("publishMingw")
						HostManager.hostIsMac -> it.name.startsWith("publishMacos") || it.name.startsWith("publishIos")
						HostManager.hostIsLinux -> it.name.startsWith("publishLinux") ||
								it.name.startsWith("publishJs") ||
								it.name.startsWith("publishJvm") ||
								it.name.startsWith("publishMetadata") ||
								it.name.startsWith("publishKotlinMultiplatform")
						else -> TODO("Unknown host")
					}
				}
		tasks.register("smartPublish") {
			dependsOn(publishTasks)
		}
	}
}
