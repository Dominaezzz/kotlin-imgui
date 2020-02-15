package com.imgui

import cimgui.internal.ImFont_AddGlyph
import cimgui.internal.ImFont_AddRemapChar
import cimgui.internal.ImFont_BuildLookupTable
import cimgui.internal.ImFont_CalcTextSizeA
import cimgui.internal.ImFont_CalcWordWrapPositionA
import cimgui.internal.ImFont_ClearOutputData
import cimgui.internal.ImFont_FindGlyph
import cimgui.internal.ImFont_FindGlyphNoFallback
import cimgui.internal.ImFont_GetCharAdvance
import cimgui.internal.ImFont_GetDebugName
import cimgui.internal.ImFont_GrowIndex
import cimgui.internal.ImFont_ImFont
import cimgui.internal.ImFont_IsLoaded
import cimgui.internal.ImFont_RenderChar
import cimgui.internal.ImFont_RenderText
import cimgui.internal.ImFont_SetFallbackChar
import cimgui.internal.ImFont_destroy
import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFont(
  val ptr: CPointer<cimgui.internal.ImFont>
) {
  actual val fallbackAdvanceX: Float
    get() = ptr.pointed.FallbackAdvanceX

  actual val fontSize: Float
    get() = ptr.pointed.FontSize

  actual val fallbackGlyph: ImFontGlyph?
    get() = ptr.pointed.FallbackGlyph?.let(::ImFontGlyph)

  actual val displayOffset: Vec2
    get() = ptr.pointed.DisplayOffset.fromCValue()

  actual val containerAtlas: ImFontAtlas?
    get() = ptr.pointed.ContainerAtlas?.let(::ImFontAtlas)

  actual val configData: ImFontConfig?
    get() = ptr.pointed.ConfigData?.let(::ImFontConfig)

  actual val configDataCount: Short
    get() = ptr.pointed.ConfigDataCount

  actual val fallbackChar: Char
    get() = ptr.pointed.FallbackChar.toShort().toChar()

  actual val ellipsisChar: Char
    get() = ptr.pointed.EllipsisChar.toShort().toChar()

  actual val dirtyLookupTables: Boolean
    get() = ptr.pointed.DirtyLookupTables

  actual val scale: Float
    get() = ptr.pointed.Scale

  actual val ascent: Float
    get() = ptr.pointed.Ascent

  actual val descent: Float
    get() = ptr.pointed.Descent

  actual val metricsTotalSurface: Int
    get() = ptr.pointed.MetricsTotalSurface

  actual constructor() : this(ImFont_ImFont()!!)

  actual fun addGlyph(
    c: Char,
    x0: Float,
    y0: Float,
    x1: Float,
    y1: Float,
    u0: Float,
    v0: Float,
    u1: Float,
    v1: Float,
    advanceX: Float
  ) {
    ImFont_AddGlyph(ptr, c.toShort().toUShort(), x0, y0, x1, y1, u0, v0, u1, v1, advanceX)
  }

  actual fun addRemapChar(
    dst: Char,
    src: Char,
    overwriteDst: Boolean
  ) {
    ImFont_AddRemapChar(ptr, dst.toShort().toUShort(), src.toShort().toUShort(), overwriteDst)
  }

  actual fun buildLookupTable() {
    ImFont_BuildLookupTable(ptr)
  }

  actual fun calcTextSizeA(
    size: Float,
    maxWidth: Float,
    wrapWidth: Float,
    textBegin: String,
    textEnd: String?
  ): Vec2 = ImFont_CalcTextSizeA(ptr, size, maxWidth, wrapWidth, textBegin, textEnd,
      null).fromCValue()

  actual fun calcWordWrapPositionA(
    scale: Float,
    text: String,
    textEnd: String,
    wrapWidth: Float
  ): String? = ImFont_CalcWordWrapPositionA(ptr, scale, text, textEnd, wrapWidth)?.toKString()

  actual fun clearOutputData() {
    ImFont_ClearOutputData(ptr)
  }

  actual fun findGlyph(c: Char): ImFontGlyph = ImFont_FindGlyph(ptr,
      c.toShort().toUShort())!!.let(::ImFontGlyph)

  actual fun findGlyphNoFallback(c: Char): ImFontGlyph = ImFont_FindGlyphNoFallback(ptr,
      c.toShort().toUShort())!!.let(::ImFontGlyph)

  actual fun getCharAdvance(c: Char): Float = ImFont_GetCharAdvance(ptr, c.toShort().toUShort())

  actual fun getDebugName(): String? = ImFont_GetDebugName(ptr)?.toKString()

  actual fun growIndex(newSize: Int) {
    ImFont_GrowIndex(ptr, newSize)
  }

  actual fun isLoaded(): Boolean = ImFont_IsLoaded(ptr)

  actual fun renderChar(
    drawList: ImDrawList,
    size: Float,
    pos: Vec2,
    col: UInt,
    c: Char
  ) {
    ImFont_RenderChar(ptr, drawList.ptr, size, pos.toCValue(), col, c.toShort().toUShort())
  }

  actual fun renderText(
    drawList: ImDrawList,
    size: Float,
    pos: Vec2,
    col: UInt,
    clipRect: Vec4,
    textBegin: String,
    textEnd: String,
    wrapWidth: Float,
    cpuFineClip: Boolean
  ) {
    ImFont_RenderText(ptr, drawList.ptr, size, pos.toCValue(), col, clipRect.toCValue(), textBegin,
        textEnd, wrapWidth, cpuFineClip)
  }

  actual fun setFallbackChar(c: Char) {
    ImFont_SetFallbackChar(ptr, c.toShort().toUShort())
  }

  actual fun destroy() {
    ImFont_destroy(ptr)
  }
}
