package com.imgui

import kotlin.Suppress
import kotlinx.cinterop.CPointer

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiDataTypeTempStorage(
  val ptr: CPointer<cimgui.internal.ImGuiDataTypeTempStorage>
)
