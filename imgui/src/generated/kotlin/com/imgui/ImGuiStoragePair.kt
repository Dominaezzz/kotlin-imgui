package com.imgui

import cimgui.internal.ImGuiStoragePair_ImGuiStoragePairFloat
import cimgui.internal.ImGuiStoragePair_ImGuiStoragePairInt
import cimgui.internal.ImGuiStoragePair_destroy
import kotlin.Float
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiStoragePair(
  val ptr: CPointer<cimgui.internal.ImGuiStoragePair>
) {
  val key: ImGuiID
    get() = ptr.pointed.key.let(::ImGuiID)

  constructor(key: ImGuiID, valI: Int) : this(ImGuiStoragePair_ImGuiStoragePairInt(key.value,
      valI)!!)

  constructor(key: ImGuiID, valF: Float) : this(ImGuiStoragePair_ImGuiStoragePairFloat(key.value,
      valF)!!)

  fun destroy() {
    ImGuiStoragePair_destroy(ptr)
  }
}
