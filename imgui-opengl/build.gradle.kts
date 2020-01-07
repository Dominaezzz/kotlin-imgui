import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.KonanTarget
import org.jetbrains.kotlin.utils.fileUtils.withReplacedExtensionOrNull

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

val konanUserDir = file(System.getenv("KONAN_DATA_DIR") ?: "${System.getProperty("user.home")}/.konan")
val toolChainMap = mapOf(
        KonanTarget.LINUX_X64 to "clang-llvm-8.0.0-linux-x86-64",
        KonanTarget.MACOS_X64 to "clang-llvm-apple-8.0.0-darwin-macos",
        KonanTarget.MINGW_X64 to "msys2-mingw-w64-x86_64-clang-llvm-lld-compiler_rt-8.0.1"
)
val toolChainFolderName = toolChainMap[HostManager.host]
val llvmBinFolder = konanUserDir.resolve("dependencies/${toolChainFolderName}/bin")

evaluationDependsOn(":cimgui")
val extractCWrapper by project(":cimgui").tasks.getting(Copy::class)
val extractImGui by project(":cimgui").tasks.getting(Copy::class)

val imGuiVersion: String by project(":cimgui").extra.properties
val downloadsDir = project(":cimgui").buildDir.resolve("downloads")
val cimguiDir = downloadsDir.resolve("cimgui-${imGuiVersion}")
val cimguiOutput = cimguiDir.resolve("generator/output")
val imguiDir = cimguiDir.resolve("imgui")
val imguiImplDir = imguiDir.resolve("examples")
val gl3wDir = imguiImplDir.resolve("libs/gl3w")

val objDir = buildDir.resolve("lib/obj")
val staticLibFile = buildDir.resolve("lib/libimgui_impl.a")

val compileImGuiImpl by tasks.registering(Exec::class) {
    dependsOn(extractImGui, extractCWrapper)

    val sourceFiles = listOf(
            imguiImplDir.resolve("imgui_impl_opengl3.cpp"),
            gl3wDir.resolve("GL/gl3w.c")
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
            "-I${imguiDir}", "-I${cimguiOutput}", "-I${gl3wDir}",
            "-DIMGUI_IMPL_API=extern \"C\"",
            "-DIMGUI_IMPL_OPENGL_LOADER_GL3W",
            "-working-directory", objDir.absolutePath,
            *sourceFiles.map { it.absolutePath }.toTypedArray()
    )

    doFirst {
        mkdir(objDir)
    }
}
val archiveImGuiImpl by tasks.registering(Exec::class) {
    dependsOn(compileImGuiImpl)

    outputs.file(staticLibFile)

    environment("PATH", "$llvmBinFolder;${System.getenv("PATH")}")
    executable = llvmBinFolder.resolve("llvm-ar").absolutePath
    args(
            "rc", staticLibFile.absolutePath,
            objDir.resolve("imgui_impl_opengl3.o").absolutePath,
            objDir.resolve("gl3w.o").absolutePath
    )
}

kotlin {
    linuxX64()

    targets.withType<KotlinNativeTarget> {
        compilations {
            "main" {
                cinterops {
                    create("cimgui_impl") {
                        includeDirs(cimguiOutput, imguiDir)
                        tasks.named(interopProcessingTaskName) {
                            dependsOn(extractImGui, extractCWrapper)
                        }
                    }
                    create("gl3w") {
                        includeDirs(gl3wDir)
                    }
                }

                compileKotlinTask.dependsOn(archiveImGuiImpl)
                kotlinOptions {
                    freeCompilerArgs = listOf("-include-binary", staticLibFile.absolutePath)
                }

                defaultSourceSet {
                    kotlin.srcDir("src/nativeMain/kotlin")
                }

                dependencies {
                    implementation(project(":cimgui"))
                    implementation(project(":imgui"))
                    implementation("com.kgl:kgl-opengl:0.1.9-dev-5")
                }
            }
        }
    }
}
