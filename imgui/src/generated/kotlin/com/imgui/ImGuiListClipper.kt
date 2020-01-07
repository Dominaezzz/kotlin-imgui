package com.imgui

import kotlin.Float
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiListClipper(
  val ptr: CPointer<cimgui.internal.ImGuiListClipper>
) {
  val startPosY: Float
    get() = ptr.pointed.StartPosY

  val itemsHeight: Float
    get() = ptr.pointed.ItemsHeight

  val itemsCount: Int
    get() = ptr.pointed.ItemsCount

  val stepNo: Int
    get() = ptr.pointed.StepNo

  val displayStart: Int
    get() = ptr.pointed.DisplayStart

  val displayEnd: Int
    get() = ptr.pointed.DisplayEnd
}
