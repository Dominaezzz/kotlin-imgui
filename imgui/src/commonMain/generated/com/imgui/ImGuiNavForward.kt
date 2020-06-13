package com.imgui

import kotlin.Int

expect enum class ImGuiNavForward {
  None,

  ForwardQueued,

  ForwardActive;

  val cValue: Int

  companion object
}
