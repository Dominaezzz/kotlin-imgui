package com.imgui

import cimgui.internal.CImGui.ImGuiStoragePair_ImGuiStoragePairFloat
import cimgui.internal.CImGui.ImGuiStoragePair_ImGuiStoragePairInt
import cimgui.internal.CImGui.ImGuiStoragePair_destroy
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiStoragePair(
  val ptr: cimgui.internal.ImGuiStoragePair
) {
  actual val key: ImGuiID
    get() = ptr.key.let(::ImGuiID)

  actual constructor(key: ImGuiID, valI: Int) : this(ImGuiStoragePair_ImGuiStoragePairInt(key.value,
      valI)!!)

  actual constructor(key: ImGuiID, valF: Float) :
      this(ImGuiStoragePair_ImGuiStoragePairFloat(key.value, valF)!!)

  actual fun destroy() {
    ImGuiStoragePair_destroy(ptr)
  }
}
