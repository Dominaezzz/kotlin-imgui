package com.imgui

import kotlin.Float
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImVec4(
  val ptr: CPointer<cimgui.internal.ImVec4>
) {
  val x: Float
    get() = ptr.pointed.x

  val y: Float
    get() = ptr.pointed.y

  val z: Float
    get() = ptr.pointed.z

  val w: Float
    get() = ptr.pointed.w
}
