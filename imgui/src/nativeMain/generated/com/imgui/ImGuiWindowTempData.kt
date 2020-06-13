package com.imgui

import cimgui.internal.ImGuiWindowTempData_ImGuiWindowTempData
import cimgui.internal.ImGuiWindowTempData_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.get
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiWindowTempData(
  val ptr: CPointer<cimgui.internal.ImGuiWindowTempData>
) {
  actual val cursorPos: Vec2
    get() = ptr.pointed.CursorPos.fromCValue()

  actual val cursorPosPrevLine: Vec2
    get() = ptr.pointed.CursorPosPrevLine.fromCValue()

  actual val cursorStartPos: Vec2
    get() = ptr.pointed.CursorStartPos.fromCValue()

  actual val cursorMaxPos: Vec2
    get() = ptr.pointed.CursorMaxPos.fromCValue()

  actual val currLineSize: Vec2
    get() = ptr.pointed.CurrLineSize.fromCValue()

  actual val prevLineSize: Vec2
    get() = ptr.pointed.PrevLineSize.fromCValue()

  actual val currLineTextBaseOffset: Float
    get() = ptr.pointed.CurrLineTextBaseOffset

  actual val prevLineTextBaseOffset: Float
    get() = ptr.pointed.PrevLineTextBaseOffset

  actual val lastItemId: ImGuiID
    get() = ptr.pointed.LastItemId.let(::ImGuiID)

  actual val lastItemStatusFlags: Flag<ImGuiItemStatusFlags>
    get() = ptr.pointed.LastItemStatusFlags.let { ImGuiItemStatusFlags.fromMultiple(it) }

  actual val navLayerCurrentMask: Int
    get() = ptr.pointed.NavLayerCurrentMask

  actual val navLayerActiveMask: Int
    get() = ptr.pointed.NavLayerActiveMask

  actual val navLayerActiveMaskNext: Int
    get() = ptr.pointed.NavLayerActiveMaskNext

  actual val navFocusScopeIdCurrent: ImGuiID
    get() = ptr.pointed.NavFocusScopeIdCurrent.let(::ImGuiID)

  actual val navHideHighlightOneFrame: Boolean
    get() = ptr.pointed.NavHideHighlightOneFrame

  actual val navHasScroll: Boolean
    get() = ptr.pointed.NavHasScroll

  actual val menuBarAppending: Boolean
    get() = ptr.pointed.MenuBarAppending

  actual val menuBarOffset: Vec2
    get() = ptr.pointed.MenuBarOffset.fromCValue()

  actual val treeDepth: Int
    get() = ptr.pointed.TreeDepth

  actual val treeJumpToParentOnPopMask: UInt
    get() = ptr.pointed.TreeJumpToParentOnPopMask.toUInt()

  actual val stateStorage: ImGuiStorage?
    get() = ptr.pointed.StateStorage?.let(::ImGuiStorage)

  actual val currentColumns: ImGuiColumns?
    get() = ptr.pointed.CurrentColumns?.let(::ImGuiColumns)

  actual val layoutType: ImGuiLayoutType
    get() = ptr.pointed.LayoutType.let { ImGuiLayoutType.from(it) }

  actual val parentLayoutType: ImGuiLayoutType
    get() = ptr.pointed.ParentLayoutType.let { ImGuiLayoutType.from(it) }

  actual val focusCounterRegular: Int
    get() = ptr.pointed.FocusCounterRegular

  actual val focusCounterTabStop: Int
    get() = ptr.pointed.FocusCounterTabStop

  actual val itemFlags: Flag<ImGuiItemFlags>
    get() = ptr.pointed.ItemFlags.let { ImGuiItemFlags.fromMultiple(it) }

  actual val itemWidth: Float
    get() = ptr.pointed.ItemWidth

  actual val textWrapPos: Float
    get() = ptr.pointed.TextWrapPos

  actual constructor() : this(ImGuiWindowTempData_ImGuiWindowTempData()!!)

  actual fun stackSizesBackup(index: Int): Short {
    require(index in 0..6)
    return ptr.pointed.StackSizesBackup.get(index)
  }

  actual fun destroy() {
    ImGuiWindowTempData_destroy(ptr)
  }
}
