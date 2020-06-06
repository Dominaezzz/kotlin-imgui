package com.imgui

import cimgui.internal.CImGui.ImGuiWindowClass_ImGuiWindowClass
import cimgui.internal.CImGui.ImGuiWindowClass_destroy
import kotlin.Boolean
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiWindowClass(
  val ptr: cimgui.internal.ImGuiWindowClass
) {
  actual val classId: ImGuiID
    get() = ptr.classId.let(::ImGuiID)

  actual val parentViewportId: ImGuiID
    get() = ptr.parentViewportId.let(::ImGuiID)

  actual val viewportFlagsOverrideSet: Flag<ImGuiViewportFlags>
    get() = ptr.viewportFlagsOverrideSet.let { ImGuiViewportFlags.fromMultiple(it) }

  actual val viewportFlagsOverrideClear: Flag<ImGuiViewportFlags>
    get() = ptr.viewportFlagsOverrideClear.let { ImGuiViewportFlags.fromMultiple(it) }

  actual val dockNodeFlagsOverrideSet: Flag<ImGuiDockNodeFlags>
    get() = ptr.dockNodeFlagsOverrideSet.let { ImGuiDockNodeFlags.fromMultiple(it) }

  actual val dockNodeFlagsOverrideClear: Flag<ImGuiDockNodeFlags>
    get() = ptr.dockNodeFlagsOverrideClear.let { ImGuiDockNodeFlags.fromMultiple(it) }

  actual val dockingAlwaysTabBar: Boolean
    get() = ptr.dockingAlwaysTabBar

  actual val dockingAllowUnclassed: Boolean
    get() = ptr.dockingAllowUnclassed

  actual constructor() : this(ImGuiWindowClass_ImGuiWindowClass()!!)

  actual fun destroy() {
    ImGuiWindowClass_destroy(ptr)
  }
}
