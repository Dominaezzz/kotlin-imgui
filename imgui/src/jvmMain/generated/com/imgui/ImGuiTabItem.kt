package com.imgui

import cimgui.internal.CImGui.ImGuiTabItem_ImGuiTabItem
import cimgui.internal.CImGui.ImGuiTabItem_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTabItem(
  val ptr: cimgui.internal.ImGuiTabItem
) {
  actual val id: ImGuiID
    get() = ptr.id.let(::ImGuiID)

  actual val flags: Flag<ImGuiTabItemFlags>
    get() = ptr.flags.let { ImGuiTabItemFlags.fromMultiple(it) }

  actual val window: ImGuiWindow?
    get() = ptr.window?.let(::ImGuiWindow)

  actual val lastFrameVisible: Int
    get() = ptr.lastFrameVisible

  actual val lastFrameSelected: Int
    get() = ptr.lastFrameSelected

  actual val nameOffset: Int
    get() = ptr.nameOffset

  actual val offset: Float
    get() = ptr.offset

  actual val width: Float
    get() = ptr.width

  actual val contentWidth: Float
    get() = ptr.contentWidth

  actual constructor() : this(ImGuiTabItem_ImGuiTabItem()!!)

  actual fun destroy() {
    ImGuiTabItem_destroy(ptr)
  }
}
