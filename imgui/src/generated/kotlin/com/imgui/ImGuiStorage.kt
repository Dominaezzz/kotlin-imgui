package com.imgui

import kotlinx.cinterop.CPointer

inline class ImGuiStorage(
  val ptr: CPointer<cimgui.internal.ImGuiStorage>
)
