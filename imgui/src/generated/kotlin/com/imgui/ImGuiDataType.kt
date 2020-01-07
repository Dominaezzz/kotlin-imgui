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

enum class ImGuiDataType(
  val value: ImGuiDataType_
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
}
