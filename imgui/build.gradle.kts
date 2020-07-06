import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.presetName

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

val isIdeaActive: Boolean by rootProject.extra

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
            kotlin.srcDir("src/commonMain/generated")
            dependencies {
                implementation(kotlin("stdlib-common"))
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

            kotlin.srcDir("src/nativeMain/generated")

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
            kotlin.srcDir("src/jvmMain/generated")

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
