package com.imgui

import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiContext(
  internal val ptr: cimgui.internal.ImGuiContext
)
