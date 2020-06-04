package com.imgui

import kotlin.Boolean
import kotlin.Float

expect class ImGuiNextWindowData {
  val flags: Flag<ImGuiNextWindowDataFlags>

  val posCond: Flag<ImGuiCond>

  val sizeCond: Flag<ImGuiCond>

  val collapsedCond: Flag<ImGuiCond>

  val posVal: Vec2

  val posPivotVal: Vec2

  val sizeVal: Vec2

  val contentSizeVal: Vec2

  val collapsedVal: Boolean

  val bgAlphaVal: Float

  val menuBarOffsetMinVal: Vec2

  constructor()

  fun clearFlags()

  fun destroy()
}
