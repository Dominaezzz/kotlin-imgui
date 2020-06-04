package com.imgui

import cimgui.internal.CImGui.ImGuiTabBar_GetTabName
import cimgui.internal.CImGui.ImGuiTabBar_GetTabOrder
import cimgui.internal.CImGui.ImGuiTabBar_ImGuiTabBar
import cimgui.internal.CImGui.ImGuiTabBar_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTabBar(
  val ptr: cimgui.internal.ImGuiTabBar
) {
  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val selectedTabId: ImGuiID
    get() = ptr.selectedTabId.let(::ImGuiID)

  actual val nextSelectedTabId: ImGuiID
    get() = ptr.nextSelectedTabId.let(::ImGuiID)

  actual val visibleTabId: ImGuiID
    get() = ptr.visibleTabId.let(::ImGuiID)

  actual val currFrameVisible: Int
    get() = ptr.currFrameVisible

  actual val prevFrameVisible: Int
    get() = ptr.prevFrameVisible

  actual val lastTabContentHeight: Float
    get() = ptr.lastTabContentHeight

  actual val offsetMax: Float
    get() = ptr.offsetMax

  actual val offsetMaxIdeal: Float
    get() = ptr.offsetMaxIdeal

  actual val offsetNextTab: Float
    get() = ptr.offsetNextTab

  actual val scrollingAnim: Float
    get() = ptr.scrollingAnim

  actual val scrollingTarget: Float
    get() = ptr.scrollingTarget

  actual val scrollingTargetDistToVisibility: Float
    get() = ptr.scrollingTargetDistToVisibility

  actual val scrollingSpeed: Float
    get() = ptr.scrollingSpeed

  actual val flags: Flag<ImGuiTabBarFlags>
    get() = ptr.flags.let { ImGuiTabBarFlags.fromMultiple(it) }

  actual val reorderRequestTabId: ImGuiID
    get() = ptr.reorderRequestTabId.let(::ImGuiID)

  actual val wantLayout: Boolean
    get() = ptr.wantLayout

  actual val visibleTabWasSubmitted: Boolean
    get() = ptr.visibleTabWasSubmitted

  actual val lastTabItemIdx: Short
    get() = ptr.lastTabItemIdx

  actual val framePadding: Vec2
    get() = ptr.framePadding.fromCValue()

  actual constructor() : this(ImGuiTabBar_ImGuiTabBar()!!)

  actual fun getTabName(tab: ImGuiTabItem): String? = ImGuiTabBar_GetTabName(ptr, tab.ptr)

  actual fun getTabOrder(tab: ImGuiTabItem): Int = ImGuiTabBar_GetTabOrder(ptr, tab.ptr)

  actual fun destroy() {
    ImGuiTabBar_destroy(ptr)
  }
}
