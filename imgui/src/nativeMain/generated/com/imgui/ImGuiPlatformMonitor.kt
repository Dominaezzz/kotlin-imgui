package com.imgui

import cimgui.internal.ImGuiPlatformMonitor_ImGuiPlatformMonitor
import cimgui.internal.ImGuiPlatformMonitor_destroy
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPlatformMonitor(
  val ptr: CPointer<cimgui.internal.ImGuiPlatformMonitor>
) {
  actual var mainPos: Vec2
    get() = ptr.pointed.MainPos.fromCValue()
    set(value) {
      ptr.pointed.MainPos.fromKValue(value)
    }

  actual var mainSize: Vec2
    get() = ptr.pointed.MainSize.fromCValue()
    set(value) {
      ptr.pointed.MainSize.fromKValue(value)
    }

  actual var workPos: Vec2
    get() = ptr.pointed.WorkPos.fromCValue()
    set(value) {
      ptr.pointed.WorkPos.fromKValue(value)
    }

  actual var workSize: Vec2
    get() = ptr.pointed.WorkSize.fromCValue()
    set(value) {
      ptr.pointed.WorkSize.fromKValue(value)
    }

  actual var dpiScale: Float
    get() = ptr.pointed.DpiScale
    set(value) {
      ptr.pointed.DpiScale = value
    }

  actual constructor() : this(ImGuiPlatformMonitor_ImGuiPlatformMonitor()!!)

  actual fun destroy() {
    ImGuiPlatformMonitor_destroy(ptr)
  }
}
