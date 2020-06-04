package com.imgui

import cimgui.internal.ImGuiNavLayer.ImGuiNavLayer_COUNT
import cimgui.internal.ImGuiNavLayer.ImGuiNavLayer_Main
import cimgui.internal.ImGuiNavLayer.ImGuiNavLayer_Menu
import kotlin.Int

actual enum class ImGuiNavLayer(
  val value: Int
) {
  _Main(ImGuiNavLayer_Main),

  _Menu(ImGuiNavLayer_Menu),

  _COUNT(ImGuiNavLayer_COUNT);

  actual companion object {
    fun from(value: Int): ImGuiNavLayer = when (value) {
      ImGuiNavLayer_Main -> _Main
      ImGuiNavLayer_Menu -> _Menu
      ImGuiNavLayer_COUNT -> _COUNT
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
