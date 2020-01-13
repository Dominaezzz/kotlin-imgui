package com.imgui

import kotlin.Boolean
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImFontAtlas(
  val ptr: CPointer<cimgui.internal.ImFontAtlas>
) {
  val locked: Boolean
    get() = ptr.pointed.Locked

  val flags: Flag<ImFontAtlasFlags>
    get() = ptr.pointed.Flags.let { ImFontAtlasFlags.fromMultiple(it) }

  val texID: ImTextureID?
    get() = ptr.pointed.TexID?.let(::ImTextureID)

  val texDesiredWidth: Int
    get() = ptr.pointed.TexDesiredWidth

  val texGlyphPadding: Int
    get() = ptr.pointed.TexGlyphPadding

  val texWidth: Int
    get() = ptr.pointed.TexWidth

  val texHeight: Int
    get() = ptr.pointed.TexHeight

  val texUvScale: Vec2
    get() = ptr.pointed.TexUvScale.fromCValue()

  val texUvWhitePixel: Vec2
    get() = ptr.pointed.TexUvWhitePixel.fromCValue()
}
