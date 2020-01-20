package com.imgui

expect enum class ImGuiTreeNodeFlags : Flag<ImGuiTreeNodeFlags> {
  Selected,

  Framed,

  AllowItemOverlap,

  NoTreePushOnOpen,

  NoAutoOpenOnLog,

  DefaultOpen,

  OpenOnDoubleClick,

  OpenOnArrow,

  Leaf,

  Bullet,

  FramePadding,

  SpanAvailWidth,

  SpanFullWidth,

  NavLeftJumpsBackHere;

  companion object {
    val CollapsingHeader: Flag<ImGuiTreeNodeFlags>
  }
}
