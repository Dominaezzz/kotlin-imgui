package com.imgui

import kotlinx.cinterop.CPointer

inline class ImColor(
  val ptr: CPointer<cimgui.internal.ImColor>
)
