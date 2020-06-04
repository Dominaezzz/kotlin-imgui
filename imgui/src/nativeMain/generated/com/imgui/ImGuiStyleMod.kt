package com.imgui

import cimgui.internal.ImGuiStyleMod_ImGuiStyleModFloat
import cimgui.internal.ImGuiStyleMod_ImGuiStyleModInt
import cimgui.internal.ImGuiStyleMod_ImGuiStyleModVec2
import cimgui.internal.ImGuiStyleMod_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiStyleMod(
  val ptr: CPointer<cimgui.internal.ImGuiStyleMod>
) {
  actual val varIdx: ImGuiStyleVar
    get() = ptr.pointed.VarIdx.let { ImGuiStyleVar.from(it) }

  actual constructor(idx: ImGuiStyleVar, v: Int) : this(ImGuiStyleMod_ImGuiStyleModInt(idx.value,
      v)!!)

  actual constructor(idx: ImGuiStyleVar, v: Float) :
      this(ImGuiStyleMod_ImGuiStyleModFloat(idx.value, v)!!)

  actual constructor(idx: ImGuiStyleVar, v: Vec2) : this(ImGuiStyleMod_ImGuiStyleModVec2(idx.value,
      v.toCValue())!!)

  actual fun destroy() {
    ImGuiStyleMod_destroy(ptr)
  }
}
