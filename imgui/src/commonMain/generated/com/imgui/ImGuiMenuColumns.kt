package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int

expect class ImGuiMenuColumns {
  val spacing: Float

  val width: Float

  val nextWidth: Float

  constructor()

  fun calcExtraSpace(availW: Float): Float

  fun declColumns(
    w0: Float,
    w1: Float,
    w2: Float
  ): Float

  fun update(
    count: Int,
    spacing: Float,
    clear: Boolean
  )

  fun destroy()
}
