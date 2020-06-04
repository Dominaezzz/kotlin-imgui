package com.imgui

import cimgui.internal.CImGui.ImGuiColumnData_ImGuiColumnData
import cimgui.internal.CImGui.ImGuiColumnData_destroy
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiColumnData(
  val ptr: cimgui.internal.ImGuiColumnData
) {
  actual val offsetNorm: Float
    get() = ptr.offsetNorm

  actual val offsetNormBeforeResize: Float
    get() = ptr.offsetNormBeforeResize

  actual val flags: Flag<ImGuiColumnsFlags>
    get() = ptr.flags.let { ImGuiColumnsFlags.fromMultiple(it) }

  actual constructor() : this(ImGuiColumnData_ImGuiColumnData()!!)

  actual fun destroy() {
    ImGuiColumnData_destroy(ptr)
  }
}
