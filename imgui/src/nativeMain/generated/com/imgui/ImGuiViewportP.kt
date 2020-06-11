package com.imgui

import cimgui.internal.ImGuiViewportP_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiViewportP(
  val ptr: CPointer<cimgui.internal.ImGuiViewportP>
) {
  actual val idx: Int
    get() = ptr.pointed.Idx

  actual val lastFrameActive: Int
    get() = ptr.pointed.LastFrameActive

  actual val lastFrontMostStampCount: Int
    get() = ptr.pointed.LastFrontMostStampCount

  actual val lastNameHash: ImGuiID
    get() = ptr.pointed.LastNameHash.let(::ImGuiID)

  actual val lastPos: Vec2
    get() = ptr.pointed.LastPos.fromCValue()

  actual val alpha: Float
    get() = ptr.pointed.Alpha

  actual val lastAlpha: Float
    get() = ptr.pointed.LastAlpha

  actual val platformMonitor: Short
    get() = ptr.pointed.PlatformMonitor

  actual val platformWindowCreated: Boolean
    get() = ptr.pointed.PlatformWindowCreated

  actual val window: ImGuiWindow?
    get() = ptr.pointed.Window?.let(::ImGuiWindow)

  actual val lastPlatformPos: Vec2
    get() = ptr.pointed.LastPlatformPos.fromCValue()

  actual val lastPlatformSize: Vec2
    get() = ptr.pointed.LastPlatformSize.fromCValue()

  actual val lastRendererSize: Vec2
    get() = ptr.pointed.LastRendererSize.fromCValue()

  actual val currWorkOffsetMin: Vec2
    get() = ptr.pointed.CurrWorkOffsetMin.fromCValue()

  actual val currWorkOffsetMax: Vec2
    get() = ptr.pointed.CurrWorkOffsetMax.fromCValue()

  actual fun destroy() {
    ImGuiViewportP_destroy(ptr)
  }
}
