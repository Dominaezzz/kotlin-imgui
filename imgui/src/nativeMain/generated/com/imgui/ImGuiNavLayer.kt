package com.imgui

import cimgui.internal.ImGuiNavLayer_COUNT
import cimgui.internal.ImGuiNavLayer_Main
import cimgui.internal.ImGuiNavLayer_Menu
import kotlinx.cinterop.convert

actual enum class ImGuiNavLayer(
  val value: cimgui.internal.ImGuiNavLayer
) {
  _Main(ImGuiNavLayer_Main.convert()),

  _Menu(ImGuiNavLayer_Menu.convert()),

  _COUNT(ImGuiNavLayer_COUNT.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiNavLayer): ImGuiNavLayer = when
        (value.convert<cimgui.internal.ImGuiNavLayer>()) {
      ImGuiNavLayer_Main -> _Main
      ImGuiNavLayer_Menu -> _Menu
      ImGuiNavLayer_COUNT -> _COUNT
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
