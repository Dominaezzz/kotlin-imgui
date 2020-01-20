package com.imgui

import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_Arrow
import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_Hand
import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_None
import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_ResizeAll
import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_ResizeEW
import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_ResizeNESW
import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_ResizeNS
import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_ResizeNWSE
import cimgui.internal.ImGuiMouseCursor_.ImGuiMouseCursor_TextInput
import kotlin.Int

actual enum class ImGuiMouseCursor(
  val value: Int
) {
  None(ImGuiMouseCursor_None),

  Arrow(ImGuiMouseCursor_Arrow),

  TextInput(ImGuiMouseCursor_TextInput),

  ResizeAll(ImGuiMouseCursor_ResizeAll),

  ResizeNS(ImGuiMouseCursor_ResizeNS),

  ResizeEW(ImGuiMouseCursor_ResizeEW),

  ResizeNESW(ImGuiMouseCursor_ResizeNESW),

  ResizeNWSE(ImGuiMouseCursor_ResizeNWSE),

  Hand(ImGuiMouseCursor_Hand);

  actual companion object {
    fun from(value: Int): ImGuiMouseCursor = when (value) {
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
