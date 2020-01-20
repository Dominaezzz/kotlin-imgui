package com.imgui

import kotlin.reflect.KMutableProperty0


typealias ImGuiInputTextCallback = (data: ImGuiInputTextCallbackData) -> Int

expect fun ImGui.inputText(label: String, buf: ByteArray, flags: Flag<ImGuiInputTextFlags>? = null, callback: ImGuiInputTextCallback ? = null): Boolean

expect fun ImGui.inputTextMultiline(label: String, buf: ByteArray, size: Vec2 = Vec2.Zero, flags: Flag<ImGuiInputTextFlags>? = null, callback: ImGuiInputTextCallback ? = null): Boolean

expect fun ImGui.inputTextWithHint(label: String, hint: String, buf: ByteArray, flags: Flag<ImGuiInputTextFlags>? = null, callback: ImGuiInputTextCallback ? = null): Boolean


typealias ImGuiSizeCallback = (ImGuiSizeCallbackData) -> Unit

expect fun ImGui.setNextWindowSizeConstraints(sizeMin: Vec2, sizeMax: Vec2, customCallback: ImGuiSizeCallback? = null)


expect fun ImGui.combo(label: String, currentItem: KMutableProperty0<Int>, items: Array<String>, popupMaxHeightInItems: Int = -1): Boolean

expect fun ImGui.combo(label: String, currentItem: KMutableProperty0<Int>, itemsGetter: (idx: Int) -> String?, itemsCount: Int, popupMaxHeightInItems: Int = -1): Boolean


expect fun ImGui.listBox(label: String, currentItem: KMutableProperty0<Int>, items: Array<String>, heightInItems: Int = -1): Boolean

expect fun ImGui.listBox(label: String, currentItem: KMutableProperty0<Int>, itemsGetter: (idx: Int) -> String?, itemsCount: Int, heightInItems: Int = -1): Boolean


expect fun ImGui.plotHistogram(label: String, values: FloatArray, valuesOffset: Int = 0, overlayText: String? = null, scaleMin: Float = Float.MAX_VALUE, scaleMax: Float = Float.MAX_VALUE, graphSize: Vec2 = Vec2.Zero, stride: Int = /* Should be Float */ Int.SIZE_BYTES)

expect fun ImGui.plotHistogram(label: String, valuesGetter: (Int) -> Float, valuesCount: Int, valuesOffset: Int = 0, overlayText: String? = null, scaleMin: Float = Float.MAX_VALUE, scaleMax: Float = Float.MAX_VALUE, graphSize: Vec2 = Vec2.Zero)


expect fun ImGui.plotLines(label: String, values: FloatArray, valuesOffset: Int = 0, overlayText: String? = null, scaleMin: Float = Float.MAX_VALUE, scaleMax: Float = Float.MAX_VALUE, graphSize: Vec2 = Vec2.Zero, stride: Int = /* Should be Float */ Int.SIZE_BYTES)

expect fun ImGui.plotLines(label: String, valuesGetter: (Int) -> Float, valuesCount: Int, valuesOffset: Int = 0, overlayText: String? = null, scaleMin: Float = Float.MAX_VALUE, scaleMax: Float = Float.MAX_VALUE, graphSize: Vec2 = Vec2.Zero)
