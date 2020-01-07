package com.imgui

import kotlin.Boolean
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImDrawData(
  val ptr: CPointer<cimgui.internal.ImDrawData>
) {
  val valid: Boolean
    get() = ptr.pointed.Valid

  val cmdListsCount: Int
    get() = ptr.pointed.CmdListsCount

  val totalIdxCount: Int
    get() = ptr.pointed.TotalIdxCount

  val totalVtxCount: Int
    get() = ptr.pointed.TotalVtxCount
}
