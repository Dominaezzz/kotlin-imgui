import org.jetbrains.kotlin.gradle.plugin.mpp.*
import org.jetbrains.kotlin.konan.target.*

plugins {
	kotlin("multiplatform")
	`maven-publish`
}

val useSingleTarget: Boolean by rootProject.extra
val imGuiVersion: String by rootProject.extra

val generateImGui by tasks.registering(GenerateImGuiTask::class) {
	inputDir.set(project(":cimgui").buildDir.resolve("downloads/cimgui-$imGuiVersion/generator/output"))
	commonDir.set(buildDir.resolve("generated-src/common"))
	jvmDir.set(buildDir.resolve("generated-src/jvm"))
	nativeDir.set(buildDir.resolve("generated-src/native"))
}

kotlin {
	jvm {
		compilations {
			all { kotlinOptions.jvmTarget = "1.8" }
			named("main") {
				compileKotlinTask.dependsOn(generateImGui)
			}
		}
	}

	if (!useSingleTarget || HostManager.hostIsLinux) linuxX64()
	if (!useSingleTarget || HostManager.hostIsMac) macosX64()
	if (!useSingleTarget || HostManager.hostIsMingw) mingwX64()

	targets.withType<KotlinNativeTarget> {
		compilations.named("main") {
			compileKotlinTask.dependsOn(generateImGui)
		}
	}

	sourceSets {
		commonMain {
			kotlin.srcDir(generateImGui.map { it.commonDir })
			dependencies {
				implementation(kotlin("stdlib-common"))
			}
		}

		commonTest {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

		named("jvmMain") {
			kotlin.srcDir(generateImGui.map { it.jvmDir })
			dependencies {
				implementation(project(":cimgui", "jvmDefault"))
			}
		}

		named("jvmTest") {
			dependencies {
				implementation(kotlin("test-junit"))
				runtimeOnly(project(":cimgui", "jvm${HostManager.host.presetName.capitalize()}Default"))
			}
		}

		targets.withType<KotlinNativeTarget> {
			named("${name}Main") {
				kotlin.srcDir(generateImGui.map { it.nativeDir })
				kotlin.srcDir("src/nativeMain/kotlin")
				resources.srcDir("src/nativeMain/resources")
				dependencies {
					implementation(project(":cimgui"))
				}
			}

			named("${name}Test") {
				kotlin.srcDir("src/nativeTest/kotlin")
				resources.srcDir("src/nativeTest/resources")
			}
		}
	}
}
