package com.imgui

import cimgui.internal.ImGuiTabBar_GetTabName
import cimgui.internal.ImGuiTabBar_GetTabOrder
import cimgui.internal.ImGuiTabBar_ImGuiTabBar
import cimgui.internal.ImGuiTabBar_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTabBar(
  val ptr: CPointer<cimgui.internal.ImGuiTabBar>
) {
  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val selectedTabId: ImGuiID
    get() = ptr.pointed.SelectedTabId.let(::ImGuiID)

  actual val nextSelectedTabId: ImGuiID
    get() = ptr.pointed.NextSelectedTabId.let(::ImGuiID)

  actual val visibleTabId: ImGuiID
    get() = ptr.pointed.VisibleTabId.let(::ImGuiID)

  actual val currFrameVisible: Int
    get() = ptr.pointed.CurrFrameVisible

  actual val prevFrameVisible: Int
    get() = ptr.pointed.PrevFrameVisible

  actual val lastTabContentHeight: Float
    get() = ptr.pointed.LastTabContentHeight

  actual val offsetMax: Float
    get() = ptr.pointed.OffsetMax

  actual val offsetMaxIdeal: Float
    get() = ptr.pointed.OffsetMaxIdeal

  actual val offsetNextTab: Float
    get() = ptr.pointed.OffsetNextTab

  actual val scrollingAnim: Float
    get() = ptr.pointed.ScrollingAnim

  actual val scrollingTarget: Float
    get() = ptr.pointed.ScrollingTarget

  actual val scrollingTargetDistToVisibility: Float
    get() = ptr.pointed.ScrollingTargetDistToVisibility

  actual val scrollingSpeed: Float
    get() = ptr.pointed.ScrollingSpeed

  actual val flags: Flag<ImGuiTabBarFlags>
    get() = ptr.pointed.Flags.let { ImGuiTabBarFlags.fromMultiple(it) }

  actual val reorderRequestTabId: ImGuiID
    get() = ptr.pointed.ReorderRequestTabId.let(::ImGuiID)

  actual val wantLayout: Boolean
    get() = ptr.pointed.WantLayout

  actual val visibleTabWasSubmitted: Boolean
    get() = ptr.pointed.VisibleTabWasSubmitted

  actual val lastTabItemIdx: Short
    get() = ptr.pointed.LastTabItemIdx

  actual val framePadding: Vec2
    get() = ptr.pointed.FramePadding.fromCValue()

  actual constructor() : this(ImGuiTabBar_ImGuiTabBar()!!)

  actual fun getTabName(tab: ImGuiTabItem): String? = ImGuiTabBar_GetTabName(ptr,
      tab.ptr)?.toKString()

  actual fun getTabOrder(tab: ImGuiTabItem): Int = ImGuiTabBar_GetTabOrder(ptr, tab.ptr)

  actual fun destroy() {
    ImGuiTabBar_destroy(ptr)
  }
}
