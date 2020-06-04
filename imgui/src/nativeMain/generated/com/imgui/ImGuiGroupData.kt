package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiGroupData(
  val ptr: CPointer<cimgui.internal.ImGuiGroupData>
) {
  actual val backupCursorPos: Vec2
    get() = ptr.pointed.BackupCursorPos.fromCValue()

  actual val backupCursorMaxPos: Vec2
    get() = ptr.pointed.BackupCursorMaxPos.fromCValue()

  actual val backupCurrLineSize: Vec2
    get() = ptr.pointed.BackupCurrLineSize.fromCValue()

  actual val backupCurrLineTextBaseOffset: Float
    get() = ptr.pointed.BackupCurrLineTextBaseOffset

  actual val backupActiveIdIsAlive: ImGuiID
    get() = ptr.pointed.BackupActiveIdIsAlive.let(::ImGuiID)

  actual val backupActiveIdPreviousFrameIsAlive: Boolean
    get() = ptr.pointed.BackupActiveIdPreviousFrameIsAlive

  actual val emitItem: Boolean
    get() = ptr.pointed.EmitItem
}
