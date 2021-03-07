import org.jetbrains.kotlin.gradle.plugin.mpp.*
import org.jetbrains.kotlin.konan.target.*

plugins {
	kotlin("multiplatform")
	`maven-publish`
}

val useSingleTarget: Boolean by rootProject.extra
val kglVersion: String by rootProject.extra

kotlin {
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "1.8"
		}
	}

	if (!useSingleTarget || HostManager.hostIsLinux) linuxX64()
	if (!useSingleTarget || HostManager.hostIsMac) macosX64()
	if (!useSingleTarget || HostManager.hostIsMingw) mingwX64()

	sourceSets {
		commonMain {
			dependencies {
				implementation(kotlin("stdlib-common"))
				implementation(project(":imgui"))
				implementation("com.kgl:kgl-glfw:$kglVersion")
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
				compileOnly(project(":cimgui", "jvmDefault"))
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
