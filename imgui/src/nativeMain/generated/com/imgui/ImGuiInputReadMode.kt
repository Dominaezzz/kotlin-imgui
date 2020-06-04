package com.imgui

import cimgui.internal.ImGuiInputReadMode_Down
import cimgui.internal.ImGuiInputReadMode_Pressed
import cimgui.internal.ImGuiInputReadMode_Released
import cimgui.internal.ImGuiInputReadMode_Repeat
import cimgui.internal.ImGuiInputReadMode_RepeatFast
import cimgui.internal.ImGuiInputReadMode_RepeatSlow
import kotlinx.cinterop.convert

actual enum class ImGuiInputReadMode(
  val value: cimgui.internal.ImGuiInputReadMode
) {
  _Down(ImGuiInputReadMode_Down.convert()),

  _Pressed(ImGuiInputReadMode_Pressed.convert()),

  _Released(ImGuiInputReadMode_Released.convert()),

  _Repeat(ImGuiInputReadMode_Repeat.convert()),

  _RepeatSlow(ImGuiInputReadMode_RepeatSlow.convert()),

  _RepeatFast(ImGuiInputReadMode_RepeatFast.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiInputReadMode): ImGuiInputReadMode = when
        (value.convert<cimgui.internal.ImGuiInputReadMode>()) {
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
