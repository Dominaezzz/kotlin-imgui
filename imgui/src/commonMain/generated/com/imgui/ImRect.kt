package com.imgui

import kotlin.Boolean
import kotlin.Float

expect class ImRect {
  val min: Vec2

  val max: Vec2

  constructor()

  constructor(min: Vec2, max: Vec2)

  constructor(v: Vec4)

  constructor(
    x1: Float,
    y1: Float,
    x2: Float,
    y2: Float
  )

  fun add(p: Vec2)

  fun contains(p: Vec2): Boolean

  fun expand(amount: Vec2)

  fun floor()

  fun getHeight(): Float

  fun getWidth(): Float

  fun isInverted(): Boolean

  fun translate(d: Vec2)

  fun translateX(dx: Float)

  fun translateY(dy: Float)

  fun destroy()
}
