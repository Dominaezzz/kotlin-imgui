package com.imgui

import cimgui.internal.ImGuiPlotType.ImGuiPlotType_Histogram
import cimgui.internal.ImGuiPlotType.ImGuiPlotType_Lines
import kotlin.Int

actual enum class ImGuiPlotType(
  val value: Int
) {
  Lines(ImGuiPlotType_Lines),

  Histogram(ImGuiPlotType_Histogram);

  actual val cValue: Int
    get() = value

  actual companion object {
    fun from(value: Int): ImGuiPlotType = when (value) {
      ImGuiPlotType_Lines -> Lines
      ImGuiPlotType_Histogram -> Histogram
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
