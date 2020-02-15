package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int

expect class ImGuiListClipper {
  val displayStart: Int

  val displayEnd: Int

  val itemsCount: Int

  val stepNo: Int

  val itemsHeight: Float

  val startPosY: Float

  constructor(itemsCount: Int = -1, itemsHeight: Float = -1.0f)

  fun begin(itemsCount: Int, itemsHeight: Float = -1.0f)

  fun end()

  fun step(): Boolean

  fun destroy()
}
