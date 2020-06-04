package com.imgui

import cimgui.internal.ImGuiWindow_CalcFontSize
import cimgui.internal.ImGuiWindow_GetIDInt
import cimgui.internal.ImGuiWindow_GetIDNoKeepAliveInt
import cimgui.internal.ImGuiWindow_GetIDNoKeepAliveStr
import cimgui.internal.ImGuiWindow_GetIDStr
import cimgui.internal.ImGuiWindow_ImGuiWindow
import cimgui.internal.ImGuiWindow_MenuBarHeight
import cimgui.internal.ImGuiWindow_TitleBarHeight
import cimgui.internal.ImGuiWindow_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiWindow(
  val ptr: CPointer<cimgui.internal.ImGuiWindow>
) {
  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val flags: Flag<ImGuiWindowFlags>
    get() = ptr.pointed.Flags.let { ImGuiWindowFlags.fromMultiple(it) }

  actual val pos: Vec2
    get() = ptr.pointed.Pos.fromCValue()

  actual val size: Vec2
    get() = ptr.pointed.Size.fromCValue()

  actual val sizeFull: Vec2
    get() = ptr.pointed.SizeFull.fromCValue()

  actual val contentSize: Vec2
    get() = ptr.pointed.ContentSize.fromCValue()

  actual val contentSizeExplicit: Vec2
    get() = ptr.pointed.ContentSizeExplicit.fromCValue()

  actual val windowPadding: Vec2
    get() = ptr.pointed.WindowPadding.fromCValue()

  actual val windowRounding: Float
    get() = ptr.pointed.WindowRounding

  actual val windowBorderSize: Float
    get() = ptr.pointed.WindowBorderSize

  actual val nameBufLen: Int
    get() = ptr.pointed.NameBufLen

  actual val moveId: ImGuiID
    get() = ptr.pointed.MoveId.let(::ImGuiID)

  actual val childId: ImGuiID
    get() = ptr.pointed.ChildId.let(::ImGuiID)

  actual val scroll: Vec2
    get() = ptr.pointed.Scroll.fromCValue()

  actual val scrollMax: Vec2
    get() = ptr.pointed.ScrollMax.fromCValue()

  actual val scrollTarget: Vec2
    get() = ptr.pointed.ScrollTarget.fromCValue()

  actual val scrollTargetCenterRatio: Vec2
    get() = ptr.pointed.ScrollTargetCenterRatio.fromCValue()

  actual val scrollbarSizes: Vec2
    get() = ptr.pointed.ScrollbarSizes.fromCValue()

  actual val scrollbarX: Boolean
    get() = ptr.pointed.ScrollbarX

  actual val scrollbarY: Boolean
    get() = ptr.pointed.ScrollbarY

  actual val active: Boolean
    get() = ptr.pointed.Active

  actual val wasActive: Boolean
    get() = ptr.pointed.WasActive

  actual val writeAccessed: Boolean
    get() = ptr.pointed.WriteAccessed

  actual val collapsed: Boolean
    get() = ptr.pointed.Collapsed

  actual val wantCollapseToggle: Boolean
    get() = ptr.pointed.WantCollapseToggle

  actual val skipItems: Boolean
    get() = ptr.pointed.SkipItems

  actual val appearing: Boolean
    get() = ptr.pointed.Appearing

  actual val hidden: Boolean
    get() = ptr.pointed.Hidden

  actual val isFallbackWindow: Boolean
    get() = ptr.pointed.IsFallbackWindow

  actual val hasCloseButton: Boolean
    get() = ptr.pointed.HasCloseButton

  actual val beginCount: Short
    get() = ptr.pointed.BeginCount

  actual val beginOrderWithinParent: Short
    get() = ptr.pointed.BeginOrderWithinParent

  actual val beginOrderWithinContext: Short
    get() = ptr.pointed.BeginOrderWithinContext

  actual val popupId: ImGuiID
    get() = ptr.pointed.PopupId.let(::ImGuiID)

  actual val autoFitOnlyGrows: Boolean
    get() = ptr.pointed.AutoFitOnlyGrows

  actual val autoPosLastDirection: ImGuiDir
    get() = ptr.pointed.AutoPosLastDirection.let { ImGuiDir.from(it) }

  actual val hiddenFramesCanSkipItems: Int
    get() = ptr.pointed.HiddenFramesCanSkipItems

  actual val hiddenFramesCannotSkipItems: Int
    get() = ptr.pointed.HiddenFramesCannotSkipItems

  actual val setWindowPosAllowFlags: Flag<ImGuiCond>
    get() = ptr.pointed.SetWindowPosAllowFlags.let { ImGuiCond.fromMultiple(it) }

  actual val setWindowSizeAllowFlags: Flag<ImGuiCond>
    get() = ptr.pointed.SetWindowSizeAllowFlags.let { ImGuiCond.fromMultiple(it) }

  actual val setWindowCollapsedAllowFlags: Flag<ImGuiCond>
    get() = ptr.pointed.SetWindowCollapsedAllowFlags.let { ImGuiCond.fromMultiple(it) }

  actual val setWindowPosVal: Vec2
    get() = ptr.pointed.SetWindowPosVal.fromCValue()

  actual val setWindowPosPivot: Vec2
    get() = ptr.pointed.SetWindowPosPivot.fromCValue()

  actual val lastFrameActive: Int
    get() = ptr.pointed.LastFrameActive

  actual val lastTimeActive: Float
    get() = ptr.pointed.LastTimeActive

  actual val itemWidthDefault: Float
    get() = ptr.pointed.ItemWidthDefault

  actual val fontWindowScale: Float
    get() = ptr.pointed.FontWindowScale

  actual val settingsOffset: Int
    get() = ptr.pointed.SettingsOffset

  actual val drawList: ImDrawList?
    get() = ptr.pointed.DrawList?.let(::ImDrawList)

  actual val parentWindow: ImGuiWindow?
    get() = ptr.pointed.ParentWindow?.let(::ImGuiWindow)

  actual val rootWindow: ImGuiWindow?
    get() = ptr.pointed.RootWindow?.let(::ImGuiWindow)

  actual val rootWindowForTitleBarHighlight: ImGuiWindow?
    get() = ptr.pointed.RootWindowForTitleBarHighlight?.let(::ImGuiWindow)

  actual val rootWindowForNav: ImGuiWindow?
    get() = ptr.pointed.RootWindowForNav?.let(::ImGuiWindow)

  actual val navLastChildNavWindow: ImGuiWindow?
    get() = ptr.pointed.NavLastChildNavWindow?.let(::ImGuiWindow)

  actual val memoryCompacted: Boolean
    get() = ptr.pointed.MemoryCompacted

  actual val memoryDrawListIdxCapacity: Int
    get() = ptr.pointed.MemoryDrawListIdxCapacity

  actual val memoryDrawListVtxCapacity: Int
    get() = ptr.pointed.MemoryDrawListVtxCapacity

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
