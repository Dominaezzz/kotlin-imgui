package com.imgui

import cimgui.internal.CImGui.ImVec4_ImVec4Float
import cimgui.internal.CImGui.ImVec4_ImVec4Nil
import cimgui.internal.CImGui.ImVec4_destroy
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImVec4(
  val ptr: cimgui.internal.ImVec4
) {
  actual val x: Float
    get() = ptr.x

  actual val y: Float
    get() = ptr.y

  actual val z: Float
    get() = ptr.z

  actual val w: Float
    get() = ptr.w

  actual constructor() : this(ImVec4_ImVec4Nil()!!)

  actual constructor(
    x: Float,
    y: Float,
    z: Float,
    w: Float
  ) : this(ImVec4_ImVec4Float(x, y, z, w)!!)

  actual fun destroy() {
    ImVec4_destroy(ptr)
  }
}
