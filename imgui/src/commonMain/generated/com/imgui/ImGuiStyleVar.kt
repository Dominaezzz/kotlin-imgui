package com.imgui

import kotlin.Int

expect enum class ImGuiStyleVar {
  Alpha,

  WindowPadding,

  WindowRounding,

  WindowBorderSize,

  WindowMinSize,

  WindowTitleAlign,

  ChildRounding,

  ChildBorderSize,

  PopupRounding,

  PopupBorderSize,

  FramePadding,

  FrameRounding,

  FrameBorderSize,

  ItemSpacing,

  ItemInnerSpacing,

  IndentSpacing,

  ScrollbarSize,

  ScrollbarRounding,

  GrabMinSize,

  GrabRounding,

  TabRounding,

  ButtonTextAlign,

  SelectableTextAlign;

  val cValue: Int

  companion object
}
