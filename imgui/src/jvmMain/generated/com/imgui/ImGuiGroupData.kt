package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiGroupData(
  val ptr: cimgui.internal.ImGuiGroupData
) {
  actual val backupCursorPos: Vec2
    get() = ptr.backupCursorPos.fromCValue()

  actual val backupCursorMaxPos: Vec2
    get() = ptr.backupCursorMaxPos.fromCValue()

  actual val backupCurrLineSize: Vec2
    get() = ptr.backupCurrLineSize.fromCValue()

  actual val backupCurrLineTextBaseOffset: Float
    get() = ptr.backupCurrLineTextBaseOffset

  actual val backupActiveIdIsAlive: ImGuiID
    get() = ptr.backupActiveIdIsAlive.let(::ImGuiID)

  actual val backupActiveIdPreviousFrameIsAlive: Boolean
    get() = ptr.backupActiveIdPreviousFrameIsAlive

  actual val emitItem: Boolean
    get() = ptr.emitItem
}
