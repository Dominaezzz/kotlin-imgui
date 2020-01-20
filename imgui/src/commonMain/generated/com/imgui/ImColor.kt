package com.imgui

import kotlin.Float
import kotlin.Int
import kotlin.UInt

expect class ImColor {
  val value: Vec4

  constructor()

  constructor(
    r: Int,
    g: Int,
    b: Int,
    a: Int = 255
  )

  constructor(rgba: UInt)

  constructor(
    r: Float,
    g: Float,
    b: Float,
    a: Float = 1.0f
  )

  constructor(col: Vec4)

  fun setHSV(
    h: Float,
    s: Float,
    v: Float,
    a: Float = 1.0f
  )

  fun destroy()
}
