package com.imgui

import kotlin.Boolean
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiPayload(
  val ptr: CPointer<cimgui.internal.ImGuiPayload>
) {
  val dataSize: Int
    get() = ptr.pointed.DataSize

  val sourceId: ImGuiID
    get() = ptr.pointed.SourceId.let(::ImGuiID)

  val sourceParentId: ImGuiID
    get() = ptr.pointed.SourceParentId.let(::ImGuiID)

  val dataFrameCount: Int
    get() = ptr.pointed.DataFrameCount

  val preview: Boolean
    get() = ptr.pointed.Preview

  val delivery: Boolean
    get() = ptr.pointed.Delivery
}
