package com.imgui

import kotlin.UInt

expect class ImDrawCmd {
  val clipRect: Vec4

  val textureId: ImTextureID?

  val vtxOffset: UInt

  val idxOffset: UInt

  val elemCount: UInt

  constructor()

  fun destroy()
}
