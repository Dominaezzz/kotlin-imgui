package com.imgui

import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImFontConfig(
  val ptr: CPointer<cimgui.internal.ImFontConfig>
) {
  val fontDataSize: Int
    get() = ptr.pointed.FontDataSize

  val fontDataOwnedByAtlas: Boolean
    get() = ptr.pointed.FontDataOwnedByAtlas

  val fontNo: Int
    get() = ptr.pointed.FontNo

  val sizePixels: Float
    get() = ptr.pointed.SizePixels

  val oversampleH: Int
    get() = ptr.pointed.OversampleH

  val oversampleV: Int
    get() = ptr.pointed.OversampleV

  val pixelSnapH: Boolean
    get() = ptr.pointed.PixelSnapH

  val glyphExtraSpacing: Vec2
    get() = ptr.pointed.GlyphExtraSpacing.fromCValue()

  val glyphOffset: Vec2
    get() = ptr.pointed.GlyphOffset.fromCValue()

  val glyphMinAdvanceX: Float
    get() = ptr.pointed.GlyphMinAdvanceX

  val glyphMaxAdvanceX: Float
    get() = ptr.pointed.GlyphMaxAdvanceX

  val mergeMode: Boolean
    get() = ptr.pointed.MergeMode

  val rasterizerFlags: UInt
    get() = ptr.pointed.RasterizerFlags

  val rasterizerMultiply: Float
    get() = ptr.pointed.RasterizerMultiply

  val ellipsisChar: Char
    get() = ptr.pointed.EllipsisChar.toShort().toChar()

  val dstFont: ImFont?
    get() = ptr.pointed.DstFont?.let(::ImFont)
}
