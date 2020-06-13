package com.imgui

import kotlin.Int

expect enum class ImGuiPopupPositionPolicy {
  Default,

  ComboBox;

  val cValue: Int

  companion object
}
