package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String

expect class ImGuiWindow {
  val id: ImGuiID

  val flags: Flag<ImGuiWindowFlags>

  val pos: Vec2

  val size: Vec2

  val sizeFull: Vec2

  val contentSize: Vec2

  val contentSizeExplicit: Vec2

  val windowPadding: Vec2

  val windowRounding: Float

  val windowBorderSize: Float

  val nameBufLen: Int

  val moveId: ImGuiID

  val childId: ImGuiID

  val scroll: Vec2

  val scrollMax: Vec2

  val scrollTarget: Vec2

  val scrollTargetCenterRatio: Vec2

  val scrollbarSizes: Vec2

  val scrollbarX: Boolean

  val scrollbarY: Boolean

  val active: Boolean

  val wasActive: Boolean

  val writeAccessed: Boolean

  val collapsed: Boolean

  val wantCollapseToggle: Boolean

  val skipItems: Boolean

  val appearing: Boolean

  val hidden: Boolean

  val isFallbackWindow: Boolean

  val hasCloseButton: Boolean

  val beginCount: Short

  val beginOrderWithinParent: Short

  val beginOrderWithinContext: Short

  val popupId: ImGuiID

  val autoFitOnlyGrows: Boolean

  val autoPosLastDirection: ImGuiDir

  val hiddenFramesCanSkipItems: Int

  val hiddenFramesCannotSkipItems: Int

  val setWindowPosAllowFlags: Flag<ImGuiCond>

  val setWindowSizeAllowFlags: Flag<ImGuiCond>

  val setWindowCollapsedAllowFlags: Flag<ImGuiCond>

  val setWindowPosVal: Vec2

  val setWindowPosPivot: Vec2

  val lastFrameActive: Int

  val lastTimeActive: Float

  val itemWidthDefault: Float

  val fontWindowScale: Float

  val settingsOffset: Int

  val drawList: ImDrawList?

  val parentWindow: ImGuiWindow?

  val rootWindow: ImGuiWindow?

  val rootWindowForTitleBarHighlight: ImGuiWindow?

  val rootWindowForNav: ImGuiWindow?

  val navLastChildNavWindow: ImGuiWindow?

  val memoryCompacted: Boolean

  val memoryDrawListIdxCapacity: Int

  val memoryDrawListVtxCapacity: Int

  constructor(context: ImGuiContext, name: String)

  fun calcFontSize(): Float

  fun getID(str: String, strEnd: String? = null): ImGuiID

  fun getID(n: Int): ImGuiID

  fun getIDNoKeepAlive(str: String, strEnd: String? = null): ImGuiID

  fun getIDNoKeepAlive(n: Int): ImGuiID

  fun menuBarHeight(): Float

  fun titleBarHeight(): Float

  fun destroy()
}
