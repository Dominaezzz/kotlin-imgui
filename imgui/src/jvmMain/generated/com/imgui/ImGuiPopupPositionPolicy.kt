package com.imgui

import cimgui.internal.ImGuiPopupPositionPolicy.ImGuiPopupPositionPolicy_ComboBox
import cimgui.internal.ImGuiPopupPositionPolicy.ImGuiPopupPositionPolicy_Default
import kotlin.Int

actual enum class ImGuiPopupPositionPolicy(
  val value: Int
) {
  Default(ImGuiPopupPositionPolicy_Default),

  ComboBox(ImGuiPopupPositionPolicy_ComboBox);

  actual companion object {
    fun from(value: Int): ImGuiPopupPositionPolicy = when (value) {
      ImGuiPopupPositionPolicy_Default -> Default
      ImGuiPopupPositionPolicy_ComboBox -> ComboBox
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
