package com.imgui

import cimgui.internal.CImGui.ImGuiWindowTempData_ImGuiWindowTempData
import cimgui.internal.CImGui.ImGuiWindowTempData_destroy
import cimgui.internal.CImGui.shortArray_getitem
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiWindowTempData(
  val ptr: cimgui.internal.ImGuiWindowTempData
) {
  actual val cursorPos: Vec2
    get() = ptr.cursorPos.fromCValue()

  actual val cursorPosPrevLine: Vec2
    get() = ptr.cursorPosPrevLine.fromCValue()

  actual val cursorStartPos: Vec2
    get() = ptr.cursorStartPos.fromCValue()

  actual val cursorMaxPos: Vec2
    get() = ptr.cursorMaxPos.fromCValue()

  actual val currLineSize: Vec2
    get() = ptr.currLineSize.fromCValue()

  actual val prevLineSize: Vec2
    get() = ptr.prevLineSize.fromCValue()

  actual val currLineTextBaseOffset: Float
    get() = ptr.currLineTextBaseOffset

  actual val prevLineTextBaseOffset: Float
    get() = ptr.prevLineTextBaseOffset

  actual val lastItemId: ImGuiID
    get() = ptr.lastItemId.let(::ImGuiID)

  actual val lastItemStatusFlags: Flag<ImGuiItemStatusFlags>
    get() = ptr.lastItemStatusFlags.let { ImGuiItemStatusFlags.fromMultiple(it) }

  actual val navLayerCurrentMask: Int
    get() = ptr.navLayerCurrentMask

  actual val navLayerActiveMask: Int
    get() = ptr.navLayerActiveMask

  actual val navLayerActiveMaskNext: Int
    get() = ptr.navLayerActiveMaskNext

  actual val navFocusScopeIdCurrent: ImGuiID
    get() = ptr.navFocusScopeIdCurrent.let(::ImGuiID)

  actual val navHideHighlightOneFrame: Boolean
    get() = ptr.navHideHighlightOneFrame

  actual val navHasScroll: Boolean
    get() = ptr.navHasScroll

  actual val menuBarAppending: Boolean
    get() = ptr.menuBarAppending

  actual val menuBarOffset: Vec2
    get() = ptr.menuBarOffset.fromCValue()

  actual val treeDepth: Int
    get() = ptr.treeDepth

  actual val treeJumpToParentOnPopMask: UInt
    get() = ptr.treeJumpToParentOnPopMask.toUInt()

  actual val stateStorage: ImGuiStorage?
    get() = ptr.stateStorage?.let(::ImGuiStorage)

  actual val currentColumns: ImGuiColumns?
    get() = ptr.currentColumns?.let(::ImGuiColumns)

  actual val layoutType: ImGuiLayoutType
    get() = ptr.layoutType.let { ImGuiLayoutType.from(it) }

  actual val parentLayoutType: ImGuiLayoutType
    get() = ptr.parentLayoutType.let { ImGuiLayoutType.from(it) }

  actual val focusCounterRegular: Int
    get() = ptr.focusCounterRegular

  actual val focusCounterTabStop: Int
    get() = ptr.focusCounterTabStop

  actual val itemFlags: Flag<ImGuiItemFlags>
    get() = ptr.itemFlags.let { ImGuiItemFlags.fromMultiple(it) }

  actual val itemWidth: Float
    get() = ptr.itemWidth

  actual val textWrapPos: Float
    get() = ptr.textWrapPos

  actual constructor() : this(ImGuiWindowTempData_ImGuiWindowTempData()!!)

  actual fun stackSizesBackup(index: Int): Short {
    require(index in 0..6)
    return shortArray_getitem(ptr.stackSizesBackup, index)
  }

  actual fun destroy() {
    ImGuiWindowTempData_destroy(ptr)
  }
}
