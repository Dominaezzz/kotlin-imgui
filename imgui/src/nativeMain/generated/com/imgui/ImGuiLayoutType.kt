package com.imgui

import cimgui.internal.ImGuiLayoutType_
import cimgui.internal.ImGuiLayoutType_Horizontal
import cimgui.internal.ImGuiLayoutType_Vertical
import kotlinx.cinterop.convert

actual enum class ImGuiLayoutType(
  val value: cimgui.internal.ImGuiLayoutType
) {
  Horizontal(ImGuiLayoutType_Horizontal.convert()),

  Vertical(ImGuiLayoutType_Vertical.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiLayoutType): ImGuiLayoutType = when
        (value.convert<ImGuiLayoutType_>()) {
      ImGuiLayoutType_Horizontal -> Horizontal
      ImGuiLayoutType_Vertical -> Vertical
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
