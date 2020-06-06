package com.imgui

import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.String

expect class ImFontAtlas {
  val locked: Boolean

  val flags: Flag<ImFontAtlasFlags>

  val texID: ImTextureID?

  val texDesiredWidth: Int

  val texGlyphPadding: Int

  val texWidth: Int

  val texHeight: Int

  val texUvScale: Vec2

  val texUvWhitePixel: Vec2

  constructor()

  fun addCustomRectFontGlyph(
    font: ImFont,
    id: Char,
    width: Int,
    height: Int,
    advanceX: Float,
    offset: Vec2 = Vec2.Zero
  ): Int

  fun addCustomRectRegular(width: Int, height: Int): Int

  fun addFont(fontCfg: ImFontConfig): ImFont

  fun addFontDefault(fontCfg: ImFontConfig? = null): ImFont

  fun addFontFromFileTTF(
    filename: String,
    sizePixels: Float,
    fontCfg: ImFontConfig? = null,
    glyphRanges: String? = null
  ): ImFont

  fun addFontFromMemoryCompressedBase85TTF(
    compressedFontDataBase85: String,
    sizePixels: Float,
    fontCfg: ImFontConfig? = null,
    glyphRanges: String? = null
  ): ImFont

  fun build(): Boolean

  fun calcCustomRectUV(
    rect: ImFontAtlasCustomRect,
    outUvMin: ImVec2,
    outUvMax: ImVec2
  )

  fun clear()

  fun clearFonts()

  fun clearInputData()

  fun clearTexData()

  fun getCustomRectByIndex(index: Int): ImFontAtlasCustomRect

  fun getGlyphRangesChineseFull(): String

  fun getGlyphRangesChineseSimplifiedCommon(): String

  fun getGlyphRangesCyrillic(): String

  fun getGlyphRangesDefault(): String

  fun getGlyphRangesJapanese(): String

  fun getGlyphRangesKorean(): String

  fun getGlyphRangesThai(): String

  fun getGlyphRangesVietnamese(): String

  fun isBuilt(): Boolean

  fun setTexID(id: ImTextureID)

  fun destroy()
}
