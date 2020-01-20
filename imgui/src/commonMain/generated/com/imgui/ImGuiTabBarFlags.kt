package com.imgui

expect enum class ImGuiTabBarFlags : Flag<ImGuiTabBarFlags> {
  Reorderable,

  AutoSelectNewTabs,

  TabListPopupButton,

  NoCloseWithMiddleMouseButton,

  NoTabListScrollingButtons,

  NoTooltip,

  FittingPolicyResizeDown,

  FittingPolicyScroll;

  companion object {
    val FittingPolicyMask_: Flag<ImGuiTabBarFlags>

    val FittingPolicyDefault_: Flag<ImGuiTabBarFlags>
  }
}
