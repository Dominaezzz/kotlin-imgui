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
	val osName = when {
		HostManager.hostIsLinux -> LINUX
		HostManager.hostIsMac -> MACOS
		HostManager.hostIsMingw -> WINDOWS
		else -> error("unknown host")
	}

	jvm {
		withJava()

		attributes {
			attribute(OPERATING_SYSTEM_ATTRIBUTE, objects.named(osName))
			attribute(ARCHITECTURE_ATTRIBUTE, objects.named(X86_64))
		}
	}

	if (HostManager.hostIsLinux) linuxX64()
	if (HostManager.hostIsMac) macosX64()
	if (HostManager.hostIsMingw) mingwX64()

	targets.withType<KotlinNativeTarget> {
		binaries {
			executable {
				entryPoint = "sample.main"
			}
		}
	}

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

		named("jvmMain") {
			dependencies {
				implementation(project(":cimgui", "jvmDefault"))
				runtimeOnly(project(":cimgui", "jvm${HostManager.host.presetName.capitalize()}Default"))

				val lwjglVersion = "3.2.2"
				val lwjglNatives = "natives-$osName"
				implementation("org.lwjgl:lwjgl:$lwjglVersion:$lwjglNatives")
				implementation("org.lwjgl:lwjgl-glfw:$lwjglVersion:$lwjglNatives")
				implementation("org.lwjgl:lwjgl-opengl:$lwjglVersion:$lwjglNatives")
				implementation("org.lwjgl:lwjgl-opengl:$lwjglVersion")
			}
		}

		named("jvmTest") {
			dependencies {
				implementation(kotlin("test-junit"))
			}
		}

		targets.withType<KotlinNativeTarget> {
			named("${name}Main") {
				kotlin.srcDir("src/nativeMain/kotlin")
				resources.srcDir("src/nativeMain/resources")
				dependencies {
					implementation("com.kgl:kgl-glfw-static:$kglVersion")
				}
			}

			named("${name}Test") {
				kotlin.srcDir("src/nativeTest/kotlin")
				resources.srcDir("src/nativeTest/resources")
			}
		}
	}
}

application {
	mainClassName = "sample.SimpleKt"
	if (HostManager.hostIsMac) applicationDefaultJvmArgs = listOf("-XstartOnFirstThread")
}
