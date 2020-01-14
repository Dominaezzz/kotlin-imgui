package com.imgui

import cimgui.internal.ImVec2_ImVec2
import cimgui.internal.ImVec2_ImVec2Float
import cimgui.internal.ImVec2_destroy
import kotlin.Float
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImVec2(
  val ptr: CPointer<cimgui.internal.ImVec2>
) {
  val x: Float
    get() = ptr.pointed.x

  val y: Float
    get() = ptr.pointed.y

  constructor() : this(ImVec2_ImVec2()!!)

  constructor(x: Float, y: Float) : this(ImVec2_ImVec2Float(x, y)!!)

  fun destroy() {
    ImVec2_destroy(ptr)
  }
}
