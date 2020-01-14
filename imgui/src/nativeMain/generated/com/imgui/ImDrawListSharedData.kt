package com.imgui

import kotlinx.cinterop.CPointer

inline class ImDrawListSharedData(
  internal val ptr: CPointer<cnames.structs.ImDrawListSharedData>
)
