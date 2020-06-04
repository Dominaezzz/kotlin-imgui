package com.imgui

import cimgui.internal.ImGuiNavForward_ForwardActive
import cimgui.internal.ImGuiNavForward_ForwardQueued
import cimgui.internal.ImGuiNavForward_None
import kotlinx.cinterop.convert

actual enum class ImGuiNavForward(
  val value: cimgui.internal.ImGuiNavForward
) {
  _None(ImGuiNavForward_None.convert()),

  _ForwardQueued(ImGuiNavForward_ForwardQueued.convert()),

  _ForwardActive(ImGuiNavForward_ForwardActive.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiNavForward): ImGuiNavForward = when
        (value.convert<cimgui.internal.ImGuiNavForward>()) {
      ImGuiNavForward_None -> _None
      ImGuiNavForward_ForwardQueued -> _ForwardQueued
      ImGuiNavForward_ForwardActive -> _ForwardActive
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
