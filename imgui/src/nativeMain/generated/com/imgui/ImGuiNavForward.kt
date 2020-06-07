package com.imgui

import cimgui.internal.ImGuiNavForward_ForwardActive
import cimgui.internal.ImGuiNavForward_ForwardQueued
import cimgui.internal.ImGuiNavForward_None
import kotlinx.cinterop.convert

actual enum class ImGuiNavForward(
  val value: cimgui.internal.ImGuiNavForward
) {
  None(ImGuiNavForward_None.convert()),

  ForwardQueued(ImGuiNavForward_ForwardQueued.convert()),

  ForwardActive(ImGuiNavForward_ForwardActive.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiNavForward): ImGuiNavForward = when
        (value.convert<cimgui.internal.ImGuiNavForward>()) {
      ImGuiNavForward_None -> None
      ImGuiNavForward_ForwardQueued -> ForwardQueued
      ImGuiNavForward_ForwardActive -> ForwardActive
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
