package com.imgui

import cimgui.internal.CImGui.ImDrawCmd_ImDrawCmd
import cimgui.internal.CImGui.ImDrawCmd_destroy
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawCmd(
  val ptr: cimgui.internal.ImDrawCmd
) {
  actual val clipRect: Vec4
    get() = ptr.clipRect.fromCValue()

  actual val textureId: ImTextureID?
    get() = ptr.textureId?.let(::ImTextureID)

  actual val vtxOffset: UInt
    get() = ptr.vtxOffset.toUInt()

  actual val idxOffset: UInt
    get() = ptr.idxOffset.toUInt()

  actual val elemCount: UInt
    get() = ptr.elemCount.toUInt()

  actual constructor() : this(ImDrawCmd_ImDrawCmd()!!)

  actual fun destroy() {
    ImDrawCmd_destroy(ptr)
  }
}
