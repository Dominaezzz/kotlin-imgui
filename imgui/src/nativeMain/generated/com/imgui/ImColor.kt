package com.imgui

import cimgui.internal.ImColor_ImColor
import cimgui.internal.ImColor_ImColorFloat
import cimgui.internal.ImColor_ImColorInt
import cimgui.internal.ImColor_ImColorU32
import cimgui.internal.ImColor_ImColorVec4
import cimgui.internal.ImColor_SetHSV
import cimgui.internal.ImColor_destroy
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImColor(
  val ptr: CPointer<cimgui.internal.ImColor>
) {
  val value: Vec4
    get() = ptr.pointed.Value.fromCValue()

  constructor() : this(ImColor_ImColor()!!)

  constructor(
    r: Int,
    g: Int,
    b: Int,
    a: Int = 255
  ) : this(ImColor_ImColorInt(r, g, b, a)!!)

  constructor(rgba: UInt) : this(ImColor_ImColorU32(rgba)!!)

  constructor(
    r: Float,
    g: Float,
    b: Float,
    a: Float = 1.0f
  ) : this(ImColor_ImColorFloat(r, g, b, a)!!)

  constructor(col: Vec4) : this(ImColor_ImColorVec4(col.toCValue())!!)

  fun setHSV(
    h: Float,
    s: Float,
    v: Float,
    a: Float = 1.0f
  ) {
    ImColor_SetHSV(ptr, h, s, v, a)
  }

  fun destroy() {
    ImColor_destroy(ptr)
  }
}
