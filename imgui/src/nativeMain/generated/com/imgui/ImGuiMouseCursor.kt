package com.imgui

import cimgui.internal.ImGuiMouseCursor_
import cimgui.internal.ImGuiMouseCursor_Arrow
import cimgui.internal.ImGuiMouseCursor_Hand
import cimgui.internal.ImGuiMouseCursor_None
import cimgui.internal.ImGuiMouseCursor_ResizeAll
import cimgui.internal.ImGuiMouseCursor_ResizeEW
import cimgui.internal.ImGuiMouseCursor_ResizeNESW
import cimgui.internal.ImGuiMouseCursor_ResizeNS
import cimgui.internal.ImGuiMouseCursor_ResizeNWSE
import cimgui.internal.ImGuiMouseCursor_TextInput
import kotlinx.cinterop.convert

enum class ImGuiMouseCursor(
  val value: cimgui.internal.ImGuiMouseCursor
) {
  None(ImGuiMouseCursor_None.convert()),

  Arrow(ImGuiMouseCursor_Arrow.convert()),

  TextInput(ImGuiMouseCursor_TextInput.convert()),

  ResizeAll(ImGuiMouseCursor_ResizeAll.convert()),

  ResizeNS(ImGuiMouseCursor_ResizeNS.convert()),

  ResizeEW(ImGuiMouseCursor_ResizeEW.convert()),

  ResizeNESW(ImGuiMouseCursor_ResizeNESW.convert()),

  ResizeNWSE(ImGuiMouseCursor_ResizeNWSE.convert()),

  Hand(ImGuiMouseCursor_Hand.convert());

  companion object {
    fun from(value: cimgui.internal.ImGuiMouseCursor): ImGuiMouseCursor = when
        (value.convert<ImGuiMouseCursor_>()) {
      ImGuiMouseCursor_None -> None
      ImGuiMouseCursor_Arrow -> Arrow
      ImGuiMouseCursor_TextInput -> TextInput
      ImGuiMouseCursor_ResizeAll -> ResizeAll
      ImGuiMouseCursor_ResizeNS -> ResizeNS
      ImGuiMouseCursor_ResizeEW -> ResizeEW
      ImGuiMouseCursor_ResizeNESW -> ResizeNESW
      ImGuiMouseCursor_ResizeNWSE -> ResizeNWSE
      ImGuiMouseCursor_Hand -> Hand
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

  }
}
