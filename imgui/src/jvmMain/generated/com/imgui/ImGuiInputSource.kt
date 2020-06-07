package com.imgui

import cimgui.internal.ImGuiInputSource.ImGuiInputSource_Mouse
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_Nav
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_NavGamepad
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_NavKeyboard
import cimgui.internal.ImGuiInputSource.ImGuiInputSource_None
import kotlin.Int

actual enum class ImGuiInputSource(
  val value: Int
) {
  None(ImGuiInputSource_None),

  Mouse(ImGuiInputSource_Mouse),

  Nav(ImGuiInputSource_Nav),

  NavKeyboard(ImGuiInputSource_NavKeyboard),

  NavGamepad(ImGuiInputSource_NavGamepad);

  actual companion object {
    fun from(value: Int): ImGuiInputSource = when (value) {
      ImGuiInputSource_None -> None
      ImGuiInputSource_Mouse -> Mouse
      ImGuiInputSource_Nav -> Nav
      ImGuiInputSource_NavKeyboard -> NavKeyboard
      ImGuiInputSource_NavGamepad -> NavGamepad
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
