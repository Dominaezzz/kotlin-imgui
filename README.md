[![Download](https://api.bintray.com/packages/dominaezzz/kotlin-native/kotlin-imgui/images/download.svg)](https://bintray.com/dominaezzz/kotlin-native/kotlin-imgui/_latestVersion)
[![GitHub license](https://img.shields.io/badge/license-MIT%20License%202.0-blue.svg?style=flat)](https://en.wikipedia.org/wiki/MIT_License)
[![Build Status](https://github.com/Dominaezzz/kotlin-imgui/workflows/Build/badge.svg)](https://github.com/Dominaezzz/kotlin-imgui/actions)

# Kotlin bindings and wrapper for [Dear ImGui](https://github.com/ocornut/imgui)

## Supported platforms
- [x] LinuxX64
- [x] MingwX64
- [ ] MingwX86
- [x] MacosX64
- [ ] IosArm32
- [ ] IosArm64
- [ ] IosX64
- [ ] JVM

## Usage
```kotlin
repositories {
    maven("https://dl.bintray.com/dominaezzz/kotlin-native")
    jcenter()
}

dependencies {
    implementation("com.kotlin-imgui:imgui:$imguiVersion")
    implementation("com.kotlin-imgui:imgui-glfw:$imguiVersion")
    implementation("com.kotlin-imgui:imgui-opengl:$imguiVersion")

    // Optional
    implementation("com.kgl:kgl-glfw:$kglVersion")
    implementation("com.kgl:kgl-glfw-static:$kglVersion")
    implementation("com.kgl:kgl-opengl:$kglVersion")
}
```
