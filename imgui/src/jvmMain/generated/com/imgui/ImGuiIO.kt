package com.imgui

import cimgui.internal.CImGui.ImGuiIO_AddInputCharacter
import cimgui.internal.CImGui.ImGuiIO_AddInputCharactersUTF8
import cimgui.internal.CImGui.ImGuiIO_ClearInputCharacters
import cimgui.internal.CImGui.ImGuiIO_ImGuiIO
import cimgui.internal.CImGui.ImGuiIO_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiIO(
  val ptr: cimgui.internal.ImGuiIO
) {
  actual val configFlags: Flag<ImGuiConfigFlags>
    get() = ptr.configFlags.let { ImGuiConfigFlags.fromMultiple(it) }

  actual val backendFlags: Flag<ImGuiBackendFlags>
    get() = ptr.backendFlags.let { ImGuiBackendFlags.fromMultiple(it) }

  actual val displaySize: Vec2
    get() = ptr.displaySize.fromCValue()

  actual val deltaTime: Float
    get() = ptr.deltaTime

  actual val iniSavingRate: Float
    get() = ptr.iniSavingRate

  actual val iniFilename: String
    get() = ptr.iniFilename!!

  actual val logFilename: String
    get() = ptr.logFilename!!

  actual val mouseDoubleClickTime: Float
    get() = ptr.mouseDoubleClickTime

  actual val mouseDoubleClickMaxDist: Float
    get() = ptr.mouseDoubleClickMaxDist

  actual val mouseDragThreshold: Float
    get() = ptr.mouseDragThreshold

  actual val keyRepeatDelay: Float
    get() = ptr.keyRepeatDelay

  actual val keyRepeatRate: Float
    get() = ptr.keyRepeatRate

  actual val fonts: ImFontAtlas?
    get() = ptr.fonts?.let(::ImFontAtlas)

  actual val fontGlobalScale: Float
    get() = ptr.fontGlobalScale

  actual val fontAllowUserScaling: Boolean
    get() = ptr.fontAllowUserScaling

  actual val fontDefault: ImFont?
    get() = ptr.fontDefault?.let(::ImFont)

  actual val displayFramebufferScale: Vec2
    get() = ptr.displayFramebufferScale.fromCValue()

  actual val configDockingNoSplit: Boolean
    get() = ptr.configDockingNoSplit

  actual val configDockingWithShift: Boolean
    get() = ptr.configDockingWithShift

  actual val configDockingAlwaysTabBar: Boolean
    get() = ptr.configDockingAlwaysTabBar

  actual val configDockingTransparentPayload: Boolean
    get() = ptr.configDockingTransparentPayload

  actual val configViewportsNoAutoMerge: Boolean
    get() = ptr.configViewportsNoAutoMerge

  actual val configViewportsNoTaskBarIcon: Boolean
    get() = ptr.configViewportsNoTaskBarIcon

  actual val configViewportsNoDecoration: Boolean
    get() = ptr.configViewportsNoDecoration

  actual val configViewportsNoDefaultParent: Boolean
    get() = ptr.configViewportsNoDefaultParent

  actual val mouseDrawCursor: Boolean
    get() = ptr.mouseDrawCursor

  actual val configMacOSXBehaviors: Boolean
    get() = ptr.configMacOSXBehaviors

  actual val configInputTextCursorBlink: Boolean
    get() = ptr.configInputTextCursorBlink

  actual val configWindowsResizeFromEdges: Boolean
    get() = ptr.configWindowsResizeFromEdges

  actual val configWindowsMoveFromTitleBarOnly: Boolean
    get() = ptr.configWindowsMoveFromTitleBarOnly

  actual val configWindowsMemoryCompactTimer: Float
    get() = ptr.configWindowsMemoryCompactTimer

  actual val backendPlatformName: String
    get() = ptr.backendPlatformName!!

  actual val backendRendererName: String
    get() = ptr.backendRendererName!!

  actual val mousePos: Vec2
    get() = ptr.mousePos.fromCValue()

  actual val mouseWheel: Float
    get() = ptr.mouseWheel

  actual val mouseWheelH: Float
    get() = ptr.mouseWheelH

  actual val mouseHoveredViewport: ImGuiID
    get() = ptr.mouseHoveredViewport.let(::ImGuiID)

  actual val keyCtrl: Boolean
    get() = ptr.keyCtrl

  actual val keyShift: Boolean
    get() = ptr.keyShift

  actual val keyAlt: Boolean
    get() = ptr.keyAlt

  actual val keySuper: Boolean
    get() = ptr.keySuper

  actual val wantCaptureMouse: Boolean
    get() = ptr.wantCaptureMouse

  actual val wantCaptureKeyboard: Boolean
    get() = ptr.wantCaptureKeyboard

  actual val wantTextInput: Boolean
    get() = ptr.wantTextInput

  actual val wantSetMousePos: Boolean
    get() = ptr.wantSetMousePos

  actual val wantSaveIniSettings: Boolean
    get() = ptr.wantSaveIniSettings

  actual val navActive: Boolean
    get() = ptr.navActive

  actual val navVisible: Boolean
    get() = ptr.navVisible

  actual val framerate: Float
    get() = ptr.framerate

  actual val metricsRenderVertices: Int
    get() = ptr.metricsRenderVertices

  actual val metricsRenderIndices: Int
    get() = ptr.metricsRenderIndices

  actual val metricsRenderWindows: Int
    get() = ptr.metricsRenderWindows

  actual val metricsActiveWindows: Int
    get() = ptr.metricsActiveWindows

  actual val metricsActiveAllocations: Int
    get() = ptr.metricsActiveAllocations

  actual val mouseDelta: Vec2
    get() = ptr.mouseDelta.fromCValue()

  actual val keyMods: Flag<ImGuiKeyModFlags>
    get() = ptr.keyMods.let { ImGuiKeyModFlags.fromMultiple(it) }

  actual val mousePosPrev: Vec2
    get() = ptr.mousePosPrev.fromCValue()

  actual constructor() : this(ImGuiIO_ImGuiIO()!!)

  actual fun addInputCharacter(c: UInt) {
    ImGuiIO_AddInputCharacter(ptr, c.toLong())
  }

  actual fun addInputCharactersUTF8(str: String) {
    ImGuiIO_AddInputCharactersUTF8(ptr, str)
  }

  actual fun clearInputCharacters() {
    ImGuiIO_ClearInputCharacters(ptr)
  }

  actual fun destroy() {
    ImGuiIO_destroy(ptr)
  }
}
