package com.imgui

import cimgui.internal.CImGui.ImGuiPlatformMonitor_ImGuiPlatformMonitor
import cimgui.internal.CImGui.ImGuiPlatformMonitor_destroy
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPlatformMonitor(
  val ptr: cimgui.internal.ImGuiPlatformMonitor
) {
  actual val mainPos: Vec2
    get() = ptr.mainPos.fromCValue()

  actual val mainSize: Vec2
    get() = ptr.mainSize.fromCValue()

  actual val workPos: Vec2
    get() = ptr.workPos.fromCValue()

  actual val workSize: Vec2
    get() = ptr.workSize.fromCValue()

  actual val dpiScale: Float
    get() = ptr.dpiScale

  actual constructor() : this(ImGuiPlatformMonitor_ImGuiPlatformMonitor()!!)

  actual fun destroy() {
    ImGuiPlatformMonitor_destroy(ptr)
  }
}
