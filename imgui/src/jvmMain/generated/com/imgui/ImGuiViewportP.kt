package com.imgui

import cimgui.internal.CImGui.ImGuiViewportP_destroy
import cimgui.internal.CImGui.intArray_getitem
import cimgui.internal.CImGui.pImDrawListArray_getitem
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiViewportP(
  val ptr: cimgui.internal.ImGuiViewportP
) {
  actual val idx: Int
    get() = ptr.idx

  actual val lastFrameActive: Int
    get() = ptr.lastFrameActive

  actual val lastFrontMostStampCount: Int
    get() = ptr.lastFrontMostStampCount

  actual val lastNameHash: ImGuiID
    get() = ptr.lastNameHash.let(::ImGuiID)

  actual val lastPos: Vec2
    get() = ptr.lastPos.fromCValue()

  actual val alpha: Float
    get() = ptr.alpha

  actual val lastAlpha: Float
    get() = ptr.lastAlpha

  actual val platformMonitor: Short
    get() = ptr.platformMonitor

  actual val platformWindowCreated: Boolean
    get() = ptr.platformWindowCreated

  actual val window: ImGuiWindow?
    get() = ptr.window?.let(::ImGuiWindow)

  actual val lastPlatformPos: Vec2
    get() = ptr.lastPlatformPos.fromCValue()

  actual val lastPlatformSize: Vec2
    get() = ptr.lastPlatformSize.fromCValue()

  actual val lastRendererSize: Vec2
    get() = ptr.lastRendererSize.fromCValue()

  actual val currWorkOffsetMin: Vec2
    get() = ptr.currWorkOffsetMin.fromCValue()

  actual val currWorkOffsetMax: Vec2
    get() = ptr.currWorkOffsetMax.fromCValue()

  actual fun lastFrameDrawLists(index: Int): Int {
    require(index in 0..2)
    return intArray_getitem(ptr.lastFrameDrawLists, index)
  }

  actual fun drawLists(index: Int): ImDrawList? {
    require(index in 0..2)
    return pImDrawListArray_getitem(ptr.drawLists, index)?.let(::ImDrawList)
  }

  actual fun destroy() {
    ImGuiViewportP_destroy(ptr)
  }
}
