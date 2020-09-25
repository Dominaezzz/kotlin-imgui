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
	if (!useSingleTarget || HostManager.hostIsLinux) linuxX64()
	if (!useSingleTarget || HostManager.hostIsMingw) mingwX64()
	if (!useSingleTarget || HostManager.hostIsMac) macosX64()

	jvm {
		compilations {
			"main" {
				compileKotlinTask.dependsOn(generateImGui)
				defaultSourceSet {
					kotlin.srcDir(generateImGui.map { it.jvmDir })
				}
				dependencies {
					api(kotlin("stdlib-jdk8"))
					implementation(project(":cimgui", "jvmDefault"))
				}
			}
			"test" {
				dependencies {
					implementation(kotlin("test"))
					implementation(kotlin("test-junit"))

					if (HostManager.hostIsLinux) runtimeOnly(project(":cimgui", "jvmLinuxX64Default"))
					if (HostManager.hostIsMac) runtimeOnly(project(":cimgui", "jvmMacosX64Default"))
					if (HostManager.hostIsMingw) runtimeOnly(project(":cimgui", "jvmMingwX64Default"))
				}
			}
		}
	}

	targets.withType<KotlinNativeTarget> {
		compilations {
			"main" {
				compileKotlinTask.dependsOn(generateImGui)
				defaultSourceSet {
					kotlin.srcDir(generateImGui.map { it.nativeDir })
					kotlin.srcDir("src/nativeMain/kotlin")
				}

				dependencies {
					implementation(project(":cimgui"))
				}
			}
			"test" {
				defaultSourceSet {
					kotlin.srcDir("src/nativeTest/kotlin")
				}
			}
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
	}
}
