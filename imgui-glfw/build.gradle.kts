import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    kotlin("multiplatform")
    `maven-publish`
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
                    implementation("com.kgl:kgl-glfw:0.1.9-dev-5")
                }
            }
        }
    }
}
