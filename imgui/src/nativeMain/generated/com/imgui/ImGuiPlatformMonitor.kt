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
  actual val mainPos: Vec2
    get() = ptr.pointed.MainPos.fromCValue()

  actual val mainSize: Vec2
    get() = ptr.pointed.MainSize.fromCValue()

  actual val workPos: Vec2
    get() = ptr.pointed.WorkPos.fromCValue()

  actual val workSize: Vec2
    get() = ptr.pointed.WorkSize.fromCValue()

  actual val dpiScale: Float
    get() = ptr.pointed.DpiScale

  actual constructor() : this(ImGuiPlatformMonitor_ImGuiPlatformMonitor()!!)

  actual fun destroy() {
    ImGuiPlatformMonitor_destroy(ptr)
  }
}
