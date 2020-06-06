package com.imgui

import cimgui.internal.CImGui.ImGuiWindow_CalcFontSize
import cimgui.internal.CImGui.ImGuiWindow_GetIDInt
import cimgui.internal.CImGui.ImGuiWindow_GetIDNoKeepAliveInt
import cimgui.internal.CImGui.ImGuiWindow_GetIDNoKeepAliveStr
import cimgui.internal.CImGui.ImGuiWindow_GetIDStr
import cimgui.internal.CImGui.ImGuiWindow_ImGuiWindow
import cimgui.internal.CImGui.ImGuiWindow_MenuBarHeight
import cimgui.internal.CImGui.ImGuiWindow_TitleBarHeight
import cimgui.internal.CImGui.ImGuiWindow_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiWindow(
  val ptr: cimgui.internal.ImGuiWindow
) {
  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val flags: Flag<ImGuiWindowFlags>
    get() = ptr.flags.let { ImGuiWindowFlags.fromMultiple(it) }

  actual val flagsPreviousFrame: Flag<ImGuiWindowFlags>
    get() = ptr.flagsPreviousFrame.let { ImGuiWindowFlags.fromMultiple(it) }

  actual val viewport: ImGuiViewportP?
    get() = ptr.viewport?.let(::ImGuiViewportP)

  actual val viewportId: ImGuiID
    get() = ptr.viewportId.let(::ImGuiID)

  actual val viewportPos: Vec2
    get() = ptr.viewportPos.fromCValue()

  actual val viewportAllowPlatformMonitorExtend: Int
    get() = ptr.viewportAllowPlatformMonitorExtend

  actual val pos: Vec2
    get() = ptr.pos.fromCValue()

  actual val size: Vec2
    get() = ptr.size.fromCValue()

  actual val sizeFull: Vec2
    get() = ptr.sizeFull.fromCValue()

  actual val contentSize: Vec2
    get() = ptr.contentSize.fromCValue()

  actual val contentSizeExplicit: Vec2
    get() = ptr.contentSizeExplicit.fromCValue()

  actual val windowPadding: Vec2
    get() = ptr.windowPadding.fromCValue()

  actual val windowRounding: Float
    get() = ptr.windowRounding

  actual val windowBorderSize: Float
    get() = ptr.windowBorderSize

  actual val nameBufLen: Int
    get() = ptr.nameBufLen

  actual val moveId: ImGuiID
    get() = ptr.moveId.let(::ImGuiID)

  actual val childId: ImGuiID
    get() = ptr.childId.let(::ImGuiID)

  actual val scroll: Vec2
    get() = ptr.scroll.fromCValue()

  actual val scrollMax: Vec2
    get() = ptr.scrollMax.fromCValue()

  actual val scrollTarget: Vec2
    get() = ptr.scrollTarget.fromCValue()

  actual val scrollTargetCenterRatio: Vec2
    get() = ptr.scrollTargetCenterRatio.fromCValue()

  actual val scrollbarSizes: Vec2
    get() = ptr.scrollbarSizes.fromCValue()

  actual val scrollbarX: Boolean
    get() = ptr.scrollbarX

  actual val scrollbarY: Boolean
    get() = ptr.scrollbarY

  actual val viewportOwned: Boolean
    get() = ptr.viewportOwned

  actual val active: Boolean
    get() = ptr.active

  actual val wasActive: Boolean
    get() = ptr.wasActive

  actual val writeAccessed: Boolean
    get() = ptr.writeAccessed

  actual val collapsed: Boolean
    get() = ptr.collapsed

  actual val wantCollapseToggle: Boolean
    get() = ptr.wantCollapseToggle

  actual val skipItems: Boolean
    get() = ptr.skipItems

  actual val appearing: Boolean
    get() = ptr.appearing

  actual val hidden: Boolean
    get() = ptr.hidden

  actual val isFallbackWindow: Boolean
    get() = ptr.isFallbackWindow

  actual val hasCloseButton: Boolean
    get() = ptr.hasCloseButton

  actual val beginCount: Short
    get() = ptr.beginCount

  actual val beginOrderWithinParent: Short
    get() = ptr.beginOrderWithinParent

  actual val beginOrderWithinContext: Short
    get() = ptr.beginOrderWithinContext

  actual val popupId: ImGuiID
    get() = ptr.popupId.let(::ImGuiID)

  actual val autoFitOnlyGrows: Boolean
    get() = ptr.autoFitOnlyGrows

  actual val autoPosLastDirection: ImGuiDir
    get() = ptr.autoPosLastDirection.let { ImGuiDir.from(it) }

  actual val hiddenFramesCanSkipItems: Int
    get() = ptr.hiddenFramesCanSkipItems

  actual val hiddenFramesCannotSkipItems: Int
    get() = ptr.hiddenFramesCannotSkipItems

  actual val setWindowPosAllowFlags: Flag<ImGuiCond>
    get() = ptr.setWindowPosAllowFlags.let { ImGuiCond.fromMultiple(it) }

  actual val setWindowSizeAllowFlags: Flag<ImGuiCond>
    get() = ptr.setWindowSizeAllowFlags.let { ImGuiCond.fromMultiple(it) }

  actual val setWindowCollapsedAllowFlags: Flag<ImGuiCond>
    get() = ptr.setWindowCollapsedAllowFlags.let { ImGuiCond.fromMultiple(it) }

  actual val setWindowDockAllowFlags: Flag<ImGuiCond>
    get() = ptr.setWindowDockAllowFlags.let { ImGuiCond.fromMultiple(it) }

  actual val setWindowPosVal: Vec2
    get() = ptr.setWindowPosVal.fromCValue()

  actual val setWindowPosPivot: Vec2
    get() = ptr.setWindowPosPivot.fromCValue()

  actual val lastFrameActive: Int
    get() = ptr.lastFrameActive

  actual val lastFrameJustFocused: Int
    get() = ptr.lastFrameJustFocused

  actual val lastTimeActive: Float
    get() = ptr.lastTimeActive

  actual val itemWidthDefault: Float
    get() = ptr.itemWidthDefault

  actual val fontWindowScale: Float
    get() = ptr.fontWindowScale

  actual val fontDpiScale: Float
    get() = ptr.fontDpiScale

  actual val settingsOffset: Int
    get() = ptr.settingsOffset

  actual val drawList: ImDrawList?
    get() = ptr.drawList?.let(::ImDrawList)

  actual val parentWindow: ImGuiWindow?
    get() = ptr.parentWindow?.let(::ImGuiWindow)

  actual val rootWindow: ImGuiWindow?
    get() = ptr.rootWindow?.let(::ImGuiWindow)

  actual val rootWindowDockStop: ImGuiWindow?
    get() = ptr.rootWindowDockStop?.let(::ImGuiWindow)

  actual val rootWindowForTitleBarHighlight: ImGuiWindow?
    get() = ptr.rootWindowForTitleBarHighlight?.let(::ImGuiWindow)

  actual val rootWindowForNav: ImGuiWindow?
    get() = ptr.rootWindowForNav?.let(::ImGuiWindow)

  actual val navLastChildNavWindow: ImGuiWindow?
    get() = ptr.navLastChildNavWindow?.let(::ImGuiWindow)

  actual val memoryCompacted: Boolean
    get() = ptr.memoryCompacted

  actual val memoryDrawListIdxCapacity: Int
    get() = ptr.memoryDrawListIdxCapacity

  actual val memoryDrawListVtxCapacity: Int
    get() = ptr.memoryDrawListVtxCapacity

  actual val dockNode: ImGuiDockNode?
    get() = ptr.dockNode?.let(::ImGuiDockNode)

  actual val dockNodeAsHost: ImGuiDockNode?
    get() = ptr.dockNodeAsHost?.let(::ImGuiDockNode)

  actual val dockId: ImGuiID
    get() = ptr.dockId.let(::ImGuiID)

  actual val dockTabItemStatusFlags: Flag<ImGuiItemStatusFlags>
    get() = ptr.dockTabItemStatusFlags.let { ImGuiItemStatusFlags.fromMultiple(it) }

  actual val dockOrder: Short
    get() = ptr.dockOrder

  actual val dockIsActive: Boolean
    get() = ptr.dockIsActive

  actual val dockTabIsVisible: Boolean
    get() = ptr.dockTabIsVisible

  actual val dockTabWantClose: Boolean
    get() = ptr.dockTabWantClose

  actual constructor(context: ImGuiContext, name: String) :
      this(ImGuiWindow_ImGuiWindow(context.ptr, name)!!)

  actual fun calcFontSize(): Float = ImGuiWindow_CalcFontSize(ptr)

  actual fun getID(str: String, strEnd: String?): ImGuiID = ImGuiWindow_GetIDStr(ptr, str,
      strEnd).let(::ImGuiID)

  actual fun getID(n: Int): ImGuiID = ImGuiWindow_GetIDInt(ptr, n).let(::ImGuiID)

  actual fun getIDNoKeepAlive(str: String, strEnd: String?): ImGuiID =
      ImGuiWindow_GetIDNoKeepAliveStr(ptr, str, strEnd).let(::ImGuiID)

  actual fun getIDNoKeepAlive(n: Int): ImGuiID = ImGuiWindow_GetIDNoKeepAliveInt(ptr,
      n).let(::ImGuiID)

  actual fun menuBarHeight(): Float = ImGuiWindow_MenuBarHeight(ptr)

  actual fun titleBarHeight(): Float = ImGuiWindow_TitleBarHeight(ptr)

  actual fun destroy() {
    ImGuiWindow_destroy(ptr)
  }
}
