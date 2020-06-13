package com.imgui

import cimgui.internal.ImGuiInputSource_Mouse
import cimgui.internal.ImGuiInputSource_Nav
import cimgui.internal.ImGuiInputSource_NavGamepad
import cimgui.internal.ImGuiInputSource_NavKeyboard
import cimgui.internal.ImGuiInputSource_None
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiInputSource(
  val value: cimgui.internal.ImGuiInputSource
) {
  None(ImGuiInputSource_None.convert()),

  Mouse(ImGuiInputSource_Mouse.convert()),

  Nav(ImGuiInputSource_Nav.convert()),

  NavKeyboard(ImGuiInputSource_NavKeyboard.convert()),

  NavGamepad(ImGuiInputSource_NavGamepad.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiInputSource): ImGuiInputSource = when
        (value.convert<cimgui.internal.ImGuiInputSource>()) {
      ImGuiInputSource_None -> None
      ImGuiInputSource_Mouse -> Mouse
      ImGuiInputSource_Nav -> Nav
      ImGuiInputSource_NavKeyboard -> NavKeyboard
      ImGuiInputSource_NavGamepad -> NavGamepad
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
