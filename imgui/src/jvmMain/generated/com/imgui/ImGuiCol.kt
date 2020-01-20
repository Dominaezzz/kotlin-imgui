package com.imgui

import cimgui.internal.ImGuiCol_.ImGuiCol_Border
import cimgui.internal.ImGuiCol_.ImGuiCol_BorderShadow
import cimgui.internal.ImGuiCol_.ImGuiCol_Button
import cimgui.internal.ImGuiCol_.ImGuiCol_ButtonActive
import cimgui.internal.ImGuiCol_.ImGuiCol_ButtonHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_CheckMark
import cimgui.internal.ImGuiCol_.ImGuiCol_ChildBg
import cimgui.internal.ImGuiCol_.ImGuiCol_DragDropTarget
import cimgui.internal.ImGuiCol_.ImGuiCol_FrameBg
import cimgui.internal.ImGuiCol_.ImGuiCol_FrameBgActive
import cimgui.internal.ImGuiCol_.ImGuiCol_FrameBgHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_Header
import cimgui.internal.ImGuiCol_.ImGuiCol_HeaderActive
import cimgui.internal.ImGuiCol_.ImGuiCol_HeaderHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_MenuBarBg
import cimgui.internal.ImGuiCol_.ImGuiCol_ModalWindowDimBg
import cimgui.internal.ImGuiCol_.ImGuiCol_NavHighlight
import cimgui.internal.ImGuiCol_.ImGuiCol_NavWindowingDimBg
import cimgui.internal.ImGuiCol_.ImGuiCol_NavWindowingHighlight
import cimgui.internal.ImGuiCol_.ImGuiCol_PlotHistogram
import cimgui.internal.ImGuiCol_.ImGuiCol_PlotHistogramHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_PlotLines
import cimgui.internal.ImGuiCol_.ImGuiCol_PlotLinesHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_PopupBg
import cimgui.internal.ImGuiCol_.ImGuiCol_ResizeGrip
import cimgui.internal.ImGuiCol_.ImGuiCol_ResizeGripActive
import cimgui.internal.ImGuiCol_.ImGuiCol_ResizeGripHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_ScrollbarBg
import cimgui.internal.ImGuiCol_.ImGuiCol_ScrollbarGrab
import cimgui.internal.ImGuiCol_.ImGuiCol_ScrollbarGrabActive
import cimgui.internal.ImGuiCol_.ImGuiCol_ScrollbarGrabHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_Separator
import cimgui.internal.ImGuiCol_.ImGuiCol_SeparatorActive
import cimgui.internal.ImGuiCol_.ImGuiCol_SeparatorHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_SliderGrab
import cimgui.internal.ImGuiCol_.ImGuiCol_SliderGrabActive
import cimgui.internal.ImGuiCol_.ImGuiCol_Tab
import cimgui.internal.ImGuiCol_.ImGuiCol_TabActive
import cimgui.internal.ImGuiCol_.ImGuiCol_TabHovered
import cimgui.internal.ImGuiCol_.ImGuiCol_TabUnfocused
import cimgui.internal.ImGuiCol_.ImGuiCol_TabUnfocusedActive
import cimgui.internal.ImGuiCol_.ImGuiCol_Text
import cimgui.internal.ImGuiCol_.ImGuiCol_TextDisabled
import cimgui.internal.ImGuiCol_.ImGuiCol_TextSelectedBg
import cimgui.internal.ImGuiCol_.ImGuiCol_TitleBg
import cimgui.internal.ImGuiCol_.ImGuiCol_TitleBgActive
import cimgui.internal.ImGuiCol_.ImGuiCol_TitleBgCollapsed
import cimgui.internal.ImGuiCol_.ImGuiCol_WindowBg
import kotlin.Int

actual enum class ImGuiCol(
  val value: Int
) {
  Text(ImGuiCol_Text),

  TextDisabled(ImGuiCol_TextDisabled),

  WindowBg(ImGuiCol_WindowBg),

  ChildBg(ImGuiCol_ChildBg),

  PopupBg(ImGuiCol_PopupBg),

  Border(ImGuiCol_Border),

  BorderShadow(ImGuiCol_BorderShadow),

  FrameBg(ImGuiCol_FrameBg),

  FrameBgHovered(ImGuiCol_FrameBgHovered),

  FrameBgActive(ImGuiCol_FrameBgActive),

  TitleBg(ImGuiCol_TitleBg),

  TitleBgActive(ImGuiCol_TitleBgActive),

  TitleBgCollapsed(ImGuiCol_TitleBgCollapsed),

  MenuBarBg(ImGuiCol_MenuBarBg),

  ScrollbarBg(ImGuiCol_ScrollbarBg),

  ScrollbarGrab(ImGuiCol_ScrollbarGrab),

  ScrollbarGrabHovered(ImGuiCol_ScrollbarGrabHovered),

  ScrollbarGrabActive(ImGuiCol_ScrollbarGrabActive),

  CheckMark(ImGuiCol_CheckMark),

  SliderGrab(ImGuiCol_SliderGrab),

  SliderGrabActive(ImGuiCol_SliderGrabActive),

  Button(ImGuiCol_Button),

  ButtonHovered(ImGuiCol_ButtonHovered),

  ButtonActive(ImGuiCol_ButtonActive),

  Header(ImGuiCol_Header),

  HeaderHovered(ImGuiCol_HeaderHovered),

  HeaderActive(ImGuiCol_HeaderActive),

  Separator(ImGuiCol_Separator),

  SeparatorHovered(ImGuiCol_SeparatorHovered),

  SeparatorActive(ImGuiCol_SeparatorActive),

  ResizeGrip(ImGuiCol_ResizeGrip),

  ResizeGripHovered(ImGuiCol_ResizeGripHovered),

  ResizeGripActive(ImGuiCol_ResizeGripActive),

  Tab(ImGuiCol_Tab),

  TabHovered(ImGuiCol_TabHovered),

  TabActive(ImGuiCol_TabActive),

  TabUnfocused(ImGuiCol_TabUnfocused),

  TabUnfocusedActive(ImGuiCol_TabUnfocusedActive),

  PlotLines(ImGuiCol_PlotLines),

  PlotLinesHovered(ImGuiCol_PlotLinesHovered),

  PlotHistogram(ImGuiCol_PlotHistogram),

  PlotHistogramHovered(ImGuiCol_PlotHistogramHovered),

  TextSelectedBg(ImGuiCol_TextSelectedBg),

  DragDropTarget(ImGuiCol_DragDropTarget),

  NavHighlight(ImGuiCol_NavHighlight),

  NavWindowingHighlight(ImGuiCol_NavWindowingHighlight),

  NavWindowingDimBg(ImGuiCol_NavWindowingDimBg),

  ModalWindowDimBg(ImGuiCol_ModalWindowDimBg);

  actual companion object {
    fun from(value: Int): ImGuiCol = when (value) {
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
