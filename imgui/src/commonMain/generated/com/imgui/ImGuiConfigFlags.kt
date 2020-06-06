package com.imgui

expect enum class ImGuiConfigFlags : Flag<ImGuiConfigFlags> {
  NavEnableKeyboard,

  NavEnableGamepad,

  NavEnableSetMousePos,

  NavNoCaptureKeyboard,

  NoMouse,

  NoMouseCursorChange,

  DockingEnable,

  ViewportsEnable,

  DpiEnableScaleViewports,

  DpiEnableScaleFonts,

  IsSRGB,

  IsTouchScreen;

  companion object
}
