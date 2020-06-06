package com.imgui

import cimgui.internal.CImGui.ImDrawData_Clear
import cimgui.internal.CImGui.ImDrawData_DeIndexAllBuffers
import cimgui.internal.CImGui.ImDrawData_ImDrawData
import cimgui.internal.CImGui.ImDrawData_ScaleClipRects
import cimgui.internal.CImGui.ImDrawData_destroy
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawData(
  val ptr: cimgui.internal.ImDrawData
) {
  actual val valid: Boolean
    get() = ptr.valid

  actual val cmdListsCount: Int
    get() = ptr.cmdListsCount

  actual val totalIdxCount: Int
    get() = ptr.totalIdxCount

  actual val totalVtxCount: Int
    get() = ptr.totalVtxCount

  actual val displayPos: Vec2
    get() = ptr.displayPos.fromCValue()

  actual val displaySize: Vec2
    get() = ptr.displaySize.fromCValue()

  actual val framebufferScale: Vec2
    get() = ptr.framebufferScale.fromCValue()

  actual val ownerViewport: ImGuiViewport?
    get() = ptr.ownerViewport?.let(::ImGuiViewport)

  actual constructor() : this(ImDrawData_ImDrawData()!!)

  actual fun clear() {
    ImDrawData_Clear(ptr)
  }

  actual fun deIndexAllBuffers() {
    ImDrawData_DeIndexAllBuffers(ptr)
  }

  actual fun scaleClipRects(fbScale: Vec2) {
    usingVec2 { ptrFbScale -> 
      ImDrawData_ScaleClipRects(ptr, ptrFbScale)
    }
  }

  actual fun destroy() {
    ImDrawData_destroy(ptr)
  }
}
