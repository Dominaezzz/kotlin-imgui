package com.imgui

import cimgui.internal.ImGuiAxis.ImGuiAxis_None
import cimgui.internal.ImGuiAxis.ImGuiAxis_X
import cimgui.internal.ImGuiAxis.ImGuiAxis_Y
import kotlin.Int

actual enum class ImGuiAxis(
  val value: Int
) {
  _None(ImGuiAxis_None),

  _X(ImGuiAxis_X),

  _Y(ImGuiAxis_Y);

  actual companion object {
    fun from(value: Int): ImGuiAxis = when (value) {
      ImGuiAxis_None -> _None
      ImGuiAxis_X -> _X
      ImGuiAxis_Y -> _Y
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
