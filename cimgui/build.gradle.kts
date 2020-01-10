import de.undercouch.gradle.tasks.download.Download
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.KonanTarget

plugins {
    kotlin("multiplatform")
    id("de.undercouch.download")
    `maven-publish`
}

val useSingleTarget: Boolean by rootProject.extra
val toolChainFolderMap: Map<KonanTarget, File> by rootProject.extra
val imGuiVersion by extra("1.73")

val downloadsDir = buildDir.resolve("downloads")
val cimguiDir = downloadsDir.resolve("cimgui-${imGuiVersion}")
val cimguiOutput = cimguiDir.resolve("generator/output")
val imguiDir = cimguiDir.resolve("imgui")
val libsDir = buildDir.resolve("libs")

val downloadCWrapper by tasks.registering(Download::class) {
    src("https://github.com/cimgui/cimgui/archive/${imGuiVersion}.zip")
    dest(downloadsDir.resolve("cimgui.zip"))
    overwrite(false)
}
val extractCWrapper by tasks.registering(Copy::class) {
    from(downloadCWrapper.map { zipTree(it.dest) })
    into(downloadsDir)
}

val downloadImGui by tasks.registering(Download::class) {
    src("https://github.com/ocornut/imgui/archive/v${imGuiVersion}.zip")
    dest(downloadsDir.resolve("imgui.zip"))
    overwrite(false)
}
val extractImGui by tasks.registering(Copy::class) {
    dependsOn(extractCWrapper)

    from(downloadImGui.map { zipTree(it.dest) }) {
        eachFile {
            relativePath = RelativePath(true, *relativePath.segments.drop(1).toTypedArray())
        }
        includeEmptyDirs = false
    }
    into(cimguiDir.resolve("imgui"))
}

val sourceFiles = listOf(
        imguiDir.resolve("imgui.cpp"),
        imguiDir.resolve("imgui_draw.cpp"),
        imguiDir.resolve("imgui_demo.cpp"),
        imguiDir.resolve("imgui_widgets.cpp"),
        cimguiOutput.resolve("cimgui.cpp")
)
val objFileNames = listOf(
        "imgui.o",
        "imgui_draw.o",
        "imgui_demo.o",
        "imgui_widgets.o",
        "cimgui.o"
)

kotlin {
    if (!useSingleTarget || HostManager.hostIsLinux) linuxX64()
    if (!useSingleTarget || HostManager.hostIsMingw) mingwX64()
    if (!useSingleTarget || HostManager.hostIsMac) macosX64()

    sourceSets {
        commonMain {
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
    }

    targets.withType<KotlinNativeTarget> {
        val llvmBinFolder = toolChainFolderMap.getValue(konanTarget).resolve("bin")
        val libDir = buildDir.resolve("lib").resolve(targetName)

        val objDir = libDir.resolve("obj")
        val staticLibFile = libDir.resolve("libimgui.a")

        val objFiles = objFileNames.map { objDir.resolve(it) }
        val compileImGui = tasks.register<Exec>("compileImGuiFor$targetName") {
            dependsOn(extractImGui, extractCWrapper)
            onlyIf { konanTarget == HostManager.host }

            inputs.files(sourceFiles)
            outputs.files(objFiles)

            environment(
                    "PATH" to "$llvmBinFolder;${System.getenv("PATH")}",
                    "CPATH" to "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include"
            )
            executable = llvmBinFolder.resolve("clang++").absolutePath
            args(
                    "-c", "-Wall",
                    "-I${imguiDir}", "-I${cimguiOutput}", "-I${cimguiDir}",
                    // "-DCIMGUI_DEFINE_ENUMS_AND_STRUCTS",
                    "-working-directory", objDir.absolutePath,
                    *sourceFiles.map { it.absolutePath }.toTypedArray()
            )

            doFirst {
                mkdir(objDir)
            }
        }
        val archiveImGui = tasks.register<Exec>("archiveImGuiFor$targetName") {
            dependsOn(compileImGui)
            onlyIf { konanTarget == HostManager.host }

            inputs.files(objFiles)
            outputs.file(staticLibFile)

            environment("PATH", "$llvmBinFolder;${System.getenv("PATH")}")
            executable = llvmBinFolder.resolve("llvm-ar").absolutePath
            args("rc", staticLibFile.absolutePath)
            args(objFiles.map { it.absolutePath })
        }

        compilations {
            "main" {
                cinterops {
                    create("cimgui") {
                        includeDirs(cimguiOutput, imguiDir)
                        tasks.named(interopProcessingTaskName) {
                            dependsOn(extractImGui, extractCWrapper)
                        }
                        compileImGui {
                            dependsOn(tasks.named(interopProcessingTaskName))
                        }
                    }
                }

                compileKotlinTask.dependsOn(archiveImGui)
                kotlinOptions {
                    freeCompilerArgs = listOf("-include-binary", staticLibFile.absolutePath)
                }
            }
        }
    }
}
