package com.imgui

import cimgui.internal.ImGuiNavForward.ImGuiNavForward_ForwardActive
import cimgui.internal.ImGuiNavForward.ImGuiNavForward_ForwardQueued
import cimgui.internal.ImGuiNavForward.ImGuiNavForward_None
import kotlin.Int

actual enum class ImGuiNavForward(
  val value: Int
) {
  _None(ImGuiNavForward_None),

  _ForwardQueued(ImGuiNavForward_ForwardQueued),

  _ForwardActive(ImGuiNavForward_ForwardActive);

  actual companion object {
    fun from(value: Int): ImGuiNavForward = when (value) {
      ImGuiNavForward_None -> _None
      ImGuiNavForward_ForwardQueued -> _ForwardQueued
      ImGuiNavForward_ForwardActive -> _ForwardActive
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
