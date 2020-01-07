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
                    kotlin.srcDir("src/generated/kotlin")
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
}
