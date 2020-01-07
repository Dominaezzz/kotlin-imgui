package com.imgui

import kotlinx.cinterop.CPointer

inline class ImGuiSizeCallbackData(
  val ptr: CPointer<cimgui.internal.ImGuiSizeCallbackData>
)
