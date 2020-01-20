package com.imgui

import cimgui.internal.ImGuiCol_
import cimgui.internal.ImGuiCol_Border
import cimgui.internal.ImGuiCol_BorderShadow
import cimgui.internal.ImGuiCol_Button
import cimgui.internal.ImGuiCol_ButtonActive
import cimgui.internal.ImGuiCol_ButtonHovered
import cimgui.internal.ImGuiCol_CheckMark
import cimgui.internal.ImGuiCol_ChildBg
import cimgui.internal.ImGuiCol_DragDropTarget
import cimgui.internal.ImGuiCol_FrameBg
import cimgui.internal.ImGuiCol_FrameBgActive
import cimgui.internal.ImGuiCol_FrameBgHovered
import cimgui.internal.ImGuiCol_Header
import cimgui.internal.ImGuiCol_HeaderActive
import cimgui.internal.ImGuiCol_HeaderHovered
import cimgui.internal.ImGuiCol_MenuBarBg
import cimgui.internal.ImGuiCol_ModalWindowDimBg
import cimgui.internal.ImGuiCol_NavHighlight
import cimgui.internal.ImGuiCol_NavWindowingDimBg
import cimgui.internal.ImGuiCol_NavWindowingHighlight
import cimgui.internal.ImGuiCol_PlotHistogram
import cimgui.internal.ImGuiCol_PlotHistogramHovered
import cimgui.internal.ImGuiCol_PlotLines
import cimgui.internal.ImGuiCol_PlotLinesHovered
import cimgui.internal.ImGuiCol_PopupBg
import cimgui.internal.ImGuiCol_ResizeGrip
import cimgui.internal.ImGuiCol_ResizeGripActive
import cimgui.internal.ImGuiCol_ResizeGripHovered
import cimgui.internal.ImGuiCol_ScrollbarBg
import cimgui.internal.ImGuiCol_ScrollbarGrab
import cimgui.internal.ImGuiCol_ScrollbarGrabActive
import cimgui.internal.ImGuiCol_ScrollbarGrabHovered
import cimgui.internal.ImGuiCol_Separator
import cimgui.internal.ImGuiCol_SeparatorActive
import cimgui.internal.ImGuiCol_SeparatorHovered
import cimgui.internal.ImGuiCol_SliderGrab
import cimgui.internal.ImGuiCol_SliderGrabActive
import cimgui.internal.ImGuiCol_Tab
import cimgui.internal.ImGuiCol_TabActive
import cimgui.internal.ImGuiCol_TabHovered
import cimgui.internal.ImGuiCol_TabUnfocused
import cimgui.internal.ImGuiCol_TabUnfocusedActive
import cimgui.internal.ImGuiCol_Text
import cimgui.internal.ImGuiCol_TextDisabled
import cimgui.internal.ImGuiCol_TextSelectedBg
import cimgui.internal.ImGuiCol_TitleBg
import cimgui.internal.ImGuiCol_TitleBgActive
import cimgui.internal.ImGuiCol_TitleBgCollapsed
import cimgui.internal.ImGuiCol_WindowBg
import kotlinx.cinterop.convert

actual enum class ImGuiCol(
  val value: cimgui.internal.ImGuiCol
) {
  Text(ImGuiCol_Text.convert()),

  TextDisabled(ImGuiCol_TextDisabled.convert()),

  WindowBg(ImGuiCol_WindowBg.convert()),

  ChildBg(ImGuiCol_ChildBg.convert()),

  PopupBg(ImGuiCol_PopupBg.convert()),

  Border(ImGuiCol_Border.convert()),

  BorderShadow(ImGuiCol_BorderShadow.convert()),

  FrameBg(ImGuiCol_FrameBg.convert()),

  FrameBgHovered(ImGuiCol_FrameBgHovered.convert()),

  FrameBgActive(ImGuiCol_FrameBgActive.convert()),

  TitleBg(ImGuiCol_TitleBg.convert()),

  TitleBgActive(ImGuiCol_TitleBgActive.convert()),

  TitleBgCollapsed(ImGuiCol_TitleBgCollapsed.convert()),

  MenuBarBg(ImGuiCol_MenuBarBg.convert()),

  ScrollbarBg(ImGuiCol_ScrollbarBg.convert()),

  ScrollbarGrab(ImGuiCol_ScrollbarGrab.convert()),

  ScrollbarGrabHovered(ImGuiCol_ScrollbarGrabHovered.convert()),

  ScrollbarGrabActive(ImGuiCol_ScrollbarGrabActive.convert()),

  CheckMark(ImGuiCol_CheckMark.convert()),

  SliderGrab(ImGuiCol_SliderGrab.convert()),

  SliderGrabActive(ImGuiCol_SliderGrabActive.convert()),

  Button(ImGuiCol_Button.convert()),

  ButtonHovered(ImGuiCol_ButtonHovered.convert()),

  ButtonActive(ImGuiCol_ButtonActive.convert()),

  Header(ImGuiCol_Header.convert()),

  HeaderHovered(ImGuiCol_HeaderHovered.convert()),

  HeaderActive(ImGuiCol_HeaderActive.convert()),

  Separator(ImGuiCol_Separator.convert()),

  SeparatorHovered(ImGuiCol_SeparatorHovered.convert()),

  SeparatorActive(ImGuiCol_SeparatorActive.convert()),

  ResizeGrip(ImGuiCol_ResizeGrip.convert()),

  ResizeGripHovered(ImGuiCol_ResizeGripHovered.convert()),

  ResizeGripActive(ImGuiCol_ResizeGripActive.convert()),

  Tab(ImGuiCol_Tab.convert()),

  TabHovered(ImGuiCol_TabHovered.convert()),

  TabActive(ImGuiCol_TabActive.convert()),

  TabUnfocused(ImGuiCol_TabUnfocused.convert()),

  TabUnfocusedActive(ImGuiCol_TabUnfocusedActive.convert()),

  PlotLines(ImGuiCol_PlotLines.convert()),

  PlotLinesHovered(ImGuiCol_PlotLinesHovered.convert()),

  PlotHistogram(ImGuiCol_PlotHistogram.convert()),

  PlotHistogramHovered(ImGuiCol_PlotHistogramHovered.convert()),

  TextSelectedBg(ImGuiCol_TextSelectedBg.convert()),

  DragDropTarget(ImGuiCol_DragDropTarget.convert()),

  NavHighlight(ImGuiCol_NavHighlight.convert()),

  NavWindowingHighlight(ImGuiCol_NavWindowingHighlight.convert()),

  NavWindowingDimBg(ImGuiCol_NavWindowingDimBg.convert()),

  ModalWindowDimBg(ImGuiCol_ModalWindowDimBg.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiCol): ImGuiCol = when (value.convert<ImGuiCol_>()) {
      ImGuiCol_Text -> Text
      ImGuiCol_TextDisabled -> TextDisabled
      ImGuiCol_WindowBg -> WindowBg
      ImGuiCol_ChildBg -> ChildBg
      ImGuiCol_PopupBg -> PopupBg
      ImGuiCol_Border -> Border
      ImGuiCol_BorderShadow -> BorderShadow
      ImGuiCol_FrameBg -> FrameBg
      ImGuiCol_FrameBgHovered -> FrameBgHovered
      ImGuiCol_FrameBgActive -> FrameBgActive
      ImGuiCol_TitleBg -> TitleBg
      ImGuiCol_TitleBgActive -> TitleBgActive
      ImGuiCol_TitleBgCollapsed -> TitleBgCollapsed
      ImGuiCol_MenuBarBg -> MenuBarBg
      ImGuiCol_ScrollbarBg -> ScrollbarBg
      ImGuiCol_ScrollbarGrab -> ScrollbarGrab
      ImGuiCol_ScrollbarGrabHovered -> ScrollbarGrabHovered
      ImGuiCol_ScrollbarGrabActive -> ScrollbarGrabActive
      ImGuiCol_CheckMark -> CheckMark
      ImGuiCol_SliderGrab -> SliderGrab
      ImGuiCol_SliderGrabActive -> SliderGrabActive
      ImGuiCol_Button -> Button
      ImGuiCol_ButtonHovered -> ButtonHovered
      ImGuiCol_ButtonActive -> ButtonActive
      ImGuiCol_Header -> Header
      ImGuiCol_HeaderHovered -> HeaderHovered
      ImGuiCol_HeaderActive -> HeaderActive
      ImGuiCol_Separator -> Separator
      ImGuiCol_SeparatorHovered -> SeparatorHovered
      ImGuiCol_SeparatorActive -> SeparatorActive
      ImGuiCol_ResizeGrip -> ResizeGrip
      ImGuiCol_ResizeGripHovered -> ResizeGripHovered
      ImGuiCol_ResizeGripActive -> ResizeGripActive
      ImGuiCol_Tab -> Tab
      ImGuiCol_TabHovered -> TabHovered
      ImGuiCol_TabActive -> TabActive
      ImGuiCol_TabUnfocused -> TabUnfocused
      ImGuiCol_TabUnfocusedActive -> TabUnfocusedActive
      ImGuiCol_PlotLines -> PlotLines
      ImGuiCol_PlotLinesHovered -> PlotLinesHovered
      ImGuiCol_PlotHistogram -> PlotHistogram
      ImGuiCol_PlotHistogramHovered -> PlotHistogramHovered
      ImGuiCol_TextSelectedBg -> TextSelectedBg
      ImGuiCol_DragDropTarget -> DragDropTarget
      ImGuiCol_NavHighlight -> NavHighlight
      ImGuiCol_NavWindowingHighlight -> NavWindowingHighlight
      ImGuiCol_NavWindowingDimBg -> NavWindowingDimBg
      ImGuiCol_ModalWindowDimBg -> ModalWindowDimBg
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
