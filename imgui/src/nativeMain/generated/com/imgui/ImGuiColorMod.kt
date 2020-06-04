package com.imgui

import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiColorMod(
  val ptr: CPointer<cimgui.internal.ImGuiColorMod>
) {
  actual val col: ImGuiCol
    get() = ptr.pointed.Col.let { ImGuiCol.from(it) }

  actual val backupValue: Vec4
    get() = ptr.pointed.BackupValue.fromCValue()
}
