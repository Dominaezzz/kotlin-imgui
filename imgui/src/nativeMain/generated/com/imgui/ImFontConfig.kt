package com.imgui

import cimgui.internal.ImFontConfig_ImFontConfig
import cimgui.internal.ImFontConfig_destroy
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

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontConfig(
  val ptr: CPointer<cimgui.internal.ImFontConfig>
) {
  actual val fontDataSize: Int
    get() = ptr.pointed.FontDataSize

  actual val fontDataOwnedByAtlas: Boolean
    get() = ptr.pointed.FontDataOwnedByAtlas

  actual val fontNo: Int
    get() = ptr.pointed.FontNo

  actual val sizePixels: Float
    get() = ptr.pointed.SizePixels

  actual val oversampleH: Int
    get() = ptr.pointed.OversampleH

  actual val oversampleV: Int
    get() = ptr.pointed.OversampleV

  actual val pixelSnapH: Boolean
    get() = ptr.pointed.PixelSnapH

  actual val glyphExtraSpacing: Vec2
    get() = ptr.pointed.GlyphExtraSpacing.fromCValue()

  actual val glyphOffset: Vec2
    get() = ptr.pointed.GlyphOffset.fromCValue()

  actual val glyphRanges: String?
    get() = ptr.pointed.GlyphRanges?.toKString()

  actual val glyphMinAdvanceX: Float
    get() = ptr.pointed.GlyphMinAdvanceX

  actual val glyphMaxAdvanceX: Float
    get() = ptr.pointed.GlyphMaxAdvanceX

  actual val mergeMode: Boolean
    get() = ptr.pointed.MergeMode

  actual val rasterizerFlags: UInt
    get() = ptr.pointed.RasterizerFlags.toUInt()

  actual val rasterizerMultiply: Float
    get() = ptr.pointed.RasterizerMultiply

  actual val ellipsisChar: Char
    get() = ptr.pointed.EllipsisChar.toShort().toChar()

  actual val dstFont: ImFont?
    get() = ptr.pointed.DstFont?.let(::ImFont)

  actual constructor() : this(ImFontConfig_ImFontConfig()!!)

  actual fun destroy() {
    ImFontConfig_destroy(ptr)
  }
}
