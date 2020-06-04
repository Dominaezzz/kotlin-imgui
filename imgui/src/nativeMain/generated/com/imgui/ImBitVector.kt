package com.imgui

import cimgui.internal.ImBitVector_Clear
import cimgui.internal.ImBitVector_ClearBit
import cimgui.internal.ImBitVector_Create
import cimgui.internal.ImBitVector_SetBit
import cimgui.internal.ImBitVector_TestBit
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImBitVector(
  val ptr: CPointer<cimgui.internal.ImBitVector>
) {
  actual fun clear() {
    ImBitVector_Clear(ptr)
  }

  actual fun clearBit(n: Int) {
    ImBitVector_ClearBit(ptr, n)
  }

  actual fun create(sz: Int) {
    ImBitVector_Create(ptr, sz)
  }

  actual fun setBit(n: Int) {
    ImBitVector_SetBit(ptr, n)
  }

  actual fun testBit(n: Int): Boolean = ImBitVector_TestBit(ptr, n)
}
