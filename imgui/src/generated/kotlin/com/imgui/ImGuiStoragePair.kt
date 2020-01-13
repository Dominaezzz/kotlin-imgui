package com.imgui

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiStoragePair(
  val ptr: CPointer<cimgui.internal.ImGuiStoragePair>
) {
  val key: ImGuiID
    get() = ptr.pointed.key.let(::ImGuiID)
}
