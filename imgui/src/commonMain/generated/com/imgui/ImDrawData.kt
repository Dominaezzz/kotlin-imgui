package com.imgui

import kotlin.Boolean
import kotlin.Int

expect class ImDrawData {
  val valid: Boolean

  val cmdListsCount: Int

  val totalIdxCount: Int

  val totalVtxCount: Int

  val displayPos: Vec2

  val displaySize: Vec2

  val framebufferScale: Vec2

  constructor()

  fun clear()

  fun deIndexAllBuffers()

  fun scaleClipRects(fbScale: Vec2)

  fun destroy()
}
