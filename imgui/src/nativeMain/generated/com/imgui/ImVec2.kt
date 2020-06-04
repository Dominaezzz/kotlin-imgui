package com.imgui

import cimgui.internal.ImVec2_ImVec2Float
import cimgui.internal.ImVec2_ImVec2Nil
import cimgui.internal.ImVec2_destroy
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImVec2(
  val ptr: CPointer<cimgui.internal.ImVec2>
) {
  actual val x: Float
    get() = ptr.pointed.x

  actual val y: Float
    get() = ptr.pointed.y

  actual constructor() : this(ImVec2_ImVec2Nil()!!)

  actual constructor(x: Float, y: Float) : this(ImVec2_ImVec2Float(x, y)!!)

  actual fun destroy() {
    ImVec2_destroy(ptr)
  }
}
