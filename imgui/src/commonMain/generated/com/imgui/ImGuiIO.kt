package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt

expect class ImGuiIO {
  val configFlags: Flag<ImGuiConfigFlags>

  var backendFlags: Flag<ImGuiBackendFlags>

  var displaySize: Vec2

  var deltaTime: Float

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

  var displayFramebufferScale: Vec2

  val mouseDrawCursor: Boolean

  val configMacOSXBehaviors: Boolean

  val configInputTextCursorBlink: Boolean

  val configWindowsResizeFromEdges: Boolean

  val configWindowsMoveFromTitleBarOnly: Boolean

  val configWindowsMemoryCompactTimer: Float

  val backendPlatformName: String

  val backendRendererName: String

  var mousePos: Vec2

  var mouseWheel: Float

  var mouseWheelH: Float

  var keyCtrl: Boolean

  var keyShift: Boolean

  var keyAlt: Boolean

  var keySuper: Boolean

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
