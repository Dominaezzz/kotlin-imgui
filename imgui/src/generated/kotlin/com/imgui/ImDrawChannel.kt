package com.imgui

import kotlinx.cinterop.CPointer

inline class ImDrawChannel(
  val ptr: CPointer<cimgui.internal.ImDrawChannel>
)
