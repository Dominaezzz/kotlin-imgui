package com.imgui

import cimgui.internal.ImGuiOnceUponAFrame_ImGuiOnceUponAFrame
import cimgui.internal.ImGuiOnceUponAFrame_destroy
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiOnceUponAFrame(
  val ptr: CPointer<cimgui.internal.ImGuiOnceUponAFrame>
) {
  actual val refFrame: Int
    get() = ptr.pointed.RefFrame

  actual constructor() : this(ImGuiOnceUponAFrame_ImGuiOnceUponAFrame()!!)

  actual fun destroy() {
    ImGuiOnceUponAFrame_destroy(ptr)
  }
}
