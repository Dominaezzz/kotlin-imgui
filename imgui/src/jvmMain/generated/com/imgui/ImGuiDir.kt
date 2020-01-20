package com.imgui

import cimgui.internal.ImGuiDir_.ImGuiDir_Down
import cimgui.internal.ImGuiDir_.ImGuiDir_Left
import cimgui.internal.ImGuiDir_.ImGuiDir_None
import cimgui.internal.ImGuiDir_.ImGuiDir_Right
import cimgui.internal.ImGuiDir_.ImGuiDir_Up
import kotlin.Int

actual enum class ImGuiDir(
  val value: Int
) {
  None(ImGuiDir_None),

  Left(ImGuiDir_Left),

  Right(ImGuiDir_Right),

  Up(ImGuiDir_Up),

  Down(ImGuiDir_Down);

  actual companion object {
    fun from(value: Int): ImGuiDir = when (value) {
      ImGuiDir_None -> None
      ImGuiDir_Left -> Left
      ImGuiDir_Right -> Right
      ImGuiDir_Up -> Up
      ImGuiDir_Down -> Down
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
