package com.imgui

import kotlin.Int

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

  val cValue: Int

  companion object {
    val CollapsingHeader: Flag<ImGuiTreeNodeFlags>
  }
}
