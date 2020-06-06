package com.imgui

import cimgui.internal.ImDrawData_Clear
import cimgui.internal.ImDrawData_DeIndexAllBuffers
import cimgui.internal.ImDrawData_ImDrawData
import cimgui.internal.ImDrawData_ScaleClipRects
import cimgui.internal.ImDrawData_destroy
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawData(
  val ptr: CPointer<cimgui.internal.ImDrawData>
) {
  actual val valid: Boolean
    get() = ptr.pointed.Valid

  actual val cmdListsCount: Int
    get() = ptr.pointed.CmdListsCount

  actual val totalIdxCount: Int
    get() = ptr.pointed.TotalIdxCount

  actual val totalVtxCount: Int
    get() = ptr.pointed.TotalVtxCount

  actual val displayPos: Vec2
    get() = ptr.pointed.DisplayPos.fromCValue()

  actual val displaySize: Vec2
    get() = ptr.pointed.DisplaySize.fromCValue()

  actual val framebufferScale: Vec2
    get() = ptr.pointed.FramebufferScale.fromCValue()

  actual val ownerViewport: ImGuiViewport?
    get() = ptr.pointed.OwnerViewport?.let(::ImGuiViewport)

  actual constructor() : this(ImDrawData_ImDrawData()!!)

  actual fun clear() {
    ImDrawData_Clear(ptr)
  }

  actual fun deIndexAllBuffers() {
    ImDrawData_DeIndexAllBuffers(ptr)
  }

  actual fun scaleClipRects(fbScale: Vec2) {
    ImDrawData_ScaleClipRects(ptr, fbScale.toCValue())
  }

  actual fun destroy() {
    ImDrawData_destroy(ptr)
  }
}
