package com.imgui

import cimgui.internal.CImGui.ImFont_AddGlyph
import cimgui.internal.CImGui.ImFont_AddRemapChar
import cimgui.internal.CImGui.ImFont_BuildLookupTable
import cimgui.internal.CImGui.ImFont_CalcTextSizeA_nonUDT
import cimgui.internal.CImGui.ImFont_CalcWordWrapPositionA
import cimgui.internal.CImGui.ImFont_ClearOutputData
import cimgui.internal.CImGui.ImFont_FindGlyph
import cimgui.internal.CImGui.ImFont_FindGlyphNoFallback
import cimgui.internal.CImGui.ImFont_GetCharAdvance
import cimgui.internal.CImGui.ImFont_GetDebugName
import cimgui.internal.CImGui.ImFont_GrowIndex
import cimgui.internal.CImGui.ImFont_ImFont
import cimgui.internal.CImGui.ImFont_IsLoaded
import cimgui.internal.CImGui.ImFont_RenderChar
import cimgui.internal.CImGui.ImFont_RenderText
import cimgui.internal.CImGui.ImFont_SetFallbackChar
import cimgui.internal.CImGui.ImFont_destroy
import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFont(
  val ptr: cimgui.internal.ImFont
) {
  actual val fallbackAdvanceX: Float
    get() = ptr.fallbackAdvanceX

  actual val fontSize: Float
    get() = ptr.fontSize

  actual val fallbackGlyph: ImFontGlyph?
    get() = ptr.fallbackGlyph?.let(::ImFontGlyph)

  actual val displayOffset: Vec2
    get() = ptr.displayOffset.fromCValue()

  actual val containerAtlas: ImFontAtlas?
    get() = ptr.containerAtlas?.let(::ImFontAtlas)

  actual val configData: ImFontConfig?
    get() = ptr.configData?.let(::ImFontConfig)

  actual val configDataCount: Short
    get() = ptr.configDataCount

  actual val fallbackChar: Char
    get() = ptr.fallbackChar.toShort().toChar()

  actual val ellipsisChar: Char
    get() = ptr.ellipsisChar.toShort().toChar()

  actual val dirtyLookupTables: Boolean
    get() = ptr.dirtyLookupTables

  actual val scale: Float
    get() = ptr.scale

  actual val ascent: Float
    get() = ptr.ascent

  actual val descent: Float
    get() = ptr.descent

  actual val metricsTotalSurface: Int
    get() = ptr.metricsTotalSurface

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
    ImFont_AddGlyph(ptr, c.toInt(), x0, y0, x1, y1, u0, v0, u1, v1, advanceX)
  }

  actual fun addRemapChar(
    dst: Char,
    src: Char,
    overwriteDst: Boolean
  ) {
    ImFont_AddRemapChar(ptr, dst.toInt(), src.toInt(), overwriteDst)
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
  ): Vec2 = returnVec2 { returnVal ->
    ImFont_CalcTextSizeA_nonUDT(returnVal, ptr, size, maxWidth, wrapWidth, textBegin, textEnd, null)
  }

  actual fun calcWordWrapPositionA(
    scale: Float,
    text: String,
    textEnd: String,
    wrapWidth: Float
  ): String? = ImFont_CalcWordWrapPositionA(ptr, scale, text, textEnd, wrapWidth)

  actual fun clearOutputData() {
    ImFont_ClearOutputData(ptr)
  }

  actual fun findGlyph(c: Char): ImFontGlyph = ImFont_FindGlyph(ptr, c.toInt())!!.let(::ImFontGlyph)

  actual fun findGlyphNoFallback(c: Char): ImFontGlyph = ImFont_FindGlyphNoFallback(ptr,
      c.toInt())!!.let(::ImFontGlyph)

  actual fun getCharAdvance(c: Char): Float = ImFont_GetCharAdvance(ptr, c.toInt())

  actual fun getDebugName(): String? = ImFont_GetDebugName(ptr)

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
    usingVec2 { ptrPos -> 
      ImFont_RenderChar(ptr, drawList.ptr, size, ptrPos, col.toLong(), c.toInt())
    }
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
    usingVec2 { ptrPos -> 
      usingVec4 { ptrClipRect -> 
        ImFont_RenderText(ptr, drawList.ptr, size, ptrPos, col.toLong(), ptrClipRect, textBegin,
            textEnd, wrapWidth, cpuFineClip)
      }
    }
  }

  actual fun setFallbackChar(c: Char) {
    ImFont_SetFallbackChar(ptr, c.toInt())
  }

  actual fun destroy() {
    ImFont_destroy(ptr)
  }
}
