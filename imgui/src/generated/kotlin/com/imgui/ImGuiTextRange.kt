package com.imgui

import kotlinx.cinterop.CPointer

inline class ImGuiTextRange(
  val ptr: CPointer<cimgui.internal.ImGuiTextRange>
)
