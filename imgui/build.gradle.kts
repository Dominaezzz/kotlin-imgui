import org.jetbrains.kotlin.gradle.plugin.mpp.*
import org.jetbrains.kotlin.konan.target.*

plugins {
	kotlin("multiplatform")
	`maven-publish`
}

val useSingleTarget: Boolean by rootProject.extra

val imGuiVersion: String by rootProject.extra

val generateImGui by tasks.registering(GenerateImGuiTask::class) {
	inputDir.set(project(":cimgui").buildDir.resolve("downloads/cimgui-${imGuiVersion}/generator/output"))
	commonDir.set(file("src/commonMain/generated"))
	jvmDir.set(file("src/jvmMain/generated"))
	nativeDir.set(file("src/nativeMain/generated"))
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
					kotlin.srcDir("src/jvmMain/generated")
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
					kotlin.srcDir("src/nativeMain/generated")
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
			kotlin.srcDir("src/commonMain/generated")
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
