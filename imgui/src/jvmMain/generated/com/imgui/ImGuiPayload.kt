package com.imgui

import cimgui.internal.CImGui.ImGuiPayload_Clear
import cimgui.internal.CImGui.ImGuiPayload_ImGuiPayload
import cimgui.internal.CImGui.ImGuiPayload_IsDataType
import cimgui.internal.CImGui.ImGuiPayload_IsDelivery
import cimgui.internal.CImGui.ImGuiPayload_IsPreview
import cimgui.internal.CImGui.ImGuiPayload_destroy
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPayload(
  val ptr: cimgui.internal.ImGuiPayload
) {
  actual val dataSize: Int
    get() = ptr.dataSize

  actual val sourceId: ImGuiID
    get() = ptr.sourceId.let(::ImGuiID)

  actual val sourceParentId: ImGuiID
    get() = ptr.sourceParentId.let(::ImGuiID)

  actual val dataFrameCount: Int
    get() = ptr.dataFrameCount

  actual val preview: Boolean
    get() = ptr.preview

  actual val delivery: Boolean
    get() = ptr.delivery

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
