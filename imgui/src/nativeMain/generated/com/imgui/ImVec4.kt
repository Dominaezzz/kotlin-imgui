package com.imgui

import cimgui.internal.ImVec4_ImVec4
import cimgui.internal.ImVec4_ImVec4Float
import cimgui.internal.ImVec4_destroy
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImVec4(
  val ptr: CPointer<cimgui.internal.ImVec4>
) {
  actual val x: Float
    get() = ptr.pointed.x

  actual val y: Float
    get() = ptr.pointed.y

  actual val z: Float
    get() = ptr.pointed.z

  actual val w: Float
    get() = ptr.pointed.w

  actual constructor() : this(ImVec4_ImVec4()!!)

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
