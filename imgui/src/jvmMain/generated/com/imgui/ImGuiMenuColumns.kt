package com.imgui

import cimgui.internal.CImGui
import cimgui.internal.CImGui.ImGuiMenuColumns_CalcExtraSpace
import cimgui.internal.CImGui.ImGuiMenuColumns_DeclColumns
import cimgui.internal.CImGui.ImGuiMenuColumns_ImGuiMenuColumns
import cimgui.internal.CImGui.ImGuiMenuColumns_Update
import cimgui.internal.CImGui.ImGuiMenuColumns_destroy
import cimgui.internal.CImGui.floatArray_getitem
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiMenuColumns(
  val ptr: cimgui.internal.ImGuiMenuColumns
) {
  actual val spacing: Float
    get() = ptr.spacing

  actual val width: Float
    get() = ptr.width

  actual val nextWidth: Float
    get() = ptr.nextWidth

  actual constructor() : this(ImGuiMenuColumns_ImGuiMenuColumns()!!)

  actual fun pos(index: Int): Float {
    require(index in 0..3)
    return floatArray_getitem(ptr.pos, index)
  }

  actual fun nextWidths(index: Int): Float {
    require(index in 0..3)
    return floatArray_getitem(ptr.nextWidths, index)
  }

  actual fun calcExtraSpace(availW: Float): Float = ImGuiMenuColumns_CalcExtraSpace(ptr, availW)

  actual fun declColumns(
    w0: Float,
    w1: Float,
    w2: Float
  ): Float = ImGuiMenuColumns_DeclColumns(ptr, w0, w1, w2)

  actual fun update(
    count: Int,
    spacing: Float,
    clear: Boolean
  ) {
    ImGuiMenuColumns_Update(ptr, count, spacing, clear)
  }

  actual fun destroy() {
    ImGuiMenuColumns_destroy(ptr)
  }
}
