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

  val texDesiredWidth: Int
    get() = ptr.pointed.TexDesiredWidth

  val texGlyphPadding: Int
    get() = ptr.pointed.TexGlyphPadding

  val texWidth: Int
    get() = ptr.pointed.TexWidth

  val texHeight: Int
    get() = ptr.pointed.TexHeight
}
