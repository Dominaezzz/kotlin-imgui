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
  Down(ImGuiInputReadMode_Down),

  Pressed(ImGuiInputReadMode_Pressed),

  Released(ImGuiInputReadMode_Released),

  Repeat(ImGuiInputReadMode_Repeat),

  RepeatSlow(ImGuiInputReadMode_RepeatSlow),

  RepeatFast(ImGuiInputReadMode_RepeatFast);

  actual companion object {
    fun from(value: Int): ImGuiInputReadMode = when (value) {
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
