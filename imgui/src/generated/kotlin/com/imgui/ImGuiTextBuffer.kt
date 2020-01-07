package com.imgui

import kotlinx.cinterop.CPointer

inline class ImGuiTextBuffer(
  val ptr: CPointer<cimgui.internal.ImGuiTextBuffer>
)
