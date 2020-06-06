package com.imgui

import kotlin.Boolean
import kotlin.Float

expect class ImGuiNextWindowData {
  val flags: Flag<ImGuiNextWindowDataFlags>

  val posCond: Flag<ImGuiCond>

  val sizeCond: Flag<ImGuiCond>

  val collapsedCond: Flag<ImGuiCond>

  val dockCond: Flag<ImGuiCond>

  val posVal: Vec2

  val posPivotVal: Vec2

  val sizeVal: Vec2

  val contentSizeVal: Vec2

  val scrollVal: Vec2

  val posUndock: Boolean

  val collapsedVal: Boolean

  val bgAlphaVal: Float

  val viewportId: ImGuiID

  val dockId: ImGuiID

  val menuBarOffsetMinVal: Vec2

  constructor()

  fun clearFlags()

  fun destroy()
}
