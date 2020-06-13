package com.imgui

import cimgui.internal.CImGui.ImFontAtlas_AddCustomRectFontGlyph
import cimgui.internal.CImGui.ImFontAtlas_AddCustomRectRegular
import cimgui.internal.CImGui.ImFontAtlas_AddFont
import cimgui.internal.CImGui.ImFontAtlas_AddFontDefault
import cimgui.internal.CImGui.ImFontAtlas_AddFontFromFileTTF
import cimgui.internal.CImGui.ImFontAtlas_AddFontFromMemoryCompressedBase85TTF
import cimgui.internal.CImGui.ImFontAtlas_Build
import cimgui.internal.CImGui.ImFontAtlas_CalcCustomRectUV
import cimgui.internal.CImGui.ImFontAtlas_Clear
import cimgui.internal.CImGui.ImFontAtlas_ClearFonts
import cimgui.internal.CImGui.ImFontAtlas_ClearInputData
import cimgui.internal.CImGui.ImFontAtlas_ClearTexData
import cimgui.internal.CImGui.ImFontAtlas_GetCustomRectByIndex
import cimgui.internal.CImGui.ImFontAtlas_GetGlyphRangesChineseFull
import cimgui.internal.CImGui.ImFontAtlas_GetGlyphRangesChineseSimplifiedCommon
import cimgui.internal.CImGui.ImFontAtlas_GetGlyphRangesCyrillic
import cimgui.internal.CImGui.ImFontAtlas_GetGlyphRangesDefault
import cimgui.internal.CImGui.ImFontAtlas_GetGlyphRangesJapanese
import cimgui.internal.CImGui.ImFontAtlas_GetGlyphRangesKorean
import cimgui.internal.CImGui.ImFontAtlas_GetGlyphRangesThai
import cimgui.internal.CImGui.ImFontAtlas_GetGlyphRangesVietnamese
import cimgui.internal.CImGui.ImFontAtlas_ImFontAtlas
import cimgui.internal.CImGui.ImFontAtlas_IsBuilt
import cimgui.internal.CImGui.ImFontAtlas_SetTexID
import cimgui.internal.CImGui.ImFontAtlas_destroy
import cimgui.internal.CImGui.intArray_getitem
import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontAtlas(
  val ptr: cimgui.internal.ImFontAtlas
) {
  actual val locked: Boolean
    get() = ptr.locked

  actual val flags: Flag<ImFontAtlasFlags>
    get() = ptr.flags.let { ImFontAtlasFlags.fromMultiple(it) }

  actual val texID: ImTextureID?
    get() = ptr.texID?.let(::ImTextureID)

  actual val texDesiredWidth: Int
    get() = ptr.texDesiredWidth

  actual val texGlyphPadding: Int
    get() = ptr.texGlyphPadding

  actual val texWidth: Int
    get() = ptr.texWidth

  actual val texHeight: Int
    get() = ptr.texHeight

  actual val texUvScale: Vec2
    get() = ptr.texUvScale.fromCValue()

  actual val texUvWhitePixel: Vec2
    get() = ptr.texUvWhitePixel.fromCValue()

  actual constructor() : this(ImFontAtlas_ImFontAtlas()!!)

  actual fun customRectIds(index: Int): Int {
    require(index in 0..1)
    return intArray_getitem(ptr.customRectIds, index)
  }

  actual fun addCustomRectFontGlyph(
    font: ImFont,
    id: Char,
    width: Int,
    height: Int,
    advanceX: Float,
    offset: Vec2
  ): Int = usingVec2 { ptrOffset -> 
    ImFontAtlas_AddCustomRectFontGlyph(ptr, font.ptr, id.toInt(), width, height, advanceX,
        ptrOffset)
  }

  actual fun addCustomRectRegular(
    id: UInt,
    width: Int,
    height: Int
  ): Int = ImFontAtlas_AddCustomRectRegular(ptr, id.toLong(), width, height)

  actual fun addFont(fontCfg: ImFontConfig): ImFont = ImFontAtlas_AddFont(ptr,
      fontCfg.ptr)!!.let(::ImFont)

  actual fun addFontDefault(fontCfg: ImFontConfig?): ImFont = ImFontAtlas_AddFontDefault(ptr,
      fontCfg?.ptr)!!.let(::ImFont)

  actual fun addFontFromFileTTF(
    filename: String,
    sizePixels: Float,
    fontCfg: ImFontConfig?,
    glyphRanges: String?
  ): ImFont = glyphRanges.usingUTF16String { ptrGlyphRanges -> 
    ImFontAtlas_AddFontFromFileTTF(ptr, filename, sizePixels, fontCfg?.ptr, ptrGlyphRanges)
  }!!.let(::ImFont)

  actual fun addFontFromMemoryCompressedBase85TTF(
    compressedFontDataBase85: String,
    sizePixels: Float,
    fontCfg: ImFontConfig?,
    glyphRanges: String?
  ): ImFont = glyphRanges.usingUTF16String { ptrGlyphRanges -> 
    ImFontAtlas_AddFontFromMemoryCompressedBase85TTF(ptr, compressedFontDataBase85, sizePixels,
        fontCfg?.ptr, ptrGlyphRanges)
  }!!.let(::ImFont)

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
      ImFontAtlas_GetGlyphRangesChineseFull(ptr)!!.toUTF16String()

  actual fun getGlyphRangesChineseSimplifiedCommon(): String =
      ImFontAtlas_GetGlyphRangesChineseSimplifiedCommon(ptr)!!.toUTF16String()

  actual fun getGlyphRangesCyrillic(): String =
      ImFontAtlas_GetGlyphRangesCyrillic(ptr)!!.toUTF16String()

  actual fun getGlyphRangesDefault(): String =
      ImFontAtlas_GetGlyphRangesDefault(ptr)!!.toUTF16String()

  actual fun getGlyphRangesJapanese(): String =
      ImFontAtlas_GetGlyphRangesJapanese(ptr)!!.toUTF16String()

  actual fun getGlyphRangesKorean(): String =
      ImFontAtlas_GetGlyphRangesKorean(ptr)!!.toUTF16String()

  actual fun getGlyphRangesThai(): String = ImFontAtlas_GetGlyphRangesThai(ptr)!!.toUTF16String()

  actual fun getGlyphRangesVietnamese(): String =
      ImFontAtlas_GetGlyphRangesVietnamese(ptr)!!.toUTF16String()

  actual fun isBuilt(): Boolean = ImFontAtlas_IsBuilt(ptr)

  actual fun setTexID(id: ImTextureID) {
    ImFontAtlas_SetTexID(ptr, id.value)
  }

  actual fun destroy() {
    ImFontAtlas_destroy(ptr)
  }
}
