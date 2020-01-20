package com.imgui

expect enum class ImGuiCond : Flag<ImGuiCond> {
  Always,

  Once,

  FirstUseEver,

  Appearing;

  companion object
}
