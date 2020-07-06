import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.presetName

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

val isIdeaActive: Boolean by rootProject.extra
val kglVersion: String by rootProject.extra

kotlin {
    linuxX64()
    mingwX64()
    macosX64()
    jvm()

    if (isIdeaActive) {
        // Create a target based on current host. i.e for auto-complete and stuff.
        targetFromPreset(presets.getByName(HostManager.host.presetName), "native")
    }

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

        val nativeMain = maybeCreate("nativeMain")
        nativeMain.apply {
            dependsOn(commonMain.get())
            dependencies {
                implementation(project(":cimgui"))
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
                compileOnly(project(":cimgui", "jvmDefault"))
            }
        }
        named("jvmTest") {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
    }
}
