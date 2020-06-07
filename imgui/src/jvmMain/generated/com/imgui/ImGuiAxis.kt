package com.imgui

import cimgui.internal.ImGuiAxis.ImGuiAxis_None
import cimgui.internal.ImGuiAxis.ImGuiAxis_X
import cimgui.internal.ImGuiAxis.ImGuiAxis_Y
import kotlin.Int

actual enum class ImGuiAxis(
  val value: Int
) {
  None(ImGuiAxis_None),

  X(ImGuiAxis_X),

  Y(ImGuiAxis_Y);

  actual companion object {
    fun from(value: Int): ImGuiAxis = when (value) {
      ImGuiAxis_None -> None
      ImGuiAxis_X -> X
      ImGuiAxis_Y -> Y
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
