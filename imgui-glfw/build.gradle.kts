import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

kotlin {
    linuxX64()

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
