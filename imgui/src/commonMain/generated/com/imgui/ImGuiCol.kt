package com.imgui

import kotlin.Int

expect enum class ImGuiCol {
  Text,

  TextDisabled,

  WindowBg,

  ChildBg,

  PopupBg,

  Border,

  BorderShadow,

  FrameBg,

  FrameBgHovered,

  FrameBgActive,

  TitleBg,

  TitleBgActive,

  TitleBgCollapsed,

  MenuBarBg,

  ScrollbarBg,

  ScrollbarGrab,

  ScrollbarGrabHovered,

  ScrollbarGrabActive,

  CheckMark,

  SliderGrab,

  SliderGrabActive,

  Button,

  ButtonHovered,

  ButtonActive,

  Header,

  HeaderHovered,

  HeaderActive,

  Separator,

  SeparatorHovered,

  SeparatorActive,

  ResizeGrip,

  ResizeGripHovered,

  ResizeGripActive,

  Tab,

  TabHovered,

  TabActive,

  TabUnfocused,

  TabUnfocusedActive,

  PlotLines,

  PlotLinesHovered,

  PlotHistogram,

  PlotHistogramHovered,

  TextSelectedBg,

  DragDropTarget,

  NavHighlight,

  NavWindowingHighlight,

  NavWindowingDimBg,

  ModalWindowDimBg;

  val cValue: Int

  companion object
}
