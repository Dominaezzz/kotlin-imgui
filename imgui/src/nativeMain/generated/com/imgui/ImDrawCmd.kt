package com.imgui

import cimgui.internal.ImDrawCmd_ImDrawCmd
import cimgui.internal.ImDrawCmd_destroy
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImDrawCmd(
  val ptr: CPointer<cimgui.internal.ImDrawCmd>
) {
  val elemCount: UInt
    get() = ptr.pointed.ElemCount

  val clipRect: Vec4
    get() = ptr.pointed.ClipRect.fromCValue()

  val textureId: ImTextureID?
    get() = ptr.pointed.TextureId?.let(::ImTextureID)

  val vtxOffset: UInt
    get() = ptr.pointed.VtxOffset

  val idxOffset: UInt
    get() = ptr.pointed.IdxOffset

  constructor() : this(ImDrawCmd_ImDrawCmd()!!)

  fun destroy() {
    ImDrawCmd_destroy(ptr)
  }
}