package com.imgui

import cimgui.internal.ImGuiPlotType_Histogram
import cimgui.internal.ImGuiPlotType_Lines
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiPlotType(
  val value: cimgui.internal.ImGuiPlotType
) {
  Lines(ImGuiPlotType_Lines.convert()),

  Histogram(ImGuiPlotType_Histogram.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiPlotType): ImGuiPlotType = when
        (value.convert<cimgui.internal.ImGuiPlotType>()) {
      ImGuiPlotType_Lines -> Lines
      ImGuiPlotType_Histogram -> Histogram
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
