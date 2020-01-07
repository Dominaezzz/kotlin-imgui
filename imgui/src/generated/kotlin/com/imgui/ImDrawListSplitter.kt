package com.imgui

import kotlinx.cinterop.CPointer

inline class ImDrawListSplitter(
  val ptr: CPointer<cimgui.internal.ImDrawListSplitter>
)
