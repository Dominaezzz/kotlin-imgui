package com.imgui

import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_Alpha
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_ButtonTextAlign
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_ChildBorderSize
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_ChildRounding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_FrameBorderSize
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_FramePadding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_FrameRounding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_GrabMinSize
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_GrabRounding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_IndentSpacing
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_ItemInnerSpacing
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_ItemSpacing
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_PopupBorderSize
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_PopupRounding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_ScrollbarRounding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_ScrollbarSize
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_SelectableTextAlign
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_TabRounding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_WindowBorderSize
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_WindowMinSize
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_WindowPadding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_WindowRounding
import cimgui.internal.ImGuiStyleVar_.ImGuiStyleVar_WindowTitleAlign
import kotlin.Int

actual enum class ImGuiStyleVar(
  val value: Int
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

  actual companion object {
    fun from(value: Int): ImGuiStyleVar = when (value) {
      ImGuiStyleVar_Alpha -> Alpha
      ImGuiStyleVar_WindowPadding -> WindowPadding
      ImGuiStyleVar_WindowRounding -> WindowRounding
      ImGuiStyleVar_WindowBorderSize -> WindowBorderSize
      ImGuiStyleVar_WindowMinSize -> WindowMinSize
      ImGuiStyleVar_WindowTitleAlign -> WindowTitleAlign
      ImGuiStyleVar_ChildRounding -> ChildRounding
      ImGuiStyleVar_ChildBorderSize -> ChildBorderSize
      ImGuiStyleVar_PopupRounding -> PopupRounding
      ImGuiStyleVar_PopupBorderSize -> PopupBorderSize
      ImGuiStyleVar_FramePadding -> FramePadding
      ImGuiStyleVar_FrameRounding -> FrameRounding
      ImGuiStyleVar_FrameBorderSize -> FrameBorderSize
      ImGuiStyleVar_ItemSpacing -> ItemSpacing
      ImGuiStyleVar_ItemInnerSpacing -> ItemInnerSpacing
      ImGuiStyleVar_IndentSpacing -> IndentSpacing
      ImGuiStyleVar_ScrollbarSize -> ScrollbarSize
      ImGuiStyleVar_ScrollbarRounding -> ScrollbarRounding
      ImGuiStyleVar_GrabMinSize -> GrabMinSize
      ImGuiStyleVar_GrabRounding -> GrabRounding
      ImGuiStyleVar_TabRounding -> TabRounding
      ImGuiStyleVar_ButtonTextAlign -> ButtonTextAlign
      ImGuiStyleVar_SelectableTextAlign -> SelectableTextAlign
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
