package com.imgui

import cimgui.internal.ImGuiLayoutType_.ImGuiLayoutType_Horizontal
import cimgui.internal.ImGuiLayoutType_.ImGuiLayoutType_Vertical
import kotlin.Int

actual enum class ImGuiLayoutType(
  val value: Int
) {
  Horizontal(ImGuiLayoutType_Horizontal),

  Vertical(ImGuiLayoutType_Vertical);

  actual companion object {
    fun from(value: Int): ImGuiLayoutType = when (value) {
      ImGuiLayoutType_Horizontal -> Horizontal
      ImGuiLayoutType_Vertical -> Vertical
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
