package com.imgui

import cimgui.internal.CImGui.ImFontConfig_ImFontConfig
import cimgui.internal.CImGui.ImFontConfig_destroy
import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontConfig(
  val ptr: cimgui.internal.ImFontConfig
) {
  actual val fontDataSize: Int
    get() = ptr.fontDataSize

  actual val fontDataOwnedByAtlas: Boolean
    get() = ptr.fontDataOwnedByAtlas

  actual val fontNo: Int
    get() = ptr.fontNo

  actual val sizePixels: Float
    get() = ptr.sizePixels

  actual val oversampleH: Int
    get() = ptr.oversampleH

  actual val oversampleV: Int
    get() = ptr.oversampleV

  actual val pixelSnapH: Boolean
    get() = ptr.pixelSnapH

  actual val glyphExtraSpacing: Vec2
    get() = ptr.glyphExtraSpacing.fromCValue()

  actual val glyphOffset: Vec2
    get() = ptr.glyphOffset.fromCValue()

  actual val glyphRanges: String?
    get() = ptr.glyphRanges?.toUTF16String()

  actual val glyphMinAdvanceX: Float
    get() = ptr.glyphMinAdvanceX

  actual val glyphMaxAdvanceX: Float
    get() = ptr.glyphMaxAdvanceX

  actual val mergeMode: Boolean
    get() = ptr.mergeMode

  actual val rasterizerFlags: UInt
    get() = ptr.rasterizerFlags.toUInt()

  actual val rasterizerMultiply: Float
    get() = ptr.rasterizerMultiply

  actual val ellipsisChar: Char
    get() = ptr.ellipsisChar.toShort().toChar()

  actual val dstFont: ImFont?
    get() = ptr.dstFont?.let(::ImFont)

  actual constructor() : this(ImFontConfig_ImFontConfig()!!)

  actual fun destroy() {
    ImFontConfig_destroy(ptr)
  }
}
