package com.imgui

import cimgui.internal.ImGuiTabBarFlags_AutoSelectNewTabs
import cimgui.internal.ImGuiTabBarFlags_FittingPolicyResizeDown
import cimgui.internal.ImGuiTabBarFlags_FittingPolicyScroll
import cimgui.internal.ImGuiTabBarFlags_NoCloseWithMiddleMouseButton
import cimgui.internal.ImGuiTabBarFlags_NoTabListScrollingButtons
import cimgui.internal.ImGuiTabBarFlags_NoTooltip
import cimgui.internal.ImGuiTabBarFlags_Reorderable
import cimgui.internal.ImGuiTabBarFlags_TabListPopupButton
import kotlin.Int

enum class ImGuiTabBarFlags(
  override val value: Int
) : Flag<ImGuiTabBarFlags> {
  Reorderable(ImGuiTabBarFlags_Reorderable.toInt()),

  AutoSelectNewTabs(ImGuiTabBarFlags_AutoSelectNewTabs.toInt()),

  TabListPopupButton(ImGuiTabBarFlags_TabListPopupButton.toInt()),

  NoCloseWithMiddleMouseButton(ImGuiTabBarFlags_NoCloseWithMiddleMouseButton.toInt()),

  NoTabListScrollingButtons(ImGuiTabBarFlags_NoTabListScrollingButtons.toInt()),

  NoTooltip(ImGuiTabBarFlags_NoTooltip.toInt()),

  FittingPolicyResizeDown(ImGuiTabBarFlags_FittingPolicyResizeDown.toInt()),

  FittingPolicyScroll(ImGuiTabBarFlags_FittingPolicyScroll.toInt());

  override val info: Flag.EnumInfo<ImGuiTabBarFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTabBarFlags> = Flag.enumInfo()
  }
}
