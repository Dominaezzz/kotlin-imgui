package com.imgui

import cimgui.internal.ImFontAtlas_AddCustomRectFontGlyph
import cimgui.internal.ImFontAtlas_AddCustomRectRegular
import cimgui.internal.ImFontAtlas_AddFont
import cimgui.internal.ImFontAtlas_AddFontDefault
import cimgui.internal.ImFontAtlas_AddFontFromFileTTF
import cimgui.internal.ImFontAtlas_AddFontFromMemoryCompressedBase85TTF
import cimgui.internal.ImFontAtlas_Build
import cimgui.internal.ImFontAtlas_CalcCustomRectUV
import cimgui.internal.ImFontAtlas_Clear
import cimgui.internal.ImFontAtlas_ClearFonts
import cimgui.internal.ImFontAtlas_ClearInputData
import cimgui.internal.ImFontAtlas_ClearTexData
import cimgui.internal.ImFontAtlas_GetCustomRectByIndex
import cimgui.internal.ImFontAtlas_GetGlyphRangesChineseFull
import cimgui.internal.ImFontAtlas_GetGlyphRangesChineseSimplifiedCommon
import cimgui.internal.ImFontAtlas_GetGlyphRangesCyrillic
import cimgui.internal.ImFontAtlas_GetGlyphRangesDefault
import cimgui.internal.ImFontAtlas_GetGlyphRangesJapanese
import cimgui.internal.ImFontAtlas_GetGlyphRangesKorean
import cimgui.internal.ImFontAtlas_GetGlyphRangesThai
import cimgui.internal.ImFontAtlas_GetGlyphRangesVietnamese
import cimgui.internal.ImFontAtlas_ImFontAtlas
import cimgui.internal.ImFontAtlas_IsBuilt
import cimgui.internal.ImFontAtlas_SetTexID
import cimgui.internal.ImFontAtlas_destroy
import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString
import kotlinx.cinterop.wcstr

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontAtlas(
  val ptr: CPointer<cimgui.internal.ImFontAtlas>
) {
  actual val locked: Boolean
    get() = ptr.pointed.Locked

  actual val flags: Flag<ImFontAtlasFlags>
    get() = ptr.pointed.Flags.let { ImFontAtlasFlags.fromMultiple(it) }

  actual val texID: ImTextureID?
    get() = ptr.pointed.TexID?.let(::ImTextureID)

  actual val texDesiredWidth: Int
    get() = ptr.pointed.TexDesiredWidth

  actual val texGlyphPadding: Int
    get() = ptr.pointed.TexGlyphPadding

  actual val texWidth: Int
    get() = ptr.pointed.TexWidth

  actual val texHeight: Int
    get() = ptr.pointed.TexHeight

  actual val texUvScale: Vec2
    get() = ptr.pointed.TexUvScale.fromCValue()

  actual val texUvWhitePixel: Vec2
    get() = ptr.pointed.TexUvWhitePixel.fromCValue()

  actual constructor() : this(ImFontAtlas_ImFontAtlas()!!)

  actual fun addCustomRectFontGlyph(
    font: ImFont,
    id: Char,
    width: Int,
    height: Int,
    advanceX: Float,
    offset: Vec2
  ): Int = ImFontAtlas_AddCustomRectFontGlyph(ptr, font.ptr, id.toShort().toUShort(), width, height,
      advanceX, offset.toCValue())

  actual fun addCustomRectRegular(
    id: UInt,
    width: Int,
    height: Int
  ): Int = ImFontAtlas_AddCustomRectRegular(ptr, id, width, height)

  actual fun addFont(fontCfg: ImFontConfig): ImFont = ImFontAtlas_AddFont(ptr,
      fontCfg.ptr)!!.let(::ImFont)

  actual fun addFontDefault(fontCfg: ImFontConfig?): ImFont = ImFontAtlas_AddFontDefault(ptr,
      fontCfg?.ptr)!!.let(::ImFont)

  actual fun addFontFromFileTTF(
    filename: String,
    sizePixels: Float,
    fontCfg: ImFontConfig?,
    glyphRanges: String?
  ): ImFont = ImFontAtlas_AddFontFromFileTTF(ptr, filename, sizePixels, fontCfg?.ptr,
      glyphRanges?.wcstr)!!.let(::ImFont)

  actual fun addFontFromMemoryCompressedBase85TTF(
    compressedFontDataBase85: String,
    sizePixels: Float,
    fontCfg: ImFontConfig?,
    glyphRanges: String?
  ): ImFont = ImFontAtlas_AddFontFromMemoryCompressedBase85TTF(ptr, compressedFontDataBase85,
      sizePixels, fontCfg?.ptr, glyphRanges?.wcstr)!!.let(::ImFont)

  actual fun build(): Boolean = ImFontAtlas_Build(ptr)

  actual fun calcCustomRectUV(
    rect: ImFontAtlasCustomRect,
    outUvMin: ImVec2,
    outUvMax: ImVec2
  ) {
    ImFontAtlas_CalcCustomRectUV(ptr, rect.ptr, outUvMin.ptr, outUvMax.ptr)
  }

  actual fun clear() {
    ImFontAtlas_Clear(ptr)
  }

  actual fun clearFonts() {
    ImFontAtlas_ClearFonts(ptr)
  }

  actual fun clearInputData() {
    ImFontAtlas_ClearInputData(ptr)
  }

  actual fun clearTexData() {
    ImFontAtlas_ClearTexData(ptr)
  }

  actual fun getCustomRectByIndex(index: Int): ImFontAtlasCustomRect =
      ImFontAtlas_GetCustomRectByIndex(ptr, index)!!.let(::ImFontAtlasCustomRect)

  actual fun getGlyphRangesChineseFull(): String =
      ImFontAtlas_GetGlyphRangesChineseFull(ptr)!!.toKString()

  actual fun getGlyphRangesChineseSimplifiedCommon(): String =
      ImFontAtlas_GetGlyphRangesChineseSimplifiedCommon(ptr)!!.toKString()

  actual fun getGlyphRangesCyrillic(): String =
      ImFontAtlas_GetGlyphRangesCyrillic(ptr)!!.toKString()

  actual fun getGlyphRangesDefault(): String = ImFontAtlas_GetGlyphRangesDefault(ptr)!!.toKString()

  actual fun getGlyphRangesJapanese(): String =
      ImFontAtlas_GetGlyphRangesJapanese(ptr)!!.toKString()

  actual fun getGlyphRangesKorean(): String = ImFontAtlas_GetGlyphRangesKorean(ptr)!!.toKString()

  actual fun getGlyphRangesThai(): String = ImFontAtlas_GetGlyphRangesThai(ptr)!!.toKString()

  actual fun getGlyphRangesVietnamese(): String =
      ImFontAtlas_GetGlyphRangesVietnamese(ptr)!!.toKString()

  actual fun isBuilt(): Boolean = ImFontAtlas_IsBuilt(ptr)

  actual fun setTexID(id: ImTextureID) {
    ImFontAtlas_SetTexID(ptr, id.value)
  }

  actual fun destroy() {
    ImFontAtlas_destroy(ptr)
  }
}
