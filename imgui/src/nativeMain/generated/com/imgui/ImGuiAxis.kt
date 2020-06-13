package com.imgui

import cimgui.internal.ImGuiAxis_None
import cimgui.internal.ImGuiAxis_X
import cimgui.internal.ImGuiAxis_Y
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiAxis(
  val value: cimgui.internal.ImGuiAxis
) {
  None(ImGuiAxis_None.convert()),

  X(ImGuiAxis_X.convert()),

  Y(ImGuiAxis_Y.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiAxis): ImGuiAxis = when
        (value.convert<cimgui.internal.ImGuiAxis>()) {
      ImGuiAxis_None -> None
      ImGuiAxis_X -> X
      ImGuiAxis_Y -> Y
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
