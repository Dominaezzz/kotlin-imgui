package com.imgui

import cimgui.internal.CImGui.ImGuiStyleMod_ImGuiStyleModFloat
import cimgui.internal.CImGui.ImGuiStyleMod_ImGuiStyleModInt
import cimgui.internal.CImGui.ImGuiStyleMod_ImGuiStyleModVec2
import cimgui.internal.CImGui.ImGuiStyleMod_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiStyleMod(
  val ptr: cimgui.internal.ImGuiStyleMod
) {
  actual val varIdx: ImGuiStyleVar
    get() = ptr.varIdx.let { ImGuiStyleVar.from(it) }

  actual constructor(idx: ImGuiStyleVar, v: Int) : this(ImGuiStyleMod_ImGuiStyleModInt(idx.value,
      v)!!)

  actual constructor(idx: ImGuiStyleVar, v: Float) :
      this(ImGuiStyleMod_ImGuiStyleModFloat(idx.value, v)!!)

  actual constructor(idx: ImGuiStyleVar, v: Vec2) : this(usingVec2 { ptrV -> 
    ImGuiStyleMod_ImGuiStyleModVec2(idx.value, ptrV)
  }!!)

  actual fun destroy() {
    ImGuiStyleMod_destroy(ptr)
  }
}
