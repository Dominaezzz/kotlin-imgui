package com.imgui

import cimgui.internal.ImGuiPopupPositionPolicy_ComboBox
import cimgui.internal.ImGuiPopupPositionPolicy_Default
import kotlinx.cinterop.convert

actual enum class ImGuiPopupPositionPolicy(
  val value: cimgui.internal.ImGuiPopupPositionPolicy
) {
  _Default(ImGuiPopupPositionPolicy_Default.convert()),

  _ComboBox(ImGuiPopupPositionPolicy_ComboBox.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiPopupPositionPolicy): ImGuiPopupPositionPolicy = when
        (value.convert<cimgui.internal.ImGuiPopupPositionPolicy>()) {
      ImGuiPopupPositionPolicy_Default -> _Default
      ImGuiPopupPositionPolicy_ComboBox -> _ComboBox
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
