package com.imgui

import kotlin.Int

expect enum class ImGuiCond : Flag<ImGuiCond> {
  Always,

  Once,

  FirstUseEver,

  Appearing;

  val cValue: Int

  companion object
}
