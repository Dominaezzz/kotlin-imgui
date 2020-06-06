package com.imgui

import cimgui.internal.ImGuiWindowClass_ImGuiWindowClass
import cimgui.internal.ImGuiWindowClass_destroy
import kotlin.Boolean
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiWindowClass(
  val ptr: CPointer<cimgui.internal.ImGuiWindowClass>
) {
  actual val classId: ImGuiID
    get() = ptr.pointed.ClassId.let(::ImGuiID)

  actual val parentViewportId: ImGuiID
    get() = ptr.pointed.ParentViewportId.let(::ImGuiID)

  actual val viewportFlagsOverrideSet: Flag<ImGuiViewportFlags>
    get() = ptr.pointed.ViewportFlagsOverrideSet.let { ImGuiViewportFlags.fromMultiple(it) }

  actual val viewportFlagsOverrideClear: Flag<ImGuiViewportFlags>
    get() = ptr.pointed.ViewportFlagsOverrideClear.let { ImGuiViewportFlags.fromMultiple(it) }

  actual val dockNodeFlagsOverrideSet: Flag<ImGuiDockNodeFlags>
    get() = ptr.pointed.DockNodeFlagsOverrideSet.let { ImGuiDockNodeFlags.fromMultiple(it) }

  actual val dockNodeFlagsOverrideClear: Flag<ImGuiDockNodeFlags>
    get() = ptr.pointed.DockNodeFlagsOverrideClear.let { ImGuiDockNodeFlags.fromMultiple(it) }

  actual val dockingAlwaysTabBar: Boolean
    get() = ptr.pointed.DockingAlwaysTabBar

  actual val dockingAllowUnclassed: Boolean
    get() = ptr.pointed.DockingAllowUnclassed

  actual constructor() : this(ImGuiWindowClass_ImGuiWindowClass()!!)

  actual fun destroy() {
    ImGuiWindowClass_destroy(ptr)
  }
}
