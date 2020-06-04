package com.imgui

import kotlin.Boolean
import kotlin.Int

expect class ImBitVector {
  fun clear()

  fun clearBit(n: Int)

  fun create(sz: Int)

  fun setBit(n: Int)

  fun testBit(n: Int): Boolean
}
