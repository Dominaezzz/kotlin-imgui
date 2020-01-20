package com.imgui

import cimgui.internal.CImGui.ImVec2_ImVec2
import cimgui.internal.CImGui.ImVec2_ImVec2Float
import cimgui.internal.CImGui.ImVec2_destroy
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImVec2(
  val ptr: cimgui.internal.ImVec2
) {
  actual val x: Float
    get() = ptr.x

  actual val y: Float
    get() = ptr.y

  actual constructor() : this(ImVec2_ImVec2()!!)

  actual constructor(x: Float, y: Float) : this(ImVec2_ImVec2Float(x, y)!!)

  actual fun destroy() {
    ImVec2_destroy(ptr)
  }
}
