package com.imgui

import cimgui.internal.ImGuiInputReadMode_Down
import cimgui.internal.ImGuiInputReadMode_Pressed
import cimgui.internal.ImGuiInputReadMode_Released
import cimgui.internal.ImGuiInputReadMode_Repeat
import cimgui.internal.ImGuiInputReadMode_RepeatFast
import cimgui.internal.ImGuiInputReadMode_RepeatSlow
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiInputReadMode(
  val value: cimgui.internal.ImGuiInputReadMode
) {
  Down(ImGuiInputReadMode_Down.convert()),

  Pressed(ImGuiInputReadMode_Pressed.convert()),

  Released(ImGuiInputReadMode_Released.convert()),

  Repeat(ImGuiInputReadMode_Repeat.convert()),

  RepeatSlow(ImGuiInputReadMode_RepeatSlow.convert()),

  RepeatFast(ImGuiInputReadMode_RepeatFast.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiInputReadMode): ImGuiInputReadMode = when
        (value.convert<cimgui.internal.ImGuiInputReadMode>()) {
      ImGuiInputReadMode_Down -> Down
      ImGuiInputReadMode_Pressed -> Pressed
      ImGuiInputReadMode_Released -> Released
      ImGuiInputReadMode_Repeat -> Repeat
      ImGuiInputReadMode_RepeatSlow -> RepeatSlow
      ImGuiInputReadMode_RepeatFast -> RepeatFast
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
