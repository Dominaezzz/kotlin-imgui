package com.imgui

import kotlin.Int

expect enum class ImGuiMouseCursor {
  None,

  Arrow,

  TextInput,

  ResizeAll,

  ResizeNS,

  ResizeEW,

  ResizeNESW,

  ResizeNWSE,

  Hand,

  NotAllowed;

  val cValue: Int

  companion object
}
