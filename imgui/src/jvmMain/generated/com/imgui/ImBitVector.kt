package com.imgui

import cimgui.internal.CImGui.ImBitVector_Clear
import cimgui.internal.CImGui.ImBitVector_ClearBit
import cimgui.internal.CImGui.ImBitVector_Create
import cimgui.internal.CImGui.ImBitVector_SetBit
import cimgui.internal.CImGui.ImBitVector_TestBit
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImBitVector(
  val ptr: cimgui.internal.ImBitVector
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
