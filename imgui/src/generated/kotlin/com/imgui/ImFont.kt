package com.imgui

import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImFont(
  val ptr: CPointer<cimgui.internal.ImFont>
) {
  val fallbackAdvanceX: Float
    get() = ptr.pointed.FallbackAdvanceX

  val fontSize: Float
    get() = ptr.pointed.FontSize

  val configDataCount: Short
    get() = ptr.pointed.ConfigDataCount

  val fallbackChar: Char
    get() = ptr.pointed.FallbackChar.toShort().toChar()

  val ellipsisChar: Char
    get() = ptr.pointed.EllipsisChar.toShort().toChar()

  val scale: Float
    get() = ptr.pointed.Scale

  val ascent: Float
    get() = ptr.pointed.Ascent

  val descent: Float
    get() = ptr.pointed.Descent

  val metricsTotalSurface: Int
    get() = ptr.pointed.MetricsTotalSurface

  val dirtyLookupTables: Boolean
    get() = ptr.pointed.DirtyLookupTables
}
