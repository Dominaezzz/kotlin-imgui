package com.imgui

import cimgui.internal.CImGui.ImVec1_ImVec1Float
import cimgui.internal.CImGui.ImVec1_ImVec1Nil
import cimgui.internal.CImGui.ImVec1_destroy
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImVec1(
  val ptr: cimgui.internal.ImVec1
) {
  actual val x: Float
    get() = ptr.x

  actual constructor() : this(ImVec1_ImVec1Nil()!!)

  actual constructor(x: Float) : this(ImVec1_ImVec1Float(x)!!)

  actual fun destroy() {
    ImVec1_destroy(ptr)
  }
}
