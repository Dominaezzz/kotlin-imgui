package com.imgui

import kotlin.Boolean

expect class ImGuiWindowClass {
  val classId: ImGuiID

  val parentViewportId: ImGuiID

  val viewportFlagsOverrideSet: Flag<ImGuiViewportFlags>

  val viewportFlagsOverrideClear: Flag<ImGuiViewportFlags>

  val dockNodeFlagsOverrideSet: Flag<ImGuiDockNodeFlags>

  val dockNodeFlagsOverrideClear: Flag<ImGuiDockNodeFlags>

  val dockingAlwaysTabBar: Boolean

  val dockingAllowUnclassed: Boolean

  constructor()

  fun destroy()
}
