package com.imgui

import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImDrawCmd(
  val ptr: CPointer<cimgui.internal.ImDrawCmd>
) {
  val elemCount: UInt
    get() = ptr.pointed.ElemCount

  val vtxOffset: UInt
    get() = ptr.pointed.VtxOffset

  val idxOffset: UInt
    get() = ptr.pointed.IdxOffset
}
