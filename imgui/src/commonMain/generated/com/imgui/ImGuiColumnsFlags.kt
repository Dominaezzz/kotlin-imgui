package com.imgui

expect enum class ImGuiColumnsFlags : Flag<ImGuiColumnsFlags> {
  NoBorder,

  NoResize,

  NoPreserveWidths,

  NoForceWithinWindow,

  GrowParentContentsSize;

  companion object
}
