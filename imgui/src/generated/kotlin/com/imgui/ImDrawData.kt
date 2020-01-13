package com.imgui

import cimgui.internal.ImDrawData_Clear
import cimgui.internal.ImDrawData_DeIndexAllBuffers
import cimgui.internal.ImDrawData_ImDrawData
import cimgui.internal.ImDrawData_ScaleClipRects
import cimgui.internal.ImDrawData_destroy
import kotlin.Boolean
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImDrawData(
  val ptr: CPointer<cimgui.internal.ImDrawData>
) {
  val valid: Boolean
    get() = ptr.pointed.Valid

  val cmdListsCount: Int
    get() = ptr.pointed.CmdListsCount

  val totalIdxCount: Int
    get() = ptr.pointed.TotalIdxCount

  val totalVtxCount: Int
    get() = ptr.pointed.TotalVtxCount

  val displayPos: Vec2
    get() = ptr.pointed.DisplayPos.fromCValue()

  val displaySize: Vec2
    get() = ptr.pointed.DisplaySize.fromCValue()

  val framebufferScale: Vec2
    get() = ptr.pointed.FramebufferScale.fromCValue()

  constructor() : this(ImDrawData_ImDrawData()!!)

  fun clear() {
    ImDrawData_Clear(ptr)
  }

  fun deIndexAllBuffers() {
    ImDrawData_DeIndexAllBuffers(ptr)
  }

  fun scaleClipRects(fbScale: Vec2) {
    ImDrawData_ScaleClipRects(ptr, fbScale.toCValue())
  }

  fun destroy() {
    ImDrawData_destroy(ptr)
  }
}
