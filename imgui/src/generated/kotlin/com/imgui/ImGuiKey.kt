package com.imgui

import cimgui.internal.ImGuiKey_
import cimgui.internal.ImGuiKey_A
import cimgui.internal.ImGuiKey_Backspace
import cimgui.internal.ImGuiKey_C
import cimgui.internal.ImGuiKey_Delete
import cimgui.internal.ImGuiKey_DownArrow
import cimgui.internal.ImGuiKey_End
import cimgui.internal.ImGuiKey_Enter
import cimgui.internal.ImGuiKey_Escape
import cimgui.internal.ImGuiKey_Home
import cimgui.internal.ImGuiKey_Insert
import cimgui.internal.ImGuiKey_KeyPadEnter
import cimgui.internal.ImGuiKey_LeftArrow
import cimgui.internal.ImGuiKey_PageDown
import cimgui.internal.ImGuiKey_PageUp
import cimgui.internal.ImGuiKey_RightArrow
import cimgui.internal.ImGuiKey_Space
import cimgui.internal.ImGuiKey_Tab
import cimgui.internal.ImGuiKey_UpArrow
import cimgui.internal.ImGuiKey_V
import cimgui.internal.ImGuiKey_X
import cimgui.internal.ImGuiKey_Y
import cimgui.internal.ImGuiKey_Z

enum class ImGuiKey(
  val value: ImGuiKey_
) {
  Tab(ImGuiKey_Tab),

  LeftArrow(ImGuiKey_LeftArrow),

  RightArrow(ImGuiKey_RightArrow),

  UpArrow(ImGuiKey_UpArrow),

  DownArrow(ImGuiKey_DownArrow),

  PageUp(ImGuiKey_PageUp),

  PageDown(ImGuiKey_PageDown),

  Home(ImGuiKey_Home),

  End(ImGuiKey_End),

  Insert(ImGuiKey_Insert),

  Delete(ImGuiKey_Delete),

  Backspace(ImGuiKey_Backspace),

  Space(ImGuiKey_Space),

  Enter(ImGuiKey_Enter),

  Escape(ImGuiKey_Escape),

  KeyPadEnter(ImGuiKey_KeyPadEnter),

  A(ImGuiKey_A),

  C(ImGuiKey_C),

  V(ImGuiKey_V),

  X(ImGuiKey_X),

  Y(ImGuiKey_Y),

  Z(ImGuiKey_Z);
}
