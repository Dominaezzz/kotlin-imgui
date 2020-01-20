package com.imgui

import kotlin.UInt

expect class ImDrawCmd {
  val elemCount: UInt

  val clipRect: Vec4

  val textureId: ImTextureID?

  val vtxOffset: UInt

  val idxOffset: UInt

  constructor()

  fun destroy()
}
