import de.undercouch.gradle.tasks.download.*
import org.gradle.internal.jvm.*
import org.gradle.nativeplatform.MachineArchitecture.*
import org.gradle.nativeplatform.OperatingSystemFamily.*
import org.jetbrains.kotlin.gradle.plugin.mpp.*
import org.jetbrains.kotlin.konan.target.*
import org.jetbrains.kotlin.konan.target.Architecture

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
	else -> error("unknown host")
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
		"x86_64-apple-darwin10",
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
val cimguiDir = downloadsDir.resolve("cimgui-$imGuiVersion")
val cimguiOutput = cimguiDir.resolve("generator/output")
val imguiDir = cimguiDir.resolve("imgui")
val libsDir = buildDir.resolve("libs")

val downloadCWrapper by tasks.registering(Download::class) {
	src("https://github.com/cimgui/cimgui/archive/$imGuiVersion.zip")
	dest(downloadsDir.resolve("cimgui.zip"))
	overwrite(false)
}
val extractCWrapper by tasks.registering(Copy::class) {
	from(downloadCWrapper.map { zipTree(it.dest) })
	into(downloadsDir)
}

val downloadImGui by tasks.registering(Download::class) {
	src("https://github.com/ocornut/imgui/archive/v$imGuiVersion.zip")
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

val swigJavaDir = buildDir.resolve("generated-src/jvm/java")
val swigCppDir = buildDir.resolve("generated-src/jvm/cpp")
val runSwig by tasks.registering(Exec::class) {
	dependsOn(extractCWrapper)

	val swigInterfaceDir = file("src/nativeInterop/swig")
	val swigCimguiDir = swigJavaDir.resolve("cimgui/internal")
	doFirst {
		delete(swigCimguiDir.listFiles { file: File -> file.extension == "java" }!!)
	}

	inputs.dir(swigInterfaceDir)
	outputs.dirs(swigCimguiDir, swigCppDir)

	executable = "swig"
	workingDir = swigInterfaceDir.absoluteFile

	args("-java", "-c++")
	args("-package", "cimgui.internal")
	args("-outdir", swigCimguiDir.absolutePath)
	args("-o", swigCppDir.resolve("wrap.cpp").absolutePath)
	args("-I$cimguiOutput")
	args("-DCIMGUI_DEFINE_ENUMS_AND_STRUCTS")
	args("cimgui.i")
}

val sourceFiles = listOf(
	imguiDir.resolve("imgui.cpp"),
	imguiDir.resolve("imgui_draw.cpp"),
	imguiDir.resolve("imgui_demo.cpp"),
	imguiDir.resolve("imgui_widgets.cpp"),
	cimguiOutput.resolve("cimgui.cpp")
)
val jvmSourceFiles = sourceFiles + swigCppDir.resolve("wrap.cpp")
val objFileNames = listOf(
	"imgui.o",
	"imgui_draw.o",
	"imgui_demo.o",
	"imgui_widgets.o",
	"cimgui.o"
)

kotlin {
	jvm {
		withJava()
		compilations {
			all { kotlinOptions.jvmTarget = "1.8" }
			named("main") {
				compileKotlinTask.dependsOn(runSwig)
			}
		}
	}

	val jvmTargets =
		if (useSingleTarget) listOf(HostManager.host)
		else listOf(
			KonanTarget.LINUX_X64,
			KonanTarget.MACOS_X64,
			KonanTarget.MINGW_X64
		)

	val osFamilyMap = mapOf<Family, OperatingSystemFamily>(
		Family.LINUX to objects.named(LINUX),
		Family.OSX to objects.named(MACOS),
		Family.MINGW to objects.named(WINDOWS)
	)
	val osArchMap = mapOf<Architecture, MachineArchitecture>(
		Architecture.X86 to objects.named(X86),
		Architecture.X64 to objects.named(X86_64),
		Architecture.ARM32 to objects.named("arm32"),
		Architecture.ARM64 to objects.named("arm64")
	)

	for (jvmTarget in jvmTargets) {
		val targetSuffix = jvmTarget.presetName.capitalize()
		val resourceDir = buildDir.resolve("resources/${jvmTarget.presetName}")

		val compileCImGui = tasks.register<Exec>("compileJniLibFor$targetSuffix") {
			dependsOn(extractImGui, extractCWrapper)
			dependsOn("cinteropCimgui$targetSuffix")
			onlyIf { HostManager.host == jvmTarget }

			val binaryDir = resourceDir.resolve("${osFamilyMap[jvmTarget.family]}")
				.resolve(jvmTarget.architecture.toString().toLowerCase())
			doFirst { mkdir(binaryDir) }

			val dynLibraryFile = binaryDir.resolve("libcimgui.${jvmTarget.family.dynamicSuffix}")

			inputs.files(jvmSourceFiles)
			outputs.file(dynLibraryFile)

			environment("PATH", "$llvmBinFolder;${System.getenv("PATH")}")
			if (jvmTarget == KonanTarget.MACOS_X64) {
				environment(
					"CPATH",
					"/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include"
				)
			}
			executable = llvmBinFolder.resolve("clang++").absolutePath

			val targetInfo = targetInfoMap.getValue(jvmTarget)
			if (HostManager.host != jvmTarget) {
				args("-target", targetInfo.targetName)
				args("--sysroot=${targetInfo.sysRoot}")
			}
			if (HostManager.hostIsMingw) {
				args(
					"-fdeclspec",
					"-static-libgcc",
					"-static-libstdc++",
					"-Wl,-Bstatic,--whole-archive",
					"-lwinpthread",
					"-Wl,--no-whole-archive,-Bdynamic"
				)
			} else {
				args("-fPIC")
			}
			args(targetInfo.clangArgs)
			args(
				"-shared", "-Wall",
				"-I$imguiDir", "-I$cimguiOutput", "-I$cimguiDir",
				"-I${Jvm.current().javaHome.resolve("include")}",
				"-I${Jvm.current().javaHome.resolve("include/${HostManager.jniHostPlatformIncludeDir}")}",
				"-o", dynLibraryFile.absolutePath
			)
			args(jvmSourceFiles.map { it.absolutePath })
		}

		jvm("jvm$targetSuffix") {
			compilations {
				all { kotlinOptions.jvmTarget = "1.8" }
				named("main") {
					compileKotlinTask.dependsOn(compileCImGui)
				}
			}

			attributes {
				attribute(OPERATING_SYSTEM_ATTRIBUTE, osFamilyMap.getValue(jvmTarget.family))
				attribute(ARCHITECTURE_ATTRIBUTE, osArchMap.getValue(jvmTarget.architecture))
			}
		}
	}

	// cannot have names because of jvm architecture dependency
	if (!useSingleTarget || HostManager.hostIsLinux) linuxX64()
	if (!useSingleTarget || HostManager.hostIsMac) macosX64()
	if (!useSingleTarget || HostManager.hostIsMingw) mingwX64()

	targets.withType<KotlinNativeTarget> {
		val libDir = buildDir.resolve("lib").resolve(name)

		val objDir = libDir.resolve("obj")
		val staticLibFile = libDir.resolve("libimgui.a")

		val objFiles = objFileNames.map { objDir.resolve(it) }
		val compileImGui = tasks.register<Exec>("compileImGuiFor${name.capitalize()}") {
			dependsOn(extractImGui, extractCWrapper)
			onlyIf { HostManager().isEnabled(konanTarget) }
			doFirst { mkdir(objDir) }

			inputs.files(sourceFiles)
			outputs.files(objFiles)

			environment("PATH", "$llvmBinFolder;${System.getenv("PATH")}")
			if (konanTarget == KonanTarget.MACOS_X64) {
				environment(
					"CPATH",
					"/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include"
				)
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
		val archiveImGui = tasks.register<Exec>("archiveImGuiFor${name.capitalize()}") {
			dependsOn(compileImGui)
			onlyIf { HostManager().isEnabled(konanTarget) }

			inputs.files(objFiles)
			outputs.file(staticLibFile)

			environment("PATH", "$llvmBinFolder;${System.getenv("PATH")}")
			executable = llvmBinFolder.resolve("llvm-ar").absolutePath
			args("rc", staticLibFile.absolutePath)
			args(objFiles.map { it.absolutePath })
		}

		compilations.named("main") {
			cinterops.create("cimgui") {
				includeDirs(cimguiOutput, imguiDir)
				tasks.named(interopProcessingTaskName) {
					dependsOn(extractImGui, extractCWrapper)
				}
				compileImGui {
					// This is to ensure native toolchain is downloaded before compiling with it.
					dependsOn(tasks.named(interopProcessingTaskName))
				}
			}

			compileKotlinTask.dependsOn(archiveImGui)
			kotlinOptions {
				freeCompilerArgs = listOf("-include-binary", staticLibFile.absolutePath)
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

		named("jvmMain") {}

		named("jvmTest") {
			dependencies {
				implementation(kotlin("test-junit"))
			}
		}

		for (jvmTarget in jvmTargets) {
			val targetSuffix = jvmTarget.presetName.capitalize()
			val resourceDir = buildDir.resolve("resources/${jvmTarget.presetName}")

			named("jvm${targetSuffix}Main") {
				resources.srcDir(resourceDir.absolutePath)
			}

			named("jvm${targetSuffix}Test") {
				dependencies {
					implementation(kotlin("test-junit"))
				}
			}
		}
	}
}

java {
	sourceSets {
		named("main") {
			java.srcDir(swigJavaDir)
		}
	}
}
