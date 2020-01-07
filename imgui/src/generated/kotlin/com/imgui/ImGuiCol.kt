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

enum class ImGuiCol(
  val value: ImGuiCol_
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
}
