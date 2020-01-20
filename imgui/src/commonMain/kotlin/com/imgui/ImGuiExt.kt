package com.imgui

import kotlin.reflect.KMutableProperty0


expect fun <T> ImGui.checkboxFlags(label: String, flags: KMutableProperty0<Flag<T>?>, flagsValue: Flag<T>): Boolean where T : Enum<T>, T : Flag<T>
