package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int

expect class ImGuiListClipper {
  val startPosY: Float

  val itemsHeight: Float

  val itemsCount: Int

  val stepNo: Int

  val displayStart: Int

  val displayEnd: Int

  constructor(itemsCount: Int = -1, itemsHeight: Float = -1.0f)

  fun begin(itemsCount: Int, itemsHeight: Float = -1.0f)

  fun end()

  fun step(): Boolean

  fun destroy()
}
