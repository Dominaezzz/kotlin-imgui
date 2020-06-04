package com.imgui

import cimgui.internal.ImGuiPlotType_Histogram
import cimgui.internal.ImGuiPlotType_Lines
import kotlinx.cinterop.convert

actual enum class ImGuiPlotType(
  val value: cimgui.internal.ImGuiPlotType
) {
  _Lines(ImGuiPlotType_Lines.convert()),

  _Histogram(ImGuiPlotType_Histogram.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiPlotType): ImGuiPlotType = when
        (value.convert<cimgui.internal.ImGuiPlotType>()) {
      ImGuiPlotType_Lines -> _Lines
      ImGuiPlotType_Histogram -> _Histogram
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
