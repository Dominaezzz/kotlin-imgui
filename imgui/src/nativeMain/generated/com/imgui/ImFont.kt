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
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

inline class ImFont(
  val ptr: CPointer<cimgui.internal.ImFont>
) {
  val fallbackAdvanceX: Float
    get() = ptr.pointed.FallbackAdvanceX

  val fontSize: Float
    get() = ptr.pointed.FontSize

  val fallbackGlyph: ImFontGlyph?
    get() = ptr.pointed.FallbackGlyph?.let(::ImFontGlyph)

  val displayOffset: Vec2
    get() = ptr.pointed.DisplayOffset.fromCValue()

  val containerAtlas: ImFontAtlas?
    get() = ptr.pointed.ContainerAtlas?.let(::ImFontAtlas)

  val configData: ImFontConfig?
    get() = ptr.pointed.ConfigData?.let(::ImFontConfig)

  val configDataCount: Short
    get() = ptr.pointed.ConfigDataCount

  val fallbackChar: Char
    get() = ptr.pointed.FallbackChar.toShort().toChar()

  val ellipsisChar: Char
    get() = ptr.pointed.EllipsisChar.toShort().toChar()

  val scale: Float
    get() = ptr.pointed.Scale

  val ascent: Float
    get() = ptr.pointed.Ascent

  val descent: Float
    get() = ptr.pointed.Descent

  val metricsTotalSurface: Int
    get() = ptr.pointed.MetricsTotalSurface

  val dirtyLookupTables: Boolean
    get() = ptr.pointed.DirtyLookupTables

  constructor() : this(ImFont_ImFont()!!)

  fun addGlyph(
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

  fun addRemapChar(
    dst: Char,
    src: Char,
    overwriteDst: Boolean = true
  ) {
    ImFont_AddRemapChar(ptr, dst.toShort().toUShort(), src.toShort().toUShort(), overwriteDst)
  }

  fun buildLookupTable() {
    ImFont_BuildLookupTable(ptr)
  }

  fun calcTextSizeA(
    size: Float,
    maxWidth: Float,
    wrapWidth: Float,
    textBegin: String,
    textEnd: String? = null
  ): Vec2 = ImFont_CalcTextSizeA(ptr, size, maxWidth, wrapWidth, textBegin, textEnd,
      null).fromCValue()

  fun calcWordWrapPositionA(
    scale: Float,
    text: String,
    textEnd: String,
    wrapWidth: Float
  ): String? = ImFont_CalcWordWrapPositionA(ptr, scale, text, textEnd, wrapWidth)?.toKString()

  fun clearOutputData() {
    ImFont_ClearOutputData(ptr)
  }

  fun findGlyph(c: Char): ImFontGlyph = ImFont_FindGlyph(ptr,
      c.toShort().toUShort())!!.let(::ImFontGlyph)

  fun findGlyphNoFallback(c: Char): ImFontGlyph = ImFont_FindGlyphNoFallback(ptr,
      c.toShort().toUShort())!!.let(::ImFontGlyph)

  fun getCharAdvance(c: Char): Float = ImFont_GetCharAdvance(ptr, c.toShort().toUShort())

  fun getDebugName(): String? = ImFont_GetDebugName(ptr)?.toKString()

  fun growIndex(newSize: Int) {
    ImFont_GrowIndex(ptr, newSize)
  }

  fun isLoaded(): Boolean = ImFont_IsLoaded(ptr)

  fun renderChar(
    drawList: ImDrawList,
    size: Float,
    pos: Vec2,
    col: UInt,
    c: Char
  ) {
    ImFont_RenderChar(ptr, drawList.ptr, size, pos.toCValue(), col, c.toShort().toUShort())
  }

  fun renderText(
    drawList: ImDrawList,
    size: Float,
    pos: Vec2,
    col: UInt,
    clipRect: Vec4,
    textBegin: String,
    textEnd: String,
    wrapWidth: Float = 0.0f,
    cpuFineClip: Boolean = false
  ) {
    ImFont_RenderText(ptr, drawList.ptr, size, pos.toCValue(), col, clipRect.toCValue(), textBegin,
        textEnd, wrapWidth, cpuFineClip)
  }

  fun setFallbackChar(c: Char) {
    ImFont_SetFallbackChar(ptr, c.toShort().toUShort())
  }

  fun destroy() {
    ImFont_destroy(ptr)
  }
}
