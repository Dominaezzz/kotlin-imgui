package com.imgui

import cimgui.internal.ImGuiKey_.ImGuiKey_A
import cimgui.internal.ImGuiKey_.ImGuiKey_Backspace
import cimgui.internal.ImGuiKey_.ImGuiKey_C
import cimgui.internal.ImGuiKey_.ImGuiKey_Delete
import cimgui.internal.ImGuiKey_.ImGuiKey_DownArrow
import cimgui.internal.ImGuiKey_.ImGuiKey_End
import cimgui.internal.ImGuiKey_.ImGuiKey_Enter
import cimgui.internal.ImGuiKey_.ImGuiKey_Escape
import cimgui.internal.ImGuiKey_.ImGuiKey_Home
import cimgui.internal.ImGuiKey_.ImGuiKey_Insert
import cimgui.internal.ImGuiKey_.ImGuiKey_KeyPadEnter
import cimgui.internal.ImGuiKey_.ImGuiKey_LeftArrow
import cimgui.internal.ImGuiKey_.ImGuiKey_PageDown
import cimgui.internal.ImGuiKey_.ImGuiKey_PageUp
import cimgui.internal.ImGuiKey_.ImGuiKey_RightArrow
import cimgui.internal.ImGuiKey_.ImGuiKey_Space
import cimgui.internal.ImGuiKey_.ImGuiKey_Tab
import cimgui.internal.ImGuiKey_.ImGuiKey_UpArrow
import cimgui.internal.ImGuiKey_.ImGuiKey_V
import cimgui.internal.ImGuiKey_.ImGuiKey_X
import cimgui.internal.ImGuiKey_.ImGuiKey_Y
import cimgui.internal.ImGuiKey_.ImGuiKey_Z
import kotlin.Int

actual enum class ImGuiKey(
  val value: Int
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

  actual companion object {
    fun from(value: Int): ImGuiKey = when (value) {
      ImGuiKey_Tab -> Tab
      ImGuiKey_LeftArrow -> LeftArrow
      ImGuiKey_RightArrow -> RightArrow
      ImGuiKey_UpArrow -> UpArrow
      ImGuiKey_DownArrow -> DownArrow
      ImGuiKey_PageUp -> PageUp
      ImGuiKey_PageDown -> PageDown
      ImGuiKey_Home -> Home
      ImGuiKey_End -> End
      ImGuiKey_Insert -> Insert
      ImGuiKey_Delete -> Delete
      ImGuiKey_Backspace -> Backspace
      ImGuiKey_Space -> Space
      ImGuiKey_Enter -> Enter
      ImGuiKey_Escape -> Escape
      ImGuiKey_KeyPadEnter -> KeyPadEnter
      ImGuiKey_A -> A
      ImGuiKey_C -> C
      ImGuiKey_V -> V
      ImGuiKey_X -> X
      ImGuiKey_Y -> Y
      ImGuiKey_Z -> Z
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
