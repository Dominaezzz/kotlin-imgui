package com.imgui

import cimgui.internal.ImVec1_ImVec1Float
import cimgui.internal.ImVec1_ImVec1Nil
import cimgui.internal.ImVec1_destroy
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImVec1(
  val ptr: CPointer<cimgui.internal.ImVec1>
) {
  actual val x: Float
    get() = ptr.pointed.x

  actual constructor() : this(ImVec1_ImVec1Nil()!!)

  actual constructor(x: Float) : this(ImVec1_ImVec1Float(x)!!)

  actual fun destroy() {
    ImVec1_destroy(ptr)
  }
}
