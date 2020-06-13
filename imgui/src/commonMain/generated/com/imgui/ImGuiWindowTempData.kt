package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt

expect class ImGuiWindowTempData {
  val cursorPos: Vec2

  val cursorPosPrevLine: Vec2

  val cursorStartPos: Vec2

  val cursorMaxPos: Vec2

  val currLineSize: Vec2

  val prevLineSize: Vec2

  val currLineTextBaseOffset: Float

  val prevLineTextBaseOffset: Float

  val lastItemId: ImGuiID

  val lastItemStatusFlags: Flag<ImGuiItemStatusFlags>

  val navLayerCurrentMask: Int

  val navLayerActiveMask: Int

  val navLayerActiveMaskNext: Int

  val navFocusScopeIdCurrent: ImGuiID

  val navHideHighlightOneFrame: Boolean

  val navHasScroll: Boolean

  val menuBarAppending: Boolean

  val menuBarOffset: Vec2

  val treeDepth: Int

  val treeJumpToParentOnPopMask: UInt

  val stateStorage: ImGuiStorage?

  val currentColumns: ImGuiColumns?

  val layoutType: ImGuiLayoutType

  val parentLayoutType: ImGuiLayoutType

  val focusCounterRegular: Int

  val focusCounterTabStop: Int

  val itemFlags: Flag<ImGuiItemFlags>

  val itemWidth: Float

  val textWrapPos: Float

  constructor()

  fun stackSizesBackup(index: Int): Short

  fun destroy()
}
