package com.imgui

expect enum class ImGuiNextWindowDataFlags : Flag<ImGuiNextWindowDataFlags> {
  HasPos,

  HasSize,

  HasContentSize,

  HasCollapsed,

  HasSizeConstraint,

  HasFocus,

  HasBgAlpha;

  companion object
}
