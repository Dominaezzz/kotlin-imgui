import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    kotlin("multiplatform")
}

val useSingleTarget: Boolean by rootProject.extra

kotlin {
    if (!useSingleTarget || HostManager.hostIsLinux) linuxX64()
    if (!useSingleTarget || HostManager.hostIsMingw) mingwX64()
    if (!useSingleTarget || HostManager.hostIsMac) macosX64()

    targets.withType<KotlinNativeTarget> {
        compilations {
            "main" {
                defaultSourceSet {
                    kotlin.srcDir("src/nativeMain/kotlin")
                }

                dependencies {
                    implementation(project(":cimgui"))
                    implementation(project(":imgui"))
                    implementation(project(":imgui-glfw"))
                    implementation(project(":imgui-opengl"))
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
