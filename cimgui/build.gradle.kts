import de.undercouch.gradle.tasks.download.Download
import org.gradle.internal.jvm.Jvm
import org.gradle.nativeplatform.OperatingSystemFamily.*
import org.gradle.nativeplatform.MachineArchitecture.*
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.KonanTarget
import org.jetbrains.kotlin.konan.target.presetName

plugins {
    kotlin("multiplatform")
    id("de.undercouch.download")
    `maven-publish`
}

val useSingleTarget: Boolean by rootProject.extra
val imGuiVersion: String by rootProject.extra

val konanUserDir = file(System.getenv("KONAN_DATA_DIR") ?: "${System.getProperty("user.home")}/.konan")
val konanDeps = konanUserDir.resolve("dependencies")
val toolChainFolder = when (HostManager.host) {
    KonanTarget.LINUX_X64 -> "clang-llvm-8.0.0-linux-x86-64"
    KonanTarget.MACOS_X64 -> "clang-llvm-apple-8.0.0-darwin-macos"
    KonanTarget.MINGW_X64 -> "msys2-mingw-w64-x86_64-clang-llvm-lld-compiler_rt-8.0.1"
    else -> TODO()
}
val llvmBinFolder = konanDeps.resolve(toolChainFolder).resolve("bin")
val androidSysRootParent = konanDeps.resolve("target-sysroot-1-android_ndk").resolve("android-21")

data class TargetInfo(val targetName: String, val sysRoot: File, val clangArgs: List<String> = emptyList())
val targetInfoMap = mapOf(
        KonanTarget.LINUX_X64 to TargetInfo(
                "x86_64-unknown-linux-gnu",
                konanDeps.resolve("target-gcc-toolchain-3-linux-x86-64/x86_64-unknown-linux-gnu/sysroot")
        ),
        KonanTarget.MACOS_X64 to TargetInfo(
                "x86_64-apple-darwin10", // Not sure about this but it doesn't matter yet.
                konanDeps.resolve("target-sysroot-10-macos_x64")
        ),
        KonanTarget.MINGW_X64 to TargetInfo(
                "x86_64-w64-mingw32",
                konanDeps.resolve("msys2-mingw-w64-x86_64-clang-llvm-lld-compiler_rt-8.0.1")
        ),
        KonanTarget.MINGW_X86 to TargetInfo(
                "i686-w64-mingw32",
                konanDeps.resolve("msys2-mingw-w64-i686-clang-llvm-lld-compiler_rt-8.0.1")
        ),
        KonanTarget.LINUX_ARM32_HFP to TargetInfo(
                "armv6-unknown-linux-gnueabihf",
                konanDeps.resolve("target-sysroot-2-raspberrypi"),
                listOf("-mfpu=vfp", "-mfloat-abi=hard")
        ),
        KonanTarget.ANDROID_ARM32 to TargetInfo(
                "arm-linux-androideabi",
                androidSysRootParent.resolve("arch-arm")
        ),
        KonanTarget.ANDROID_ARM64 to TargetInfo(
                "aarch64-linux-android",
                androidSysRootParent.resolve("arch-arm64")
        ),
        KonanTarget.ANDROID_X86 to TargetInfo(
                "i686-linux-android",
                androidSysRootParent.resolve("arch-x86")
        ),
        KonanTarget.ANDROID_X64 to TargetInfo(
                "x86_64-linux-android",
                androidSysRootParent.resolve("arch-x64")
        )
)

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
val jvmSourceFiles = sourceFiles + file("src/jvmMain/cpp/wrap.cpp")
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
    if (!useSingleTarget) linuxArm32Hfp()

    jvm {
        withJava()
        compilations {
            "main" {
                defaultSourceSet {
                    kotlin.srcDir("src/jvmMain/java")
                    kotlin.srcDir("src/jvmMain/kotlin")
                }
                dependencies {
                    implementation(kotlin("stdlib-jdk8"))
                }
            }
            "test" {
                dependencies {
                    implementation(kotlin("test"))
                    implementation(kotlin("test-junit"))
                }
            }
        }
    }

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
        val libDir = buildDir.resolve("lib").resolve(targetName)

        val objDir = libDir.resolve("obj")
        val staticLibFile = libDir.resolve("libimgui.a")

        val objFiles = objFileNames.map { objDir.resolve(it) }
        val compileImGui = tasks.register<Exec>("compileImGuiFor$targetName") {
            dependsOn(extractImGui, extractCWrapper)
            onlyIf { HostManager().isEnabled(konanTarget) }
            doFirst { mkdir(objDir) }

            inputs.files(sourceFiles)
            outputs.files(objFiles)

            environment("PATH", "$llvmBinFolder;${System.getenv("PATH")}")
            if (konanTarget == KonanTarget.MACOS_X64) {
                environment("CPATH", "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include")
            }

            executable = llvmBinFolder.resolve("clang++").absolutePath

            val targetInfo = targetInfoMap.getValue(konanTarget)
            if (HostManager.host != konanTarget) args("-target", targetInfo.targetName)
            args("--sysroot=${targetInfo.sysRoot}")
            args(targetInfo.clangArgs)
            args(
                    "-c", "-w",
                    "-I${imguiDir}", "-I${cimguiOutput}", "-I${cimguiDir}",
                    "-working-directory", objDir.absolutePath
            )
            args(sourceFiles.map { it.absolutePath })
        }
        val archiveImGui = tasks.register<Exec>("archiveImGuiFor$targetName") {
            dependsOn(compileImGui)
            onlyIf { HostManager().isEnabled(konanTarget) }

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
                            // This is to ensure native toolchain is downloaded before compiling with it.
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

    data class JvmTargetInfo(val target: KonanTarget, val osFamily: OperatingSystemFamily, val machineArchitecture: MachineArchitecture)
    val jvmTargets = listOf(
            JvmTargetInfo(KonanTarget.LINUX_X64, objects.named(LINUX), objects.named(X86_64)),
            JvmTargetInfo(KonanTarget.LINUX_ARM32_HFP, objects.named(LINUX), objects.named("arm32-hfp")),
            JvmTargetInfo(KonanTarget.MACOS_X64, objects.named(MACOS), objects.named(X86_64)),
            JvmTargetInfo(KonanTarget.MINGW_X64, objects.named(WINDOWS), objects.named(X86_64))
            // JvmTargetInfo(KonanTarget.MINGW_X86, objects.named(WINDOWS), objects.named(X86))
    )

    for ((jvmTarget, osFamily, osArch) in jvmTargets) {
        val jvmGenResourceDir = buildDir.resolve("resources")
        val resourceDir = jvmGenResourceDir.resolve(jvmTarget.presetName)

        val compileCImGui = tasks.register<Exec>("compileJniLibFor${jvmTarget.presetName.capitalize()}") {
            dependsOn(extractImGui, extractCWrapper)
            dependsOn("cinteropCimgui${jvmTarget.presetName.capitalize()}")
            onlyIf { HostManager.host == jvmTarget }

            val binaryDir = resourceDir.resolve("linux").resolve("x64")
            doFirst { mkdir(binaryDir) }

            val dynLibraryFile = binaryDir.resolve("libcimgui.${jvmTarget.family.dynamicSuffix}")

            inputs.files(jvmSourceFiles)
            outputs.file(dynLibraryFile)

            environment("PATH", "$llvmBinFolder;${System.getenv("PATH")}")
            if (jvmTarget == KonanTarget.MACOS_X64) {
                environment("CPATH", "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include")
            }
            executable = llvmBinFolder.resolve("clang++").absolutePath

            val targetInfo = targetInfoMap.getValue(jvmTarget)
            if (HostManager.host != jvmTarget) {
                args("-target", targetInfo.targetName)
                args("--sysroot=${targetInfo.sysRoot}")
            }
            if (HostManager.hostIsMingw) {
                args("-fdeclspec")
            } else {
                args("-fPIC")
            }
            args(targetInfo.clangArgs)
            args(
                    "-shared", "-Wall",
                    "-I${imguiDir}", "-I${cimguiOutput}", "-I${cimguiDir}",
                    "-I${Jvm.current().javaHome.resolve("include")}",
                    "-I${Jvm.current().javaHome.resolve("include").resolve(HostManager.jniHostPlatformIncludeDir)}",
                    "-o", dynLibraryFile.absolutePath
            )
            args(jvmSourceFiles.map { it.absolutePath })
        }

        jvm("jvm${jvmTarget.presetName.capitalize()}") {
            compilations {
                "main" {
                    compileKotlinTask.dependsOn(compileCImGui)
                    defaultSourceSet {
                        resources.srcDir(resourceDir.absolutePath)
                    }
                    dependencies {
                        implementation(kotlin("stdlib-jdk8"))
                    }
                }
                "test" {
                    dependencies {
                        implementation(kotlin("test"))
                        implementation(kotlin("test-junit"))
                    }
                }
            }

            attributes {
                attribute(OPERATING_SYSTEM_ATTRIBUTE, osFamily)
                attribute(ARCHITECTURE_ATTRIBUTE,     osArch)
            }
        }
    }
}
