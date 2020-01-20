package com.imgui

import cimgui.internal.ImGuiDataType_.ImGuiDataType_Double
import cimgui.internal.ImGuiDataType_.ImGuiDataType_Float
import cimgui.internal.ImGuiDataType_.ImGuiDataType_S16
import cimgui.internal.ImGuiDataType_.ImGuiDataType_S32
import cimgui.internal.ImGuiDataType_.ImGuiDataType_S64
import cimgui.internal.ImGuiDataType_.ImGuiDataType_S8
import cimgui.internal.ImGuiDataType_.ImGuiDataType_U16
import cimgui.internal.ImGuiDataType_.ImGuiDataType_U32
import cimgui.internal.ImGuiDataType_.ImGuiDataType_U64
import cimgui.internal.ImGuiDataType_.ImGuiDataType_U8
import kotlin.Int

actual enum class ImGuiDataType(
  val value: Int
) {
  S8(ImGuiDataType_S8),

  U8(ImGuiDataType_U8),

  S16(ImGuiDataType_S16),

  U16(ImGuiDataType_U16),

  S32(ImGuiDataType_S32),

  U32(ImGuiDataType_U32),

  S64(ImGuiDataType_S64),

  U64(ImGuiDataType_U64),

  Float(ImGuiDataType_Float),

  Double(ImGuiDataType_Double);

  actual companion object {
    fun from(value: Int): ImGuiDataType = when (value) {
      ImGuiDataType_S8 -> S8
      ImGuiDataType_U8 -> U8
      ImGuiDataType_S16 -> S16
      ImGuiDataType_U16 -> U16
      ImGuiDataType_S32 -> S32
      ImGuiDataType_U32 -> U32
      ImGuiDataType_S64 -> S64
      ImGuiDataType_U64 -> U64
      ImGuiDataType_Float -> Float
      ImGuiDataType_Double -> Double
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
