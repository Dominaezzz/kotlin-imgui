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
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiIO(
  val ptr: CPointer<cimgui.internal.ImGuiIO>
) {
  actual val configFlags: Flag<ImGuiConfigFlags>
    get() = ptr.pointed.ConfigFlags.let { ImGuiConfigFlags.fromMultiple(it) }

  actual val backendFlags: Flag<ImGuiBackendFlags>
    get() = ptr.pointed.BackendFlags.let { ImGuiBackendFlags.fromMultiple(it) }

  actual val displaySize: Vec2
    get() = ptr.pointed.DisplaySize.fromCValue()

  actual val deltaTime: Float
    get() = ptr.pointed.DeltaTime

  actual val iniSavingRate: Float
    get() = ptr.pointed.IniSavingRate

  actual val iniFilename: String
    get() = ptr.pointed.IniFilename!!.toKString()

  actual val logFilename: String
    get() = ptr.pointed.LogFilename!!.toKString()

  actual val mouseDoubleClickTime: Float
    get() = ptr.pointed.MouseDoubleClickTime

  actual val mouseDoubleClickMaxDist: Float
    get() = ptr.pointed.MouseDoubleClickMaxDist

  actual val mouseDragThreshold: Float
    get() = ptr.pointed.MouseDragThreshold

  actual val keyRepeatDelay: Float
    get() = ptr.pointed.KeyRepeatDelay

  actual val keyRepeatRate: Float
    get() = ptr.pointed.KeyRepeatRate

  actual val fonts: ImFontAtlas?
    get() = ptr.pointed.Fonts?.let(::ImFontAtlas)

  actual val fontGlobalScale: Float
    get() = ptr.pointed.FontGlobalScale

  actual val fontAllowUserScaling: Boolean
    get() = ptr.pointed.FontAllowUserScaling

  actual val fontDefault: ImFont?
    get() = ptr.pointed.FontDefault?.let(::ImFont)

  actual val displayFramebufferScale: Vec2
    get() = ptr.pointed.DisplayFramebufferScale.fromCValue()

  actual val mouseDrawCursor: Boolean
    get() = ptr.pointed.MouseDrawCursor

  actual val configMacOSXBehaviors: Boolean
    get() = ptr.pointed.ConfigMacOSXBehaviors

  actual val configInputTextCursorBlink: Boolean
    get() = ptr.pointed.ConfigInputTextCursorBlink

  actual val configWindowsResizeFromEdges: Boolean
    get() = ptr.pointed.ConfigWindowsResizeFromEdges

  actual val configWindowsMoveFromTitleBarOnly: Boolean
    get() = ptr.pointed.ConfigWindowsMoveFromTitleBarOnly

  actual val configWindowsMemoryCompactTimer: Float
    get() = ptr.pointed.ConfigWindowsMemoryCompactTimer

  actual val backendPlatformName: String
    get() = ptr.pointed.BackendPlatformName!!.toKString()

  actual val backendRendererName: String
    get() = ptr.pointed.BackendRendererName!!.toKString()

  actual val mousePos: Vec2
    get() = ptr.pointed.MousePos.fromCValue()

  actual val mouseWheel: Float
    get() = ptr.pointed.MouseWheel

  actual val mouseWheelH: Float
    get() = ptr.pointed.MouseWheelH

  actual val keyCtrl: Boolean
    get() = ptr.pointed.KeyCtrl

  actual val keyShift: Boolean
    get() = ptr.pointed.KeyShift

  actual val keyAlt: Boolean
    get() = ptr.pointed.KeyAlt

  actual val keySuper: Boolean
    get() = ptr.pointed.KeySuper

  actual val wantCaptureMouse: Boolean
    get() = ptr.pointed.WantCaptureMouse

  actual val wantCaptureKeyboard: Boolean
    get() = ptr.pointed.WantCaptureKeyboard

  actual val wantTextInput: Boolean
    get() = ptr.pointed.WantTextInput

  actual val wantSetMousePos: Boolean
    get() = ptr.pointed.WantSetMousePos

  actual val wantSaveIniSettings: Boolean
    get() = ptr.pointed.WantSaveIniSettings

  actual val navActive: Boolean
    get() = ptr.pointed.NavActive

  actual val navVisible: Boolean
    get() = ptr.pointed.NavVisible

  actual val framerate: Float
    get() = ptr.pointed.Framerate

  actual val metricsRenderVertices: Int
    get() = ptr.pointed.MetricsRenderVertices

  actual val metricsRenderIndices: Int
    get() = ptr.pointed.MetricsRenderIndices

  actual val metricsRenderWindows: Int
    get() = ptr.pointed.MetricsRenderWindows

  actual val metricsActiveWindows: Int
    get() = ptr.pointed.MetricsActiveWindows

  actual val metricsActiveAllocations: Int
    get() = ptr.pointed.MetricsActiveAllocations

  actual val mouseDelta: Vec2
    get() = ptr.pointed.MouseDelta.fromCValue()

  actual val mousePosPrev: Vec2
    get() = ptr.pointed.MousePosPrev.fromCValue()

  actual constructor() : this(ImGuiIO_ImGuiIO()!!)

  actual fun addInputCharacter(c: UInt) {
    ImGuiIO_AddInputCharacter(ptr, c)
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
