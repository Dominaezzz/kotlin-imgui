import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.KonanTarget

plugins {
	kotlin("multiplatform") version "1.3.61" apply false
	id("de.undercouch.download") version ("4.0.2") apply false
}

group = "com.kotlin-imgui"
version = "1.0-SNAPSHOT"

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
}
