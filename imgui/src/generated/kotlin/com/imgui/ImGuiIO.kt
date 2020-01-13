package com.imgui

import cimgui.internal.ImGuiIO_AddInputCharacter
import cimgui.internal.ImGuiIO_AddInputCharactersUTF8
import cimgui.internal.ImGuiIO_ClearInputCharacters
import cimgui.internal.ImGuiIO_ImGuiIO
import cimgui.internal.ImGuiIO_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

inline class ImGuiIO(
  val ptr: CPointer<cimgui.internal.ImGuiIO>
) {
  val configFlags: Flag<ImGuiConfigFlags>
    get() = ptr.pointed.ConfigFlags.let { ImGuiConfigFlags.fromMultiple(it) }

  val backendFlags: Flag<ImGuiBackendFlags>
    get() = ptr.pointed.BackendFlags.let { ImGuiBackendFlags.fromMultiple(it) }

  val displaySize: Vec2
    get() = ptr.pointed.DisplaySize.fromCValue()

  val deltaTime: Float
    get() = ptr.pointed.DeltaTime

  val iniSavingRate: Float
    get() = ptr.pointed.IniSavingRate

  val iniFilename: String
    get() = ptr.pointed.IniFilename!!.toKString()

  val logFilename: String
    get() = ptr.pointed.LogFilename!!.toKString()

  val mouseDoubleClickTime: Float
    get() = ptr.pointed.MouseDoubleClickTime

  val mouseDoubleClickMaxDist: Float
    get() = ptr.pointed.MouseDoubleClickMaxDist

  val mouseDragThreshold: Float
    get() = ptr.pointed.MouseDragThreshold

  val keyRepeatDelay: Float
    get() = ptr.pointed.KeyRepeatDelay

  val keyRepeatRate: Float
    get() = ptr.pointed.KeyRepeatRate

  val fonts: ImFontAtlas?
    get() = ptr.pointed.Fonts?.let(::ImFontAtlas)

  val fontGlobalScale: Float
    get() = ptr.pointed.FontGlobalScale

  val fontAllowUserScaling: Boolean
    get() = ptr.pointed.FontAllowUserScaling

  val fontDefault: ImFont?
    get() = ptr.pointed.FontDefault?.let(::ImFont)

  val displayFramebufferScale: Vec2
    get() = ptr.pointed.DisplayFramebufferScale.fromCValue()

  val mouseDrawCursor: Boolean
    get() = ptr.pointed.MouseDrawCursor

  val configMacOSXBehaviors: Boolean
    get() = ptr.pointed.ConfigMacOSXBehaviors

  val configInputTextCursorBlink: Boolean
    get() = ptr.pointed.ConfigInputTextCursorBlink

  val configWindowsResizeFromEdges: Boolean
    get() = ptr.pointed.ConfigWindowsResizeFromEdges

  val configWindowsMoveFromTitleBarOnly: Boolean
    get() = ptr.pointed.ConfigWindowsMoveFromTitleBarOnly

  val configWindowsMemoryCompactTimer: Float
    get() = ptr.pointed.ConfigWindowsMemoryCompactTimer

  val backendPlatformName: String
    get() = ptr.pointed.BackendPlatformName!!.toKString()

  val backendRendererName: String
    get() = ptr.pointed.BackendRendererName!!.toKString()

  val mousePos: Vec2
    get() = ptr.pointed.MousePos.fromCValue()

  val mouseWheel: Float
    get() = ptr.pointed.MouseWheel

  val mouseWheelH: Float
    get() = ptr.pointed.MouseWheelH

  val keyCtrl: Boolean
    get() = ptr.pointed.KeyCtrl

  val keyShift: Boolean
    get() = ptr.pointed.KeyShift

  val keyAlt: Boolean
    get() = ptr.pointed.KeyAlt

  val keySuper: Boolean
    get() = ptr.pointed.KeySuper

  val wantCaptureMouse: Boolean
    get() = ptr.pointed.WantCaptureMouse

  val wantCaptureKeyboard: Boolean
    get() = ptr.pointed.WantCaptureKeyboard

  val wantTextInput: Boolean
    get() = ptr.pointed.WantTextInput

  val wantSetMousePos: Boolean
    get() = ptr.pointed.WantSetMousePos

  val wantSaveIniSettings: Boolean
    get() = ptr.pointed.WantSaveIniSettings

  val navActive: Boolean
    get() = ptr.pointed.NavActive

  val navVisible: Boolean
    get() = ptr.pointed.NavVisible

  val framerate: Float
    get() = ptr.pointed.Framerate

  val metricsRenderVertices: Int
    get() = ptr.pointed.MetricsRenderVertices

  val metricsRenderIndices: Int
    get() = ptr.pointed.MetricsRenderIndices

  val metricsRenderWindows: Int
    get() = ptr.pointed.MetricsRenderWindows

  val metricsActiveWindows: Int
    get() = ptr.pointed.MetricsActiveWindows

  val metricsActiveAllocations: Int
    get() = ptr.pointed.MetricsActiveAllocations

  val mouseDelta: Vec2
    get() = ptr.pointed.MouseDelta.fromCValue()

  val mousePosPrev: Vec2
    get() = ptr.pointed.MousePosPrev.fromCValue()

  constructor() : this(ImGuiIO_ImGuiIO()!!)

  fun addInputCharacter(c: UInt) {
    ImGuiIO_AddInputCharacter(ptr, c)
  }

  fun addInputCharactersUTF8(str: String) {
    ImGuiIO_AddInputCharactersUTF8(ptr, str)
  }

  fun clearInputCharacters() {
    ImGuiIO_ClearInputCharacters(ptr)
  }

  fun destroy() {
    ImGuiIO_destroy(ptr)
  }
}
