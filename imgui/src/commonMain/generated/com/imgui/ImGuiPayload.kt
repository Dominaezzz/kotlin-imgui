package com.imgui

import kotlin.Boolean
import kotlin.Int
import kotlin.String

expect class ImGuiPayload {
  val dataSize: Int

  val sourceId: ImGuiID

  val sourceParentId: ImGuiID

  val dataFrameCount: Int

  val preview: Boolean

  val delivery: Boolean

  constructor()

  fun clear()

  fun isDataType(type: String): Boolean

  fun isDelivery(): Boolean

  fun isPreview(): Boolean

  fun destroy()
}
