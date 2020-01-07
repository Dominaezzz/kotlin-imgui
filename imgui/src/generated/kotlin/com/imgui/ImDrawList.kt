package com.imgui

import kotlinx.cinterop.CPointer

inline class ImDrawList(
  val ptr: CPointer<cimgui.internal.ImDrawList>
)
