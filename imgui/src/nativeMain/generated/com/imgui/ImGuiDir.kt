package com.imgui

import cimgui.internal.ImGuiDir_
import cimgui.internal.ImGuiDir_Down
import cimgui.internal.ImGuiDir_Left
import cimgui.internal.ImGuiDir_None
import cimgui.internal.ImGuiDir_Right
import cimgui.internal.ImGuiDir_Up
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiDir(
  val value: cimgui.internal.ImGuiDir
) {
  None(ImGuiDir_None.convert()),

  Left(ImGuiDir_Left.convert()),

  Right(ImGuiDir_Right.convert()),

  Up(ImGuiDir_Up.convert()),

  Down(ImGuiDir_Down.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiDir): ImGuiDir = when (value.convert<ImGuiDir_>()) {
      ImGuiDir_None -> None
      ImGuiDir_Left -> Left
      ImGuiDir_Right -> Right
      ImGuiDir_Up -> Up
      ImGuiDir_Down -> Down
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
