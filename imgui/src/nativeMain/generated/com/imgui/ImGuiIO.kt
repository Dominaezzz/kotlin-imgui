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

  actual var backendFlags: Flag<ImGuiBackendFlags>
    get() = ptr.pointed.BackendFlags.let { ImGuiBackendFlags.fromMultiple(it) }
    set(value) {
      ptr.pointed.BackendFlags = value.value
    }

  actual var displaySize: Vec2
    get() = ptr.pointed.DisplaySize.fromCValue()
    set(value) {
      ptr.pointed.DisplaySize.fromKValue(value)
    }

  actual var deltaTime: Float
    get() = ptr.pointed.DeltaTime
    set(value) {
      ptr.pointed.DeltaTime = value
    }

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

  actual var displayFramebufferScale: Vec2
    get() = ptr.pointed.DisplayFramebufferScale.fromCValue()
    set(value) {
      ptr.pointed.DisplayFramebufferScale.fromKValue(value)
    }

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

  actual var mousePos: Vec2
    get() = ptr.pointed.MousePos.fromCValue()
    set(value) {
      ptr.pointed.MousePos.fromKValue(value)
    }

  actual var mouseWheel: Float
    get() = ptr.pointed.MouseWheel
    set(value) {
      ptr.pointed.MouseWheel = value
    }

  actual var mouseWheelH: Float
    get() = ptr.pointed.MouseWheelH
    set(value) {
      ptr.pointed.MouseWheelH = value
    }

  actual var keyCtrl: Boolean
    get() = ptr.pointed.KeyCtrl
    set(value) {
      ptr.pointed.KeyCtrl = value
    }

  actual var keyShift: Boolean
    get() = ptr.pointed.KeyShift
    set(value) {
      ptr.pointed.KeyShift = value
    }

  actual var keyAlt: Boolean
    get() = ptr.pointed.KeyAlt
    set(value) {
      ptr.pointed.KeyAlt = value
    }

  actual var keySuper: Boolean
    get() = ptr.pointed.KeySuper
    set(value) {
      ptr.pointed.KeySuper = value
    }

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

  actual val keyMods: Flag<ImGuiKeyModFlags>
    get() = ptr.pointed.KeyMods.let { ImGuiKeyModFlags.fromMultiple(it) }

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
