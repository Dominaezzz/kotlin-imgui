package com.imgui

expect enum class ImGuiConfigFlags : Flag<ImGuiConfigFlags> {
  NavEnableKeyboard,

  NavEnableGamepad,

  NavEnableSetMousePos,

  NavNoCaptureKeyboard,

  NoMouse,

  NoMouseCursorChange,

  IsSRGB,

  IsTouchScreen;

  companion object
}
