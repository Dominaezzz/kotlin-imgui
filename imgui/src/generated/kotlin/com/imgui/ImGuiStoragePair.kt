package com.imgui

import kotlinx.cinterop.CPointer

inline class ImGuiStoragePair(
  val ptr: CPointer<cimgui.internal.ImGuiStoragePair>
)
