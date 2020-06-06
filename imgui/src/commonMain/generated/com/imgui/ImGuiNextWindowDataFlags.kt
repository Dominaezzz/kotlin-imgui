package com.imgui

expect enum class ImGuiNextWindowDataFlags : Flag<ImGuiNextWindowDataFlags> {
  HasPos,

  HasSize,

  HasContentSize,

  HasCollapsed,

  HasSizeConstraint,

  HasFocus,

  HasBgAlpha,

  HasScroll,

  HasViewport,

  HasDock,

  HasWindowClass;

  companion object
}
