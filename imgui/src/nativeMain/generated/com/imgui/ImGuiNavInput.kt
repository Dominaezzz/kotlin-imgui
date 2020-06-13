package com.imgui

import cimgui.internal.ImGuiNavInput_
import cimgui.internal.ImGuiNavInput_Activate
import cimgui.internal.ImGuiNavInput_Cancel
import cimgui.internal.ImGuiNavInput_DpadDown
import cimgui.internal.ImGuiNavInput_DpadLeft
import cimgui.internal.ImGuiNavInput_DpadRight
import cimgui.internal.ImGuiNavInput_DpadUp
import cimgui.internal.ImGuiNavInput_FocusNext
import cimgui.internal.ImGuiNavInput_FocusPrev
import cimgui.internal.ImGuiNavInput_Input
import cimgui.internal.ImGuiNavInput_InternalStart_
import cimgui.internal.ImGuiNavInput_KeyDown_
import cimgui.internal.ImGuiNavInput_KeyLeft_
import cimgui.internal.ImGuiNavInput_KeyMenu_
import cimgui.internal.ImGuiNavInput_KeyRight_
import cimgui.internal.ImGuiNavInput_KeyUp_
import cimgui.internal.ImGuiNavInput_LStickDown
import cimgui.internal.ImGuiNavInput_LStickLeft
import cimgui.internal.ImGuiNavInput_LStickRight
import cimgui.internal.ImGuiNavInput_LStickUp
import cimgui.internal.ImGuiNavInput_Menu
import cimgui.internal.ImGuiNavInput_TweakFast
import cimgui.internal.ImGuiNavInput_TweakSlow
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiNavInput(
  val value: cimgui.internal.ImGuiNavInput
) {
  Activate(ImGuiNavInput_Activate.convert()),

  Cancel(ImGuiNavInput_Cancel.convert()),

  Input(ImGuiNavInput_Input.convert()),

  Menu(ImGuiNavInput_Menu.convert()),

  DpadLeft(ImGuiNavInput_DpadLeft.convert()),

  DpadRight(ImGuiNavInput_DpadRight.convert()),

  DpadUp(ImGuiNavInput_DpadUp.convert()),

  DpadDown(ImGuiNavInput_DpadDown.convert()),

  LStickLeft(ImGuiNavInput_LStickLeft.convert()),

  LStickRight(ImGuiNavInput_LStickRight.convert()),

  LStickUp(ImGuiNavInput_LStickUp.convert()),

  LStickDown(ImGuiNavInput_LStickDown.convert()),

  FocusPrev(ImGuiNavInput_FocusPrev.convert()),

  FocusNext(ImGuiNavInput_FocusNext.convert()),

  TweakSlow(ImGuiNavInput_TweakSlow.convert()),

  TweakFast(ImGuiNavInput_TweakFast.convert()),

  KeyMenu_(ImGuiNavInput_KeyMenu_.convert()),

  KeyLeft_(ImGuiNavInput_KeyLeft_.convert()),

  KeyRight_(ImGuiNavInput_KeyRight_.convert()),

  KeyUp_(ImGuiNavInput_KeyUp_.convert()),

  KeyDown_(ImGuiNavInput_KeyDown_.convert()),

  InternalStart_(ImGuiNavInput_InternalStart_.convert());

  actual val cValue: Int
    get() = value.convert()

  actual companion object {
    fun from(value: cimgui.internal.ImGuiNavInput): ImGuiNavInput = when
        (value.convert<ImGuiNavInput_>()) {
      ImGuiNavInput_Activate -> Activate
      ImGuiNavInput_Cancel -> Cancel
      ImGuiNavInput_Input -> Input
      ImGuiNavInput_Menu -> Menu
      ImGuiNavInput_DpadLeft -> DpadLeft
      ImGuiNavInput_DpadRight -> DpadRight
      ImGuiNavInput_DpadUp -> DpadUp
      ImGuiNavInput_DpadDown -> DpadDown
      ImGuiNavInput_LStickLeft -> LStickLeft
      ImGuiNavInput_LStickRight -> LStickRight
      ImGuiNavInput_LStickUp -> LStickUp
      ImGuiNavInput_LStickDown -> LStickDown
      ImGuiNavInput_FocusPrev -> FocusPrev
      ImGuiNavInput_FocusNext -> FocusNext
      ImGuiNavInput_TweakSlow -> TweakSlow
      ImGuiNavInput_TweakFast -> TweakFast
      ImGuiNavInput_KeyMenu_ -> KeyMenu_
      ImGuiNavInput_KeyLeft_ -> KeyLeft_
      ImGuiNavInput_KeyRight_ -> KeyRight_
      ImGuiNavInput_KeyUp_ -> KeyUp_
      ImGuiNavInput_KeyDown_ -> KeyDown_
      ImGuiNavInput_InternalStart_ -> InternalStart_
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}
