package com.imgui

import cimgui.internal.ImGuiStyleVar_
import cimgui.internal.ImGuiStyleVar_Alpha
import cimgui.internal.ImGuiStyleVar_ButtonTextAlign
import cimgui.internal.ImGuiStyleVar_ChildBorderSize
import cimgui.internal.ImGuiStyleVar_ChildRounding
import cimgui.internal.ImGuiStyleVar_FrameBorderSize
import cimgui.internal.ImGuiStyleVar_FramePadding
import cimgui.internal.ImGuiStyleVar_FrameRounding
import cimgui.internal.ImGuiStyleVar_GrabMinSize
import cimgui.internal.ImGuiStyleVar_GrabRounding
import cimgui.internal.ImGuiStyleVar_IndentSpacing
import cimgui.internal.ImGuiStyleVar_ItemInnerSpacing
import cimgui.internal.ImGuiStyleVar_ItemSpacing
import cimgui.internal.ImGuiStyleVar_PopupBorderSize
import cimgui.internal.ImGuiStyleVar_PopupRounding
import cimgui.internal.ImGuiStyleVar_ScrollbarRounding
import cimgui.internal.ImGuiStyleVar_ScrollbarSize
import cimgui.internal.ImGuiStyleVar_SelectableTextAlign
import cimgui.internal.ImGuiStyleVar_TabRounding
import cimgui.internal.ImGuiStyleVar_WindowBorderSize
import cimgui.internal.ImGuiStyleVar_WindowMinSize
import cimgui.internal.ImGuiStyleVar_WindowPadding
import cimgui.internal.ImGuiStyleVar_WindowRounding
import cimgui.internal.ImGuiStyleVar_WindowTitleAlign

enum class ImGuiStyleVar(
  val value: ImGuiStyleVar_
) {
  Alpha(ImGuiStyleVar_Alpha),

  WindowPadding(ImGuiStyleVar_WindowPadding),

  WindowRounding(ImGuiStyleVar_WindowRounding),

  WindowBorderSize(ImGuiStyleVar_WindowBorderSize),

  WindowMinSize(ImGuiStyleVar_WindowMinSize),

  WindowTitleAlign(ImGuiStyleVar_WindowTitleAlign),

  ChildRounding(ImGuiStyleVar_ChildRounding),

  ChildBorderSize(ImGuiStyleVar_ChildBorderSize),

  PopupRounding(ImGuiStyleVar_PopupRounding),

  PopupBorderSize(ImGuiStyleVar_PopupBorderSize),

  FramePadding(ImGuiStyleVar_FramePadding),

  FrameRounding(ImGuiStyleVar_FrameRounding),

  FrameBorderSize(ImGuiStyleVar_FrameBorderSize),

  ItemSpacing(ImGuiStyleVar_ItemSpacing),

  ItemInnerSpacing(ImGuiStyleVar_ItemInnerSpacing),

  IndentSpacing(ImGuiStyleVar_IndentSpacing),

  ScrollbarSize(ImGuiStyleVar_ScrollbarSize),

  ScrollbarRounding(ImGuiStyleVar_ScrollbarRounding),

  GrabMinSize(ImGuiStyleVar_GrabMinSize),

  GrabRounding(ImGuiStyleVar_GrabRounding),

  TabRounding(ImGuiStyleVar_TabRounding),

  ButtonTextAlign(ImGuiStyleVar_ButtonTextAlign),

  SelectableTextAlign(ImGuiStyleVar_SelectableTextAlign);
}
