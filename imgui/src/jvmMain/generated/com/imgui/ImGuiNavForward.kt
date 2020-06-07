package com.imgui

import cimgui.internal.ImGuiNavForward.ImGuiNavForward_ForwardActive
import cimgui.internal.ImGuiNavForward.ImGuiNavForward_ForwardQueued
import cimgui.internal.ImGuiNavForward.ImGuiNavForward_None
import kotlin.Int

actual enum class ImGuiNavForward(
  val value: Int
) {
  None(ImGuiNavForward_None),

  ForwardQueued(ImGuiNavForward_ForwardQueued),

  ForwardActive(ImGuiNavForward_ForwardActive);

  actual companion object {
    fun from(value: Int): ImGuiNavForward = when (value) {
      ImGuiNavForward_None -> None
      ImGuiNavForward_ForwardQueued -> ForwardQueued
      ImGuiNavForward_ForwardActive -> ForwardActive
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
