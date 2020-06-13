package com.imgui

import cimgui.internal.ImGuiDataType_
import cimgui.internal.ImGuiDataType_Double
import cimgui.internal.ImGuiDataType_Float
import cimgui.internal.ImGuiDataType_S16
import cimgui.internal.ImGuiDataType_S32
import cimgui.internal.ImGuiDataType_S64
import cimgui.internal.ImGuiDataType_S8
import cimgui.internal.ImGuiDataType_U16
import cimgui.internal.ImGuiDataType_U32
import cimgui.internal.ImGuiDataType_U64
import cimgui.internal.ImGuiDataType_U8
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiDataType(
  val value: cimgui.internal.ImGuiDataType
) {
  S8(ImGuiDataType_S8.convert()),

  U8(ImGuiDataType_U8.convert()),

  S16(ImGuiDataType_S16.convert()),

  U16(ImGuiDataType_U16.convert()),

  S32(ImGuiDataType_S32.convert()),

  U32(ImGuiDataType_U32.convert()),

  S64(ImGuiDataType_S64.convert()),

  U64(ImGuiDataType_U64.convert()),

  Float(ImGuiDataType_Float.convert()),

  Double(ImGuiDataType_Double.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiDataType): ImGuiDataType = when
        (value.convert<ImGuiDataType_>()) {
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
