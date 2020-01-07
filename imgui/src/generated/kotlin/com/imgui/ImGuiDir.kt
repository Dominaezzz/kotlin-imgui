package com.imgui

import cimgui.internal.ImGuiDir_
import cimgui.internal.ImGuiDir_Down
import cimgui.internal.ImGuiDir_Left
import cimgui.internal.ImGuiDir_None
import cimgui.internal.ImGuiDir_Right
import cimgui.internal.ImGuiDir_Up

enum class ImGuiDir(
  val value: ImGuiDir_
) {
  None(ImGuiDir_None),

  Left(ImGuiDir_Left),

  Right(ImGuiDir_Right),

  Up(ImGuiDir_Up),

  Down(ImGuiDir_Down);
}
