import org.gradle.nativeplatform.MachineArchitecture.*
import org.gradle.nativeplatform.OperatingSystemFamily.*
import org.jetbrains.kotlin.gradle.plugin.mpp.*
import org.jetbrains.kotlin.konan.target.*

plugins {
	kotlin("multiplatform")
	application
}

val useSingleTarget: Boolean by rootProject.extra
val kglVersion: String by rootProject.extra

kotlin {
	if (HostManager.hostIsLinux) linuxX64()
	if (HostManager.hostIsMingw) mingwX64()
	if (HostManager.hostIsMac) macosX64()

	sourceSets {
		commonMain {
			dependencies {
				implementation(kotlin("stdlib-common"))
				implementation("com.kgl:kgl-glfw:$kglVersion")
				implementation(project(":imgui"))
				implementation(project(":imgui-glfw"))
				implementation(project(":imgui-opengl"))
			}
		}
		commonTest {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
	}

	jvm {
		val osName = when {
			HostManager.hostIsLinux -> LINUX
			HostManager.hostIsMac -> MACOS
			HostManager.hostIsMingw -> WINDOWS
			else -> error("unknown")
		}

		withJava()
		compilations {
			"main" {
				dependencies {
					implementation(kotlin("stdlib-jdk8"))

					implementation(project(":cimgui", "jvmDefault"))
					if (HostManager.hostIsLinux) runtimeOnly(project(":cimgui", "jvmLinuxX64Default"))
					if (HostManager.hostIsMac) runtimeOnly(project(":cimgui", "jvmMacosX64Default"))
					if (HostManager.hostIsMingw) runtimeOnly(project(":cimgui", "jvmMingwX64Default"))

					val lwjglVersion = "3.2.2"
					val lwjglNatives = "natives-$osName"
					implementation("org.lwjgl:lwjgl:$lwjglVersion:$lwjglNatives")
					implementation("org.lwjgl:lwjgl-glfw:$lwjglVersion:$lwjglNatives")
					implementation("org.lwjgl:lwjgl-opengl:$lwjglVersion:$lwjglNatives")
					implementation("org.lwjgl:lwjgl-opengl:$lwjglVersion")
				}
			}
			"test" {
				dependencies {
					implementation(kotlin("test"))
					implementation(kotlin("test-junit"))
				}
			}
		}

		attributes {
			attribute(OPERATING_SYSTEM_ATTRIBUTE, objects.named(osName))
			attribute(ARCHITECTURE_ATTRIBUTE, objects.named(X86_64))
		}
	}

	targets.withType<KotlinNativeTarget> {
		compilations {
			"main" {
				defaultSourceSet {
					kotlin.srcDir("src/nativeMain/kotlin")
				}

				dependencies {
					implementation("com.kgl:kgl-glfw-static:$kglVersion")
				}
			}
		}

		binaries {
			executable {
				// Change to specify fully qualified name of your application's entry point:
				entryPoint = "sample.main"
				// Specify command-line arguments, if necessary:
				runTask?.args("")
			}
		}
	}
}

application {
	mainClassName = "sample.SimpleKt"
	if (HostManager.hostIsMac) applicationDefaultJvmArgs = listOf("-XstartOnFirstThread")
}
