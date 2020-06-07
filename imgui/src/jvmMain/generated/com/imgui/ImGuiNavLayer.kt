package com.imgui

import cimgui.internal.ImGuiNavLayer.ImGuiNavLayer_Main
import cimgui.internal.ImGuiNavLayer.ImGuiNavLayer_Menu
import kotlin.Int

actual enum class ImGuiNavLayer(
  val value: Int
) {
  Main(ImGuiNavLayer_Main),

  Menu(ImGuiNavLayer_Menu);

  actual companion object {
    fun from(value: Int): ImGuiNavLayer = when (value) {
      ImGuiNavLayer_Main -> Main
      ImGuiNavLayer_Menu -> Menu
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
