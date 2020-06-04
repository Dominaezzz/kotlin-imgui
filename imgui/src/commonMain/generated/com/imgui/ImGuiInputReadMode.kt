package com.imgui

expect enum class ImGuiInputReadMode {
  _Down,

  _Pressed,

  _Released,

  _Repeat,

  _RepeatSlow,

  _RepeatFast;

  companion object
}
