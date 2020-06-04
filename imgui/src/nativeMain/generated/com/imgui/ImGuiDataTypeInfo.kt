package com.imgui

import kotlin.String
import kotlin.Suppress
import kotlin.ULong
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.convert
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiDataTypeInfo(
  val ptr: CPointer<cimgui.internal.ImGuiDataTypeInfo>
) {
  actual val size: ULong
    get() = ptr.pointed.Size.convert()

  actual val printFmt: String
    get() = ptr.pointed.PrintFmt!!.toKString()

  actual val scanFmt: String
    get() = ptr.pointed.ScanFmt!!.toKString()
}
