package com.imgui

import kotlinx.cinterop.CPointer

inline class ImGuiContext(
  internal val ptr: CPointer<cnames.structs.ImGuiContext>
)
