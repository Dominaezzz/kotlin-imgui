[![GitHub license](https://img.shields.io/badge/license-MIT%20License%202.0-blue.svg?style=flat)](https://en.wikipedia.org/wiki/MIT_License)
[![Build Status](https://github.com/Dominaezzz/kotlin-imgui/workflows/Build/badge.svg)](https://github.com/Dominaezzz/kotlin-imgui/actions)

# Kotlin/Multiplatform bindings and wrapper for [Dear ImGui](https://github.com/ocornut/imgui)

This is meant to be a Kotlin-friendly wrapper (and binding) for Dear ImGui.
It is experimental, as I am iterating on the API design and considering optimisations.

The current implementations are based on [kgl](https://github.com/Dominaezzz/kgl) for OpenGL and GLFW.

To build, you just need to clone and run `./gradlew build`.

## Usage
```kotlin
repositories {
    maven("https://maven.pkg.github.com/Dominaezzz/kotlin-imgui") {
        credentials {
            username = System.getenv("GITHUB_USER") // Your GitHub username.
            password = System.getenv("GITHUB_TOKEN") // A GitHub token with `read:packages`.
        }
    }
}

dependencies {
    implementation("com.kotlin-imgui:imgui:$imguiVersion")
    implementation("com.kotlin-imgui:imgui-glfw:$imguiVersion")
    implementation("com.kotlin-imgui:imgui-opengl:$imguiVersion")

    // For jvm binaries
    implementation("com.kotlin-imgui:cimgui-jvmlinuxx64:$imguiVersion")
    implementation("com.kotlin-imgui:cimgui-jvmmacosx64:$imguiVersion")
    implementation("com.kotlin-imgui:cimgui-jvmmingwx64:$imguiVersion")

    // Optional
    implementation("com.kgl:kgl-glfw:$kglVersion")
    implementation("com.kgl:kgl-glfw-static:$kglVersion")
    implementation("com.kgl:kgl-opengl:$kglVersion")
}
```

After `kotlin-imgui` is set up in your application, you can use it from _anywhere_ in your program loop:
```kotlin
with(ImGui) {
    text("Hello, world ${123}")
    if (button("Save")) {
        mySaveFunction()
    }
    inputText("string", buf)
    sliderFloat("float", ::f, 0.0f, 1.0f)
}
```

Result:

![screenshot of sample code alongside its output with ImGui](https://raw.githubusercontent.com/wiki/ocornut/imgui/web/v160/code_sample_02.png)

_(settings: Dark style (left), Light style (right) / Font: Roboto-Medium, 16px / Rounding: 5)_

Code:
```kotlin
// Create a window called "My First Tool", with a menu bar.
begin("My First Tool", ::myToolActive, ImGuiWindowFlags.MenuBar)
menuBar {
    menu("File") {
        if (menuItem("Open..", "Ctrl+O")) { /* Do stuff */ }
        if (menuItem("Save", "Ctrl+S"))   { /* Do stuff */ }
        if (menuItem("Close", "Ctrl+W"))  { myToolActive = false }
    }
}

// Edit a color (stored as FloatArray[4])
colorEdit4("Color", myColor)

// Plot some values
val myValues = floatArrayOf(0.2f, 0.1f, 1f, 0.5f, 0.9f, 2.2f)
plotLines("Frame Times", myValues)
 
// Display contents in a scrolling region
textColored(Vec4(1.0f , 1.0f, 0.0f, 1.0f), "Important Stuff")
beginChild("Scrolling")
for (n in 0 until 50) {
    text("${n.toString().padStart(4, '0')}: Some text")
}
endChild()
end()
```

Result:

![screenshot of sample code alongside its output with ImGui](https://raw.githubusercontent.com/wiki/ocornut/imgui/web/v160/code_sample_03_color.gif)

More information about how the api work is [here](https://github.com/ocornut/imgui#how-it-works).

### Notes
- Functions with variadic/va_list arguments have been skipped See [#1](https://github.com/Dominaezzz/kotlin-imgui/issues/1). So formatting will have to be done in Koltin.
- If `ImGui.setNextWindowSizeConstraints` is called with a callback, it **must** be followed by a call to `ImGui.begin` to release the callback.
- Supports `LinuxX64`, `MingwX64` and `MacosX64` via JVM or Native. I will add more targets on demand.
- The safe api (wrapper) supports almost all of the original Dear ImGui api but if you need something it does not provide you can depend on `cimgui` and use it directly. Remember to play nice with the wrapper when doing so.
