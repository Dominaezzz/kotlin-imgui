package com.imgui

import cimgui.internal.CImGui.ImGuiOnceUponAFrame_ImGuiOnceUponAFrame
import cimgui.internal.CImGui.ImGuiOnceUponAFrame_destroy
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiOnceUponAFrame(
  val ptr: cimgui.internal.ImGuiOnceUponAFrame
) {
  actual val refFrame: Int
    get() = ptr.refFrame

  actual constructor() : this(ImGuiOnceUponAFrame_ImGuiOnceUponAFrame()!!)

  actual fun destroy() {
    ImGuiOnceUponAFrame_destroy(ptr)
  }
}
