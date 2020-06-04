package com.imgui

expect enum class ImGuiKeyModFlags : Flag<ImGuiKeyModFlags> {
  Ctrl,

  Shift,

  Alt,

  Super;

  companion object
}
