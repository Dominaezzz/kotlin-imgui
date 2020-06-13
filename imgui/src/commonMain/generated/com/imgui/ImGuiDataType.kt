package com.imgui

import kotlin.Int

expect enum class ImGuiDataType {
  S8,

  U8,

  S16,

  U16,

  S32,

  U32,

  S64,

  U64,

  Float,

  Double;

  val cValue: Int

  companion object
}
