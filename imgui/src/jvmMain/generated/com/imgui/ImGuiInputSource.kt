package com.imgui

import cimgui.internal.ImGuiInputSource.ImGuiInputSource_COUNT
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_Mouse
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_Nav
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_NavGamepad
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_NavKeyboard
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_None
import kotlin.Int

actual enum class ImGuiInputSource(
  val value: Int
) {
  _None(ImGuiInputSource_None),

  _Mouse(ImGuiInputSource_Mouse),

  _Nav(ImGuiInputSource_Nav),

  _NavKeyboard(ImGuiInputSource_NavKeyboard),

  _NavGamepad(ImGuiInputSource_NavGamepad),

  _COUNT(ImGuiInputSource_COUNT);

  actual companion object {
    fun from(value: Int): ImGuiInputSource = when (value) {
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
