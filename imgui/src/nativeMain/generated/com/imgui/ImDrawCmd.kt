package com.imgui

import cimgui.internal.ImDrawCmd_ImDrawCmd
import cimgui.internal.ImDrawCmd_destroy
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawCmd(
  val ptr: CPointer<cimgui.internal.ImDrawCmd>
) {
  actual val elemCount: UInt
    get() = ptr.pointed.ElemCount.toUInt()

  actual val clipRect: Vec4
    get() = ptr.pointed.ClipRect.fromCValue()

  actual val textureId: ImTextureID?
    get() = ptr.pointed.TextureId?.let(::ImTextureID)

  actual val vtxOffset: UInt
    get() = ptr.pointed.VtxOffset.toUInt()

  actual val idxOffset: UInt
    get() = ptr.pointed.IdxOffset.toUInt()

  actual constructor() : this(ImDrawCmd_ImDrawCmd()!!)

  actual fun destroy() {
    ImDrawCmd_destroy(ptr)
  }
}
