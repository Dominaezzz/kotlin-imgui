package com.imgui

expect enum class ImGuiNavDirSourceFlags : Flag<ImGuiNavDirSourceFlags> {
  Keyboard,

  PadDPad,

  PadLStick;

  companion object
}
