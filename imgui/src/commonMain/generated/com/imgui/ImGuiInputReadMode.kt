package com.imgui

expect enum class ImGuiInputReadMode {
  Down,

  Pressed,

  Released,

  Repeat,

  RepeatSlow,

  RepeatFast;

  companion object
}
