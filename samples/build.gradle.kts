plugins {
    kotlin("multiplatform")
}

kotlin {
    linuxX64 {
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

    sourceSets {
        all {
            languageSettings.run {
                useExperimentalAnnotation("kotlin.Experimental")
                useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes")
                useExperimentalAnnotation("com.imgui.ImGuiInternal")

                enableLanguageFeature("InlineClasses")
            }
        }
    }
}
