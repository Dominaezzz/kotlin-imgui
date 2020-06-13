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
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiKey(
  val value: cimgui.internal.ImGuiKey
) {
  Tab(ImGuiKey_Tab.convert()),

  LeftArrow(ImGuiKey_LeftArrow.convert()),

  RightArrow(ImGuiKey_RightArrow.convert()),

  UpArrow(ImGuiKey_UpArrow.convert()),

  DownArrow(ImGuiKey_DownArrow.convert()),

  PageUp(ImGuiKey_PageUp.convert()),

  PageDown(ImGuiKey_PageDown.convert()),

  Home(ImGuiKey_Home.convert()),

  End(ImGuiKey_End.convert()),

  Insert(ImGuiKey_Insert.convert()),

  Delete(ImGuiKey_Delete.convert()),

  Backspace(ImGuiKey_Backspace.convert()),

  Space(ImGuiKey_Space.convert()),

  Enter(ImGuiKey_Enter.convert()),

  Escape(ImGuiKey_Escape.convert()),

  KeyPadEnter(ImGuiKey_KeyPadEnter.convert()),

  A(ImGuiKey_A.convert()),

  C(ImGuiKey_C.convert()),

  V(ImGuiKey_V.convert()),

  X(ImGuiKey_X.convert()),

  Y(ImGuiKey_Y.convert()),

  Z(ImGuiKey_Z.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiKey): ImGuiKey = when (value.convert<ImGuiKey_>()) {
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
