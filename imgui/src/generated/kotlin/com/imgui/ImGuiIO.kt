package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiIO(
  val ptr: CPointer<cimgui.internal.ImGuiIO>
) {
  val deltaTime: Float
    get() = ptr.pointed.DeltaTime

  val iniSavingRate: Float
    get() = ptr.pointed.IniSavingRate

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

  val fontGlobalScale: Float
    get() = ptr.pointed.FontGlobalScale

  val fontAllowUserScaling: Boolean
    get() = ptr.pointed.FontAllowUserScaling

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
}
