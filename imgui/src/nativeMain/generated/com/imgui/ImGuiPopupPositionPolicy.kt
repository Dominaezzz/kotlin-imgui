package com.imgui

import cimgui.internal.ImGuiPopupPositionPolicy_ComboBox
import cimgui.internal.ImGuiPopupPositionPolicy_Default
import kotlinx.cinterop.convert

actual enum class ImGuiPopupPositionPolicy(
  val value: cimgui.internal.ImGuiPopupPositionPolicy
) {
  Default(ImGuiPopupPositionPolicy_Default.convert()),

  ComboBox(ImGuiPopupPositionPolicy_ComboBox.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiPopupPositionPolicy): ImGuiPopupPositionPolicy = when
        (value.convert<cimgui.internal.ImGuiPopupPositionPolicy>()) {
      ImGuiPopupPositionPolicy_Default -> Default
      ImGuiPopupPositionPolicy_ComboBox -> ComboBox
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
