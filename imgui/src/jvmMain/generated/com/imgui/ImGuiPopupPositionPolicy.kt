package com.imgui

import cimgui.internal.ImGuiPopupPositionPolicy.ImGuiPopupPositionPolicy_ComboBox
import cimgui.internal.ImGuiPopupPositionPolicy.ImGuiPopupPositionPolicy_Default
import kotlin.Int

actual enum class ImGuiPopupPositionPolicy(
  val value: Int
) {
  _Default(ImGuiPopupPositionPolicy_Default),

  _ComboBox(ImGuiPopupPositionPolicy_ComboBox);

  actual companion object {
    fun from(value: Int): ImGuiPopupPositionPolicy = when (value) {
      ImGuiPopupPositionPolicy_Default -> _Default
      ImGuiPopupPositionPolicy_ComboBox -> _ComboBox
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
