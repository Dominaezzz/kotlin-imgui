import org.gradle.nativeplatform.OperatingSystemFamily.*
import org.gradle.nativeplatform.MachineArchitecture.*
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.KonanTarget
import org.jetbrains.kotlin.konan.target.presetName

plugins {
    kotlin("multiplatform")
    application
}

val kglVersion: String by rootProject.extra
val lwjglVersion = "3.2.2"
val lwjglNatives = when (HostManager.host) {
    KonanTarget.LINUX_X64 -> "natives-linux"
    KonanTarget.MINGW_X64 -> "natives-windows"
    KonanTarget.MINGW_X86 -> "natives-windows-x86"
    KonanTarget.MACOS_X64 -> "natives-macos"
    else -> TODO("Unkown OS")
}

kotlin {
    // Create a single native target based on current host.
    targetFromPreset(presets.getByName(HostManager.host.presetName))
    jvm { withJava() }

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(project(":imgui"))
                implementation(project(":imgui-glfw"))
                implementation(project(":imgui-opengl"))

                implementation("com.kgl:kgl-glfw:$kglVersion")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val nativeMain = maybeCreate("nativeMain")
        nativeMain.apply {
            dependsOn(commonMain.get())
            dependencies {
                implementation("com.kgl:kgl-glfw-static:$kglVersion")
            }
        }

        for (target in targets.withType<KotlinNativeTarget>()) {
            // Skip the IDE target.
            if (target.name == "native") continue

            val main = getByName("${target.konanTarget.presetName}Main")
            main.dependsOn(nativeMain)
        }

        named("jvmMain") {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))

                implementation(project(":cimgui", "jvmDefault"))
                implementation("org.lwjgl:lwjgl-opengl:$lwjglVersion")
            }
        }
        named("jvmTest") {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
    }

    jvm {
        compilations {
            "main" {
                dependencies {
                    val target = HostManager.host

                    runtimeOnly(project(":cimgui", "jvm${target.presetName.capitalize()}Default"))

                    runtimeOnly("org.lwjgl:lwjgl:$lwjglVersion:$lwjglNatives")
                    runtimeOnly("org.lwjgl:lwjgl-glfw:$lwjglVersion:$lwjglNatives")
                    runtimeOnly("org.lwjgl:lwjgl-opengl:$lwjglVersion:$lwjglNatives")
                }
            }
        }

        // TODO: Not too sure how to consume these (nicely) yet.
        // attributes {
        //     attribute(OPERATING_SYSTEM_ATTRIBUTE, objects.named(LINUX))  // or MACOS or WINDOWS
        //     attribute(ARCHITECTURE_ATTRIBUTE,     objects.named(X86_64)) // or x86 or arm32 or arm64
        // }
    }

    targets.withType<KotlinNativeTarget> {
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
