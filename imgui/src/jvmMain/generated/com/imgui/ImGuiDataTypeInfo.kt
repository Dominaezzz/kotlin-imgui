package com.imgui

import kotlin.String
import kotlin.Suppress
import kotlin.ULong

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiDataTypeInfo(
  val ptr: cimgui.internal.ImGuiDataTypeInfo
) {
  actual val size: ULong
    get() = ptr.size.toULong()

  actual val printFmt: String
    get() = ptr.printFmt!!

  actual val scanFmt: String
    get() = ptr.scanFmt!!
}
