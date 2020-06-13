package com.imgui

import kotlin.Int

expect enum class ImGuiNavDirSourceFlags : Flag<ImGuiNavDirSourceFlags> {
  Keyboard,

  PadDPad,

  PadLStick;

  val cValue: Int

  companion object
}
