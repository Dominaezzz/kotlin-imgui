package com.imgui

import cimgui.internal.ImGuiPlotType.ImGuiPlotType_Histogram
import cimgui.internal.ImGuiPlotType.ImGuiPlotType_Lines
import kotlin.Int

actual enum class ImGuiPlotType(
  val value: Int
) {
  _Lines(ImGuiPlotType_Lines),

  _Histogram(ImGuiPlotType_Histogram);

  actual companion object {
    fun from(value: Int): ImGuiPlotType = when (value) {
      ImGuiPlotType_Lines -> _Lines
      ImGuiPlotType_Histogram -> _Histogram
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
