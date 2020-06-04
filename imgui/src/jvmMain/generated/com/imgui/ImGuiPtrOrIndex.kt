package com.imgui

import cimgui.internal.CImGui.ImGuiPtrOrIndex_ImGuiPtrOrIndexInt
import cimgui.internal.CImGui.ImGuiPtrOrIndex_destroy
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPtrOrIndex(
  val ptr: cimgui.internal.ImGuiPtrOrIndex
) {
  actual val index: Int
    get() = ptr.index

  actual constructor(index: Int) : this(ImGuiPtrOrIndex_ImGuiPtrOrIndexInt(index)!!)

  actual fun destroy() {
    ImGuiPtrOrIndex_destroy(ptr)
  }
}
