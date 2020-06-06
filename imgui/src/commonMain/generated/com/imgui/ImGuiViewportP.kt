package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short

expect class ImGuiViewportP {
  val idx: Int

  val lastFrameActive: Int

  val lastFrontMostStampCount: Int

  val lastNameHash: ImGuiID

  val lastPos: Vec2

  val alpha: Float

  val lastAlpha: Float

  val platformMonitor: Short

  val platformWindowCreated: Boolean

  val window: ImGuiWindow?

  val lastPlatformPos: Vec2

  val lastPlatformSize: Vec2

  val lastRendererSize: Vec2

  val currWorkOffsetMin: Vec2

  val currWorkOffsetMax: Vec2

  constructor()

  fun clearRequestFlags()

  fun destroy()
}
