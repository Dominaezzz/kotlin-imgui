package com.imgui

import kotlin.Int

expect enum class ImGuiConfigFlags : Flag<ImGuiConfigFlags> {
  NavEnableKeyboard,

  NavEnableGamepad,

  NavEnableSetMousePos,

  NavNoCaptureKeyboard,

  NoMouse,

  NoMouseCursorChange,

  IsSRGB,

  IsTouchScreen;

  val cValue: Int

  companion object
}
