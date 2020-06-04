package com.imgui

import cimgui.internal.CImGui.ImColor_ImColorFloat
import cimgui.internal.CImGui.ImColor_ImColorInt
import cimgui.internal.CImGui.ImColor_ImColorNil
import cimgui.internal.CImGui.ImColor_ImColorU32
import cimgui.internal.CImGui.ImColor_ImColorVec4
import cimgui.internal.CImGui.ImColor_SetHSV
import cimgui.internal.CImGui.ImColor_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImColor(
  val ptr: cimgui.internal.ImColor
) {
  actual val value: Vec4
    get() = ptr.value.fromCValue()

  actual constructor() : this(ImColor_ImColorNil()!!)

  actual constructor(
    r: Int,
    g: Int,
    b: Int,
    a: Int
  ) : this(ImColor_ImColorInt(r, g, b, a)!!)

  actual constructor(rgba: UInt) : this(ImColor_ImColorU32(rgba.toLong())!!)

  actual constructor(
    r: Float,
    g: Float,
    b: Float,
    a: Float
  ) : this(ImColor_ImColorFloat(r, g, b, a)!!)

  actual constructor(col: Vec4) : this(usingVec4 { ptrCol -> 
    ImColor_ImColorVec4(ptrCol)
  }!!)

  actual fun setHSV(
    h: Float,
    s: Float,
    v: Float,
    a: Float
  ) {
    ImColor_SetHSV(ptr, h, s, v, a)
  }

  actual fun destroy() {
    ImColor_destroy(ptr)
  }
}
