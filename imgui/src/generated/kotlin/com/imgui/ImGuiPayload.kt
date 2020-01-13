package com.imgui

import cimgui.internal.ImGuiPayload_Clear
import cimgui.internal.ImGuiPayload_ImGuiPayload
import cimgui.internal.ImGuiPayload_IsDataType
import cimgui.internal.ImGuiPayload_IsDelivery
import cimgui.internal.ImGuiPayload_IsPreview
import cimgui.internal.ImGuiPayload_destroy
import kotlin.Boolean
import kotlin.Int
import kotlin.String
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

  constructor() : this(ImGuiPayload_ImGuiPayload()!!)

  fun clear() {
    ImGuiPayload_Clear(ptr)
  }

  fun isDataType(type: String): Boolean = ImGuiPayload_IsDataType(ptr, type)

  fun isDelivery(): Boolean = ImGuiPayload_IsDelivery(ptr)

  fun isPreview(): Boolean = ImGuiPayload_IsPreview(ptr)

  fun destroy() {
    ImGuiPayload_destroy(ptr)
  }
}
