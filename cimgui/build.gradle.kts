import de.undercouch.gradle.tasks.download.Download
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.KonanTarget
import org.jetbrains.kotlin.utils.fileUtils.withReplacedExtensionOrNull

plugins {
    kotlin("multiplatform")
    id("de.undercouch.download")
    `maven-publish`
}

val imGuiVersion by extra("1.73")

val konanUserDir = file(System.getenv("KONAN_DATA_DIR") ?: "${System.getProperty("user.home")}/.konan")
val toolChainMap = mapOf(
        KonanTarget.LINUX_X64 to "clang-llvm-8.0.0-linux-x86-64",
        KonanTarget.MACOS_X64 to "clang-llvm-apple-8.0.0-darwin-macos",
        KonanTarget.MINGW_X64 to "msys2-mingw-w64-x86_64-clang-llvm-lld-compiler_rt-8.0.1"
)
val toolChainFolderName = toolChainMap[HostManager.host]
val llvmBinFolder = konanUserDir.resolve("dependencies/${toolChainFolderName}/bin")


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

val objDir = buildDir.resolve("lib/obj")
val staticLibFile = buildDir.resolve("lib/libimgui.a")

val compileImGui by tasks.registering(Exec::class) {
    dependsOn(extractImGui, extractCWrapper)

    val sourceFiles = listOf(
            imguiDir.resolve("imgui.cpp"),
            imguiDir.resolve("imgui_draw.cpp"),
            imguiDir.resolve("imgui_demo.cpp"),
            imguiDir.resolve("imgui_widgets.cpp"),
            cimguiOutput.resolve("cimgui.cpp")
    )

    inputs.files(sourceFiles)
    outputs.files(sourceFiles.map { it.withReplacedExtensionOrNull("cpp", "obj") })

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
val archiveImGui by tasks.registering(Exec::class) {
    dependsOn(compileImGui)

    // inputs.file(objFile)
    outputs.file(staticLibFile)

    environment("PATH", "$llvmBinFolder;${System.getenv("PATH")}")
    executable = llvmBinFolder.resolve("llvm-ar").absolutePath
    args(
            "rc", staticLibFile.absolutePath,
            objDir.resolve("cimgui.o").absolutePath,
            objDir.resolve("imgui.o").absolutePath,
            objDir.resolve("imgui_demo.o").absolutePath,
            objDir.resolve("imgui_draw.o").absolutePath,
            objDir.resolve("imgui_widgets.o").absolutePath
    )
}

kotlin {
    linuxX64()
    // mingwX64()
    // macosX64()

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
        compilations {
            "main" {
                cinterops {
                    create("cimgui") {
                        includeDirs(cimguiOutput, imguiDir)
                        tasks.named(interopProcessingTaskName) {
                            dependsOn(extractImGui, extractCWrapper)
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
