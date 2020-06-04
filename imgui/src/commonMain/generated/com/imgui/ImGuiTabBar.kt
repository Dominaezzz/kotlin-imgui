package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String

expect class ImGuiTabBar {
  val id: ImGuiID

  val selectedTabId: ImGuiID

  val nextSelectedTabId: ImGuiID

  val visibleTabId: ImGuiID

  val currFrameVisible: Int

  val prevFrameVisible: Int

  val lastTabContentHeight: Float

  val offsetMax: Float

  val offsetMaxIdeal: Float

  val offsetNextTab: Float

  val scrollingAnim: Float

  val scrollingTarget: Float

  val scrollingTargetDistToVisibility: Float

  val scrollingSpeed: Float

  val flags: Flag<ImGuiTabBarFlags>

  val reorderRequestTabId: ImGuiID

  val wantLayout: Boolean

  val visibleTabWasSubmitted: Boolean

  val lastTabItemIdx: Short

  val framePadding: Vec2

  constructor()

  fun getTabName(tab: ImGuiTabItem): String?

  fun getTabOrder(tab: ImGuiTabItem): Int

  fun destroy()
}
