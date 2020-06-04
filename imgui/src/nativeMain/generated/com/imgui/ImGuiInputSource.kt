package com.imgui

import cimgui.internal.ImGuiInputSource_COUNT
import cimgui.internal.ImGuiInputSource_Mouse
import cimgui.internal.ImGuiInputSource_Nav
import cimgui.internal.ImGuiInputSource_NavGamepad
import cimgui.internal.ImGuiInputSource_NavKeyboard
import cimgui.internal.ImGuiInputSource_None
import kotlinx.cinterop.convert

actual enum class ImGuiInputSource(
  val value: cimgui.internal.ImGuiInputSource
) {
  _None(ImGuiInputSource_None.convert()),

  _Mouse(ImGuiInputSource_Mouse.convert()),

  _Nav(ImGuiInputSource_Nav.convert()),

  _NavKeyboard(ImGuiInputSource_NavKeyboard.convert()),

  _NavGamepad(ImGuiInputSource_NavGamepad.convert()),

  _COUNT(ImGuiInputSource_COUNT.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiInputSource): ImGuiInputSource = when
        (value.convert<cimgui.internal.ImGuiInputSource>()) {
      ImGuiInputSource_None -> _None
      ImGuiInputSource_Mouse -> _Mouse
      ImGuiInputSource_Nav -> _Nav
      ImGuiInputSource_NavKeyboard -> _NavKeyboard
      ImGuiInputSource_NavGamepad -> _NavGamepad
      ImGuiInputSource_COUNT -> _COUNT
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
