package com.imgui

import cimgui.internal.CImGui.ImGuiPlatformMonitor_ImGuiPlatformMonitor
import cimgui.internal.CImGui.ImGuiPlatformMonitor_destroy
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPlatformMonitor(
  val ptr: cimgui.internal.ImGuiPlatformMonitor
) {
  actual var mainPos: Vec2
    get() = ptr.mainPos.fromCValue()
    set(value) {
      ptr.mainPos.fromKValue(value)
    }

  actual var mainSize: Vec2
    get() = ptr.mainSize.fromCValue()
    set(value) {
      ptr.mainSize.fromKValue(value)
    }

  actual var workPos: Vec2
    get() = ptr.workPos.fromCValue()
    set(value) {
      ptr.workPos.fromKValue(value)
    }

  actual var workSize: Vec2
    get() = ptr.workSize.fromCValue()
    set(value) {
      ptr.workSize.fromKValue(value)
    }

  actual var dpiScale: Float
    get() = ptr.dpiScale
    set(value) {
      ptr.dpiScale = value
    }

  actual constructor() : this(ImGuiPlatformMonitor_ImGuiPlatformMonitor()!!)

  actual fun destroy() {
    ImGuiPlatformMonitor_destroy(ptr)
  }
}
