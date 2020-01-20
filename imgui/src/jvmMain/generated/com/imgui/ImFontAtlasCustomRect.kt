package com.imgui

import cimgui.internal.CImGui.ImFontAtlasCustomRect_ImFontAtlasCustomRect
import cimgui.internal.CImGui.ImFontAtlasCustomRect_IsPacked
import cimgui.internal.CImGui.ImFontAtlasCustomRect_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.UInt
import kotlin.UShort

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontAtlasCustomRect(
  val ptr: cimgui.internal.ImFontAtlasCustomRect
) {
  actual val id: UInt
    get() = ptr.id.toUInt()

  actual val width: UShort
    get() = ptr.width.toUShort()

  actual val height: UShort
    get() = ptr.height.toUShort()

  actual val x: UShort
    get() = ptr.x.toUShort()

  actual val y: UShort
    get() = ptr.y.toUShort()

  actual val glyphAdvanceX: Float
    get() = ptr.glyphAdvanceX

  actual val glyphOffset: Vec2
    get() = ptr.glyphOffset.fromCValue()

  actual val font: ImFont?
    get() = ptr.font?.let(::ImFont)

  actual constructor() : this(ImFontAtlasCustomRect_ImFontAtlasCustomRect()!!)

  actual fun isPacked(): Boolean = ImFontAtlasCustomRect_IsPacked(ptr)

  actual fun destroy() {
    ImFontAtlasCustomRect_destroy(ptr)
  }
}
