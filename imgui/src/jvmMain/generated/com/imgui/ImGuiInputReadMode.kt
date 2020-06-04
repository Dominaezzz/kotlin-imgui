package com.imgui

import cimgui.internal.ImGuiInputReadMode.ImGuiInputReadMode_Down
import cimgui.internal.ImGuiInputReadMode.ImGuiInputReadMode_Pressed
import cimgui.internal.ImGuiInputReadMode.ImGuiInputReadMode_Released
import cimgui.internal.ImGuiInputReadMode.ImGuiInputReadMode_Repeat
import cimgui.internal.ImGuiInputReadMode.ImGuiInputReadMode_RepeatFast
import cimgui.internal.ImGuiInputReadMode.ImGuiInputReadMode_RepeatSlow
import kotlin.Int

actual enum class ImGuiInputReadMode(
  val value: Int
) {
  _Down(ImGuiInputReadMode_Down),

  _Pressed(ImGuiInputReadMode_Pressed),

  _Released(ImGuiInputReadMode_Released),

  _Repeat(ImGuiInputReadMode_Repeat),

  _RepeatSlow(ImGuiInputReadMode_RepeatSlow),

  _RepeatFast(ImGuiInputReadMode_RepeatFast);

  actual companion object {
    fun from(value: Int): ImGuiInputReadMode = when (value) {
      ImGuiInputReadMode_Down -> _Down
      ImGuiInputReadMode_Pressed -> _Pressed
      ImGuiInputReadMode_Released -> _Released
      ImGuiInputReadMode_Repeat -> _Repeat
      ImGuiInputReadMode_RepeatSlow -> _RepeatSlow
      ImGuiInputReadMode_RepeatFast -> _RepeatFast
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
