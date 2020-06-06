package com.imgui

import cimgui.internal.ImGuiNextWindowData_ClearFlags
import cimgui.internal.ImGuiNextWindowData_ImGuiNextWindowData
import cimgui.internal.ImGuiNextWindowData_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiNextWindowData(
  val ptr: CPointer<cimgui.internal.ImGuiNextWindowData>
) {
  actual val flags: Flag<ImGuiNextWindowDataFlags>
    get() = ptr.pointed.Flags.let { ImGuiNextWindowDataFlags.fromMultiple(it) }

  actual val posCond: Flag<ImGuiCond>
    get() = ptr.pointed.PosCond.let { ImGuiCond.fromMultiple(it) }

  actual val sizeCond: Flag<ImGuiCond>
    get() = ptr.pointed.SizeCond.let { ImGuiCond.fromMultiple(it) }

  actual val collapsedCond: Flag<ImGuiCond>
    get() = ptr.pointed.CollapsedCond.let { ImGuiCond.fromMultiple(it) }

  actual val dockCond: Flag<ImGuiCond>
    get() = ptr.pointed.DockCond.let { ImGuiCond.fromMultiple(it) }

  actual val posVal: Vec2
    get() = ptr.pointed.PosVal.fromCValue()

  actual val posPivotVal: Vec2
    get() = ptr.pointed.PosPivotVal.fromCValue()

  actual val sizeVal: Vec2
    get() = ptr.pointed.SizeVal.fromCValue()

  actual val contentSizeVal: Vec2
    get() = ptr.pointed.ContentSizeVal.fromCValue()

  actual val scrollVal: Vec2
    get() = ptr.pointed.ScrollVal.fromCValue()

  actual val posUndock: Boolean
    get() = ptr.pointed.PosUndock

  actual val collapsedVal: Boolean
    get() = ptr.pointed.CollapsedVal

  actual val bgAlphaVal: Float
    get() = ptr.pointed.BgAlphaVal

  actual val viewportId: ImGuiID
    get() = ptr.pointed.ViewportId.let(::ImGuiID)

  actual val dockId: ImGuiID
    get() = ptr.pointed.DockId.let(::ImGuiID)

  actual val menuBarOffsetMinVal: Vec2
    get() = ptr.pointed.MenuBarOffsetMinVal.fromCValue()

  actual constructor() : this(ImGuiNextWindowData_ImGuiNextWindowData()!!)

  actual fun clearFlags() {
    ImGuiNextWindowData_ClearFlags(ptr)
  }

  actual fun destroy() {
    ImGuiNextWindowData_destroy(ptr)
  }
}
