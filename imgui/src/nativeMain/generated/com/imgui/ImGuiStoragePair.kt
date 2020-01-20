package com.imgui

import cimgui.internal.ImGuiStoragePair_ImGuiStoragePairFloat
import cimgui.internal.ImGuiStoragePair_ImGuiStoragePairInt
import cimgui.internal.ImGuiStoragePair_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiStoragePair(
  val ptr: CPointer<cimgui.internal.ImGuiStoragePair>
) {
  actual val key: ImGuiID
    get() = ptr.pointed.key.let(::ImGuiID)

  actual constructor(key: ImGuiID, valI: Int) : this(ImGuiStoragePair_ImGuiStoragePairInt(key.value,
      valI)!!)

  actual constructor(key: ImGuiID, valF: Float) :
      this(ImGuiStoragePair_ImGuiStoragePairFloat(key.value, valF)!!)

  actual fun destroy() {
    ImGuiStoragePair_destroy(ptr)
  }
}
