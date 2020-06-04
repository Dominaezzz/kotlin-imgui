package com.imgui

import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiColorMod(
  val ptr: cimgui.internal.ImGuiColorMod
) {
  actual val col: ImGuiCol
    get() = ptr.col.let { ImGuiCol.from(it) }

  actual val backupValue: Vec4
    get() = ptr.backupValue.fromCValue()
}
