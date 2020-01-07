package com.imgui

import kotlinx.cinterop.CPointer

inline class ImFontGlyphRangesBuilder(
  val ptr: CPointer<cimgui.internal.ImFontGlyphRangesBuilder>
)
