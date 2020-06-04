package com.imgui

import cimgui.internal.ImGuiAxis_None
import cimgui.internal.ImGuiAxis_X
import cimgui.internal.ImGuiAxis_Y
import kotlinx.cinterop.convert

actual enum class ImGuiAxis(
  val value: cimgui.internal.ImGuiAxis
) {
  _None(ImGuiAxis_None.convert()),

  _X(ImGuiAxis_X.convert()),

  _Y(ImGuiAxis_Y.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiAxis): ImGuiAxis = when
        (value.convert<cimgui.internal.ImGuiAxis>()) {
      ImGuiAxis_None -> _None
      ImGuiAxis_X -> _X
      ImGuiAxis_Y -> _Y
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
