package com.imgui

import kotlin.Int

expect enum class ImGuiTabBarFlags : Flag<ImGuiTabBarFlags> {
  Reorderable,

  AutoSelectNewTabs,

  TabListPopupButton,

  NoCloseWithMiddleMouseButton,

  NoTabListScrollingButtons,

  NoTooltip,

  FittingPolicyResizeDown,

  FittingPolicyScroll;

  val cValue: Int

  companion object {
    val FittingPolicyMask_: Flag<ImGuiTabBarFlags>

    val FittingPolicyDefault_: Flag<ImGuiTabBarFlags>
  }
}
