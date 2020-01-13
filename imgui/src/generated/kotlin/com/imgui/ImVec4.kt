package com.imgui

import cimgui.internal.ImVec4_ImVec4
import cimgui.internal.ImVec4_ImVec4Float
import cimgui.internal.ImVec4_destroy
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

  constructor() : this(ImVec4_ImVec4()!!)

  constructor(
    x: Float,
    y: Float,
    z: Float,
    w: Float
  ) : this(ImVec4_ImVec4Float(x, y, z, w)!!)

  fun destroy() {
    ImVec4_destroy(ptr)
  }
}
