package com.imgui

import kotlin.Suppress
import kotlinx.cinterop.CPointer

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawChannel(
  val ptr: CPointer<cimgui.internal.ImDrawChannel>
)
