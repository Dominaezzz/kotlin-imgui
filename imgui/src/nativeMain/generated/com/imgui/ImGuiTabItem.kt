package com.imgui

import cimgui.internal.ImGuiTabItem_ImGuiTabItem
import cimgui.internal.ImGuiTabItem_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTabItem(
  val ptr: CPointer<cimgui.internal.ImGuiTabItem>
) {
  actual val id: ImGuiID
    get() = ptr.pointed.ID.let(::ImGuiID)

  actual val flags: Flag<ImGuiTabItemFlags>
    get() = ptr.pointed.Flags.let { ImGuiTabItemFlags.fromMultiple(it) }

  actual val lastFrameVisible: Int
    get() = ptr.pointed.LastFrameVisible

  actual val lastFrameSelected: Int
    get() = ptr.pointed.LastFrameSelected

  actual val nameOffset: Int
    get() = ptr.pointed.NameOffset

  actual val offset: Float
    get() = ptr.pointed.Offset

  actual val width: Float
    get() = ptr.pointed.Width

  actual val contentWidth: Float
    get() = ptr.pointed.ContentWidth

  actual constructor() : this(ImGuiTabItem_ImGuiTabItem()!!)

  actual fun destroy() {
    ImGuiTabItem_destroy(ptr)
  }
}
