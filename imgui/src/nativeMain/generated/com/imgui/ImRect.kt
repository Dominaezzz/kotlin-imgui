package com.imgui

import cimgui.internal.ImRect_AddVec2
import cimgui.internal.ImRect_ContainsVec2
import cimgui.internal.ImRect_ExpandVec2
import cimgui.internal.ImRect_Floor
import cimgui.internal.ImRect_GetHeight
import cimgui.internal.ImRect_GetWidth
import cimgui.internal.ImRect_ImRectFloat
import cimgui.internal.ImRect_ImRectNil
import cimgui.internal.ImRect_ImRectVec2
import cimgui.internal.ImRect_ImRectVec4
import cimgui.internal.ImRect_IsInverted
import cimgui.internal.ImRect_Translate
import cimgui.internal.ImRect_TranslateX
import cimgui.internal.ImRect_TranslateY
import cimgui.internal.ImRect_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImRect(
  val ptr: CPointer<cimgui.internal.ImRect>
) {
  actual val min: Vec2
    get() = ptr.pointed.Min.fromCValue()

  actual val max: Vec2
    get() = ptr.pointed.Max.fromCValue()

  actual constructor() : this(ImRect_ImRectNil()!!)

  actual constructor(min: Vec2, max: Vec2) : this(ImRect_ImRectVec2(min.toCValue(),
      max.toCValue())!!)

  actual constructor(v: Vec4) : this(ImRect_ImRectVec4(v.toCValue())!!)

  actual constructor(
    x1: Float,
    y1: Float,
    x2: Float,
    y2: Float
  ) : this(ImRect_ImRectFloat(x1, y1, x2, y2)!!)

  actual fun add(p: Vec2) {
    ImRect_AddVec2(ptr, p.toCValue())
  }

  actual fun contains(p: Vec2): Boolean = ImRect_ContainsVec2(ptr, p.toCValue())

  actual fun expand(amount: Vec2) {
    ImRect_ExpandVec2(ptr, amount.toCValue())
  }

  actual fun floor() {
    ImRect_Floor(ptr)
  }

  actual fun getHeight(): Float = ImRect_GetHeight(ptr)

  actual fun getWidth(): Float = ImRect_GetWidth(ptr)

  actual fun isInverted(): Boolean = ImRect_IsInverted(ptr)

  actual fun translate(d: Vec2) {
    ImRect_Translate(ptr, d.toCValue())
  }

  actual fun translateX(dx: Float) {
    ImRect_TranslateX(ptr, dx)
  }

  actual fun translateY(dy: Float) {
    ImRect_TranslateY(ptr, dy)
  }

  actual fun destroy() {
    ImRect_destroy(ptr)
  }
}
