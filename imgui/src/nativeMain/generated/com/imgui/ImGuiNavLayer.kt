package com.imgui

import cimgui.internal.ImGuiNavLayer_Main
import cimgui.internal.ImGuiNavLayer_Menu
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiNavLayer(
  val value: cimgui.internal.ImGuiNavLayer
) {
  Main(ImGuiNavLayer_Main.convert()),

  Menu(ImGuiNavLayer_Menu.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiNavLayer): ImGuiNavLayer = when
        (value.convert<cimgui.internal.ImGuiNavLayer>()) {
      ImGuiNavLayer_Main -> Main
      ImGuiNavLayer_Menu -> Menu
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
