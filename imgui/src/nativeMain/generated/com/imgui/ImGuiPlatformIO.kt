package com.imgui

import cimgui.internal.ImGuiPlatformIO_ImGuiPlatformIO
import cimgui.internal.ImGuiPlatformIO_destroy
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPlatformIO(
  val ptr: CPointer<cimgui.internal.ImGuiPlatformIO>
) {
  actual val mainViewport: ImGuiViewport?
    get() = ptr.pointed.MainViewport?.let(::ImGuiViewport)

  actual constructor() : this(ImGuiPlatformIO_ImGuiPlatformIO()!!)

  actual fun destroy() {
    ImGuiPlatformIO_destroy(ptr)
  }
}
