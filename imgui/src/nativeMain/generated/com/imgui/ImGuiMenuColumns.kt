package com.imgui

import cimgui.internal.ImGuiMenuColumns_CalcExtraSpace
import cimgui.internal.ImGuiMenuColumns_DeclColumns
import cimgui.internal.ImGuiMenuColumns_ImGuiMenuColumns
import cimgui.internal.ImGuiMenuColumns_Update
import cimgui.internal.ImGuiMenuColumns_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.get
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiMenuColumns(
  val ptr: CPointer<cimgui.internal.ImGuiMenuColumns>
) {
  actual val spacing: Float
    get() = ptr.pointed.Spacing

  actual val width: Float
    get() = ptr.pointed.Width

  actual val nextWidth: Float
    get() = ptr.pointed.NextWidth

  actual constructor() : this(ImGuiMenuColumns_ImGuiMenuColumns()!!)

  actual fun pos(index: Int): Float {
    require(index in 0..3)
    return ptr.pointed.Pos.get(index)
  }

  actual fun nextWidths(index: Int): Float {
    require(index in 0..3)
    return ptr.pointed.NextWidths.get(index)
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
