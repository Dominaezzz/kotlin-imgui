package com.imgui

import kotlin.Suppress
import kotlinx.cinterop.CPointer

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawListSharedData(
  internal val ptr: CPointer<cimgui.internal.ImDrawListSharedData>
)
