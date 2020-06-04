package com.imgui

import cimgui.internal.ImColor_ImColorFloat
import cimgui.internal.ImColor_ImColorInt
import cimgui.internal.ImColor_ImColorNil
import cimgui.internal.ImColor_ImColorU32
import cimgui.internal.ImColor_ImColorVec4
import cimgui.internal.ImColor_SetHSV
import cimgui.internal.ImColor_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImColor(
  val ptr: CPointer<cimgui.internal.ImColor>
) {
  actual val value: Vec4
    get() = ptr.pointed.Value.fromCValue()

  actual constructor() : this(ImColor_ImColorNil()!!)

  actual constructor(
    r: Int,
    g: Int,
    b: Int,
    a: Int
  ) : this(ImColor_ImColorInt(r, g, b, a)!!)

  actual constructor(rgba: UInt) : this(ImColor_ImColorU32(rgba)!!)

  actual constructor(
    r: Float,
    g: Float,
    b: Float,
    a: Float
  ) : this(ImColor_ImColorFloat(r, g, b, a)!!)

  actual constructor(col: Vec4) : this(ImColor_ImColorVec4(col.toCValue())!!)

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
