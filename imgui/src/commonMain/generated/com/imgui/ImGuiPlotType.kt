package com.imgui

import kotlin.Int

expect enum class ImGuiPlotType {
  Lines,

  Histogram;

  val cValue: Int

  companion object
}
