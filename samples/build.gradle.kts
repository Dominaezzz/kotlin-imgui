import org.gradle.nativeplatform.OperatingSystemFamily.*
import org.gradle.nativeplatform.MachineArchitecture.*
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    kotlin("multiplatform")
    application
}

val useSingleTarget: Boolean by rootProject.extra

kotlin {
    if (HostManager.hostIsLinux) linuxX64()
    if (HostManager.hostIsMingw) mingwX64()
    if (HostManager.hostIsMac) macosX64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
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
        withJava()
        compilations {
            "main" {
                dependencies {
                    implementation(kotlin("stdlib-jdk8"))

                    implementation(project(":cimgui", "jvmDefault"))
                    runtimeOnly(project(":cimgui", "jvmLinuxArm32HfpDefault"))
                    // runtimeOnly(project(":cimgui", "jvmLinuxX64Default"))
                    // runtimeOnly(project(":cimgui", "jvmMingwX64Default"))
                    // runtimeOnly(project(":cimgui", "jvmMacosX64Default"))

                    val lwjglVersion = "3.2.2"
                    val lwjglNatives = "natives-linux"

                    implementation("com.kgl:kgl-glfw:0.1.9-dev-5")

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
            attribute(OPERATING_SYSTEM_ATTRIBUTE, objects.named(LINUX))  // or MACOS or WINDOWS
            attribute(ARCHITECTURE_ATTRIBUTE,     objects.named("arm32-hfp")) // or x86 or arm32 or arm64
        }
    }

    targets.withType<KotlinNativeTarget> {
        compilations {
            "main" {
                defaultSourceSet {
                    kotlin.srcDir("src/nativeMain/kotlin")
                }

                dependencies {
                    implementation("com.kgl:kgl-glfw-static:0.1.9-dev-5")
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
}
