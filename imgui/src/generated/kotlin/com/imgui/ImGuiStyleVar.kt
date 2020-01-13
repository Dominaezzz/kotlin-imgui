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
import kotlinx.cinterop.convert

enum class ImGuiStyleVar(
  val value: cimgui.internal.ImGuiStyleVar
) {
  Alpha(ImGuiStyleVar_Alpha.convert()),

  WindowPadding(ImGuiStyleVar_WindowPadding.convert()),

  WindowRounding(ImGuiStyleVar_WindowRounding.convert()),

  WindowBorderSize(ImGuiStyleVar_WindowBorderSize.convert()),

  WindowMinSize(ImGuiStyleVar_WindowMinSize.convert()),

  WindowTitleAlign(ImGuiStyleVar_WindowTitleAlign.convert()),

  ChildRounding(ImGuiStyleVar_ChildRounding.convert()),

  ChildBorderSize(ImGuiStyleVar_ChildBorderSize.convert()),

  PopupRounding(ImGuiStyleVar_PopupRounding.convert()),

  PopupBorderSize(ImGuiStyleVar_PopupBorderSize.convert()),

  FramePadding(ImGuiStyleVar_FramePadding.convert()),

  FrameRounding(ImGuiStyleVar_FrameRounding.convert()),

  FrameBorderSize(ImGuiStyleVar_FrameBorderSize.convert()),

  ItemSpacing(ImGuiStyleVar_ItemSpacing.convert()),

  ItemInnerSpacing(ImGuiStyleVar_ItemInnerSpacing.convert()),

  IndentSpacing(ImGuiStyleVar_IndentSpacing.convert()),

  ScrollbarSize(ImGuiStyleVar_ScrollbarSize.convert()),

  ScrollbarRounding(ImGuiStyleVar_ScrollbarRounding.convert()),

  GrabMinSize(ImGuiStyleVar_GrabMinSize.convert()),

  GrabRounding(ImGuiStyleVar_GrabRounding.convert()),

  TabRounding(ImGuiStyleVar_TabRounding.convert()),

  ButtonTextAlign(ImGuiStyleVar_ButtonTextAlign.convert()),

  SelectableTextAlign(ImGuiStyleVar_SelectableTextAlign.convert());

  companion object {
    fun from(value: cimgui.internal.ImGuiStyleVar): ImGuiStyleVar = when
        (value.convert<ImGuiStyleVar_>()) {
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
