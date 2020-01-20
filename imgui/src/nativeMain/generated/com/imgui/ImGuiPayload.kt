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
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPayload(
  val ptr: CPointer<cimgui.internal.ImGuiPayload>
) {
  actual val dataSize: Int
    get() = ptr.pointed.DataSize

  actual val sourceId: ImGuiID
    get() = ptr.pointed.SourceId.let(::ImGuiID)

  actual val sourceParentId: ImGuiID
    get() = ptr.pointed.SourceParentId.let(::ImGuiID)

  actual val dataFrameCount: Int
    get() = ptr.pointed.DataFrameCount

  actual val preview: Boolean
    get() = ptr.pointed.Preview

  actual val delivery: Boolean
    get() = ptr.pointed.Delivery

  actual constructor() : this(ImGuiPayload_ImGuiPayload()!!)

  actual fun clear() {
    ImGuiPayload_Clear(ptr)
  }

  actual fun isDataType(type: String): Boolean = ImGuiPayload_IsDataType(ptr, type)

  actual fun isDelivery(): Boolean = ImGuiPayload_IsDelivery(ptr)

  actual fun isPreview(): Boolean = ImGuiPayload_IsPreview(ptr)

  actual fun destroy() {
    ImGuiPayload_destroy(ptr)
  }
}
