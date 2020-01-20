package com.imgui

import kotlin.Suppress
import kotlinx.cinterop.CPointer

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiContext(
  internal val ptr: CPointer<cnames.structs.ImGuiContext>
)
