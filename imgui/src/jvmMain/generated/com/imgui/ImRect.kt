package com.imgui

import cimgui.internal.CImGui.ImRect_AddVec2
import cimgui.internal.CImGui.ImRect_ContainsVec2
import cimgui.internal.CImGui.ImRect_ExpandVec2
import cimgui.internal.CImGui.ImRect_Floor
import cimgui.internal.CImGui.ImRect_GetHeight
import cimgui.internal.CImGui.ImRect_GetWidth
import cimgui.internal.CImGui.ImRect_ImRectFloat
import cimgui.internal.CImGui.ImRect_ImRectNil
import cimgui.internal.CImGui.ImRect_ImRectVec2
import cimgui.internal.CImGui.ImRect_ImRectVec4
import cimgui.internal.CImGui.ImRect_IsInverted
import cimgui.internal.CImGui.ImRect_Translate
import cimgui.internal.CImGui.ImRect_TranslateX
import cimgui.internal.CImGui.ImRect_TranslateY
import cimgui.internal.CImGui.ImRect_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImRect(
  val ptr: cimgui.internal.ImRect
) {
  actual val min: Vec2
    get() = ptr.min.fromCValue()

  actual val max: Vec2
    get() = ptr.max.fromCValue()

  actual constructor() : this(ImRect_ImRectNil()!!)

  actual constructor(min: Vec2, max: Vec2) : this(usingVec2 { ptrMin -> 
    usingVec2 { ptrMax -> 
      ImRect_ImRectVec2(ptrMin, ptrMax)
    }
  }!!)

  actual constructor(v: Vec4) : this(usingVec4 { ptrV -> 
    ImRect_ImRectVec4(ptrV)
  }!!)

  actual constructor(
    x1: Float,
    y1: Float,
    x2: Float,
    y2: Float
  ) : this(ImRect_ImRectFloat(x1, y1, x2, y2)!!)

  actual fun add(p: Vec2) {
    usingVec2 { ptrP -> 
      ImRect_AddVec2(ptr, ptrP)
    }
  }

  actual fun contains(p: Vec2): Boolean = usingVec2 { ptrP -> 
    ImRect_ContainsVec2(ptr, ptrP)
  }

  actual fun expand(amount: Vec2) {
    usingVec2 { ptrAmount -> 
      ImRect_ExpandVec2(ptr, ptrAmount)
    }
  }

  actual fun floor() {
    ImRect_Floor(ptr)
  }

  actual fun getHeight(): Float = ImRect_GetHeight(ptr)

  actual fun getWidth(): Float = ImRect_GetWidth(ptr)

  actual fun isInverted(): Boolean = ImRect_IsInverted(ptr)

  actual fun translate(d: Vec2) {
    usingVec2 { ptrD -> 
      ImRect_Translate(ptr, ptrD)
    }
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
