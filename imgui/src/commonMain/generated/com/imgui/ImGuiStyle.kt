package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int

expect class ImGuiStyle {
  val alpha: Float

  val windowPadding: Vec2

  val windowRounding: Float

  val windowBorderSize: Float

  val windowMinSize: Vec2

  val windowTitleAlign: Vec2

  val windowMenuButtonPosition: ImGuiDir

  val childRounding: Float

  val childBorderSize: Float

  val popupRounding: Float

  val popupBorderSize: Float

  val framePadding: Vec2

  val frameRounding: Float

  val frameBorderSize: Float

  val itemSpacing: Vec2

  val itemInnerSpacing: Vec2

  val touchExtraPadding: Vec2

  val indentSpacing: Float

  val columnsMinSpacing: Float

  val scrollbarSize: Float

  val scrollbarRounding: Float

  val grabMinSize: Float

  val grabRounding: Float

  val tabRounding: Float

  val tabBorderSize: Float

  val tabMinWidthForUnselectedCloseButton: Float

  val colorButtonPosition: ImGuiDir

  val buttonTextAlign: Vec2

  val selectableTextAlign: Vec2

  val displayWindowPadding: Vec2

  val displaySafeAreaPadding: Vec2

  val mouseCursorScale: Float

  val antiAliasedLines: Boolean

  val antiAliasedFill: Boolean

  val curveTessellationTol: Float

  val circleSegmentMaxError: Float

  constructor()

  fun colors(index: Int): Vec4

  fun scaleAllSizes(scaleFactor: Float)

  fun destroy()
}
