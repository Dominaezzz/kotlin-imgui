package com.imgui

import cimgui.internal.CImGui.ImGuiPlatformIO_ImGuiPlatformIO
import cimgui.internal.CImGui.ImGuiPlatformIO_destroy
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPlatformIO(
  val ptr: cimgui.internal.ImGuiPlatformIO
) {
  actual val mainViewport: ImGuiViewport?
    get() = ptr.mainViewport?.let(::ImGuiViewport)

  actual constructor() : this(ImGuiPlatformIO_ImGuiPlatformIO()!!)

  actual fun destroy() {
    ImGuiPlatformIO_destroy(ptr)
  }
}
