package com.imgui

import cimgui.internal.CImGui.ImGuiNextWindowData_ClearFlags
import cimgui.internal.CImGui.ImGuiNextWindowData_ImGuiNextWindowData
import cimgui.internal.CImGui.ImGuiNextWindowData_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiNextWindowData(
  val ptr: cimgui.internal.ImGuiNextWindowData
) {
  actual val flags: Flag<ImGuiNextWindowDataFlags>
    get() = ptr.flags.let { ImGuiNextWindowDataFlags.fromMultiple(it) }

  actual val posCond: Flag<ImGuiCond>
    get() = ptr.posCond.let { ImGuiCond.fromMultiple(it) }

  actual val sizeCond: Flag<ImGuiCond>
    get() = ptr.sizeCond.let { ImGuiCond.fromMultiple(it) }

  actual val collapsedCond: Flag<ImGuiCond>
    get() = ptr.collapsedCond.let { ImGuiCond.fromMultiple(it) }

  actual val posVal: Vec2
    get() = ptr.posVal.fromCValue()

  actual val posPivotVal: Vec2
    get() = ptr.posPivotVal.fromCValue()

  actual val sizeVal: Vec2
    get() = ptr.sizeVal.fromCValue()

  actual val contentSizeVal: Vec2
    get() = ptr.contentSizeVal.fromCValue()

  actual val collapsedVal: Boolean
    get() = ptr.collapsedVal

  actual val bgAlphaVal: Float
    get() = ptr.bgAlphaVal

  actual val menuBarOffsetMinVal: Vec2
    get() = ptr.menuBarOffsetMinVal.fromCValue()

  actual constructor() : this(ImGuiNextWindowData_ImGuiNextWindowData()!!)

  actual fun clearFlags() {
    ImGuiNextWindowData_ClearFlags(ptr)
  }

  actual fun destroy() {
    ImGuiNextWindowData_destroy(ptr)
  }
}
