package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt

expect class ImGuiIO {
  val configFlags: Flag<ImGuiConfigFlags>

  val backendFlags: Flag<ImGuiBackendFlags>

  val displaySize: Vec2

  val deltaTime: Float

  val iniSavingRate: Float

  val iniFilename: String

  val logFilename: String

  val mouseDoubleClickTime: Float

  val mouseDoubleClickMaxDist: Float

  val mouseDragThreshold: Float

  val keyRepeatDelay: Float

  val keyRepeatRate: Float

  val fonts: ImFontAtlas?

  val fontGlobalScale: Float

  val fontAllowUserScaling: Boolean

  val fontDefault: ImFont?

  val displayFramebufferScale: Vec2

  val configDockingNoSplit: Boolean

  val configDockingWithShift: Boolean

  val configDockingAlwaysTabBar: Boolean

  val configDockingTransparentPayload: Boolean

  val configViewportsNoAutoMerge: Boolean

  val configViewportsNoTaskBarIcon: Boolean

  val configViewportsNoDecoration: Boolean

  val configViewportsNoDefaultParent: Boolean

  val mouseDrawCursor: Boolean

  val configMacOSXBehaviors: Boolean

  val configInputTextCursorBlink: Boolean

  val configWindowsResizeFromEdges: Boolean

  val configWindowsMoveFromTitleBarOnly: Boolean

  val configWindowsMemoryCompactTimer: Float

  val backendPlatformName: String

  val backendRendererName: String

  val mousePos: Vec2

  val mouseWheel: Float

  val mouseWheelH: Float

  val mouseHoveredViewport: ImGuiID

  val keyCtrl: Boolean

  val keyShift: Boolean

  val keyAlt: Boolean

  val keySuper: Boolean

  val wantCaptureMouse: Boolean

  val wantCaptureKeyboard: Boolean

  val wantTextInput: Boolean

  val wantSetMousePos: Boolean

  val wantSaveIniSettings: Boolean

  val navActive: Boolean

  val navVisible: Boolean

  val framerate: Float

  val metricsRenderVertices: Int

  val metricsRenderIndices: Int

  val metricsRenderWindows: Int

  val metricsActiveWindows: Int

  val metricsActiveAllocations: Int

  val mouseDelta: Vec2

  val keyMods: Flag<ImGuiKeyModFlags>

  val mousePosPrev: Vec2

  constructor()

  fun addInputCharacter(c: UInt)

  fun addInputCharactersUTF8(str: String)

  fun clearInputCharacters()

  fun destroy()
}
