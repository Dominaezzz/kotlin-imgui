package com.imgui

import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_Activate
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_Cancel
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_DpadDown
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_DpadLeft
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_DpadRight
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_DpadUp
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_FocusNext
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_FocusPrev
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_Input
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_InternalStart_
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_KeyDown_
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_KeyLeft_
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_KeyMenu_
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_KeyRight_
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_KeyUp_
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_LStickDown
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_LStickLeft
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_LStickRight
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_LStickUp
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_Menu
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_TweakFast
import cimgui.internal.ImGuiNavInput_.ImGuiNavInput_TweakSlow
import kotlin.Int

actual enum class ImGuiNavInput(
  val value: Int
) {
  Activate(ImGuiNavInput_Activate),

  Cancel(ImGuiNavInput_Cancel),

  Input(ImGuiNavInput_Input),

  Menu(ImGuiNavInput_Menu),

  DpadLeft(ImGuiNavInput_DpadLeft),

  DpadRight(ImGuiNavInput_DpadRight),

  DpadUp(ImGuiNavInput_DpadUp),

  DpadDown(ImGuiNavInput_DpadDown),

  LStickLeft(ImGuiNavInput_LStickLeft),

  LStickRight(ImGuiNavInput_LStickRight),

  LStickUp(ImGuiNavInput_LStickUp),

  LStickDown(ImGuiNavInput_LStickDown),

  FocusPrev(ImGuiNavInput_FocusPrev),

  FocusNext(ImGuiNavInput_FocusNext),

  TweakSlow(ImGuiNavInput_TweakSlow),

  TweakFast(ImGuiNavInput_TweakFast),

  KeyMenu_(ImGuiNavInput_KeyMenu_),

  KeyLeft_(ImGuiNavInput_KeyLeft_),

  KeyRight_(ImGuiNavInput_KeyRight_),

  KeyUp_(ImGuiNavInput_KeyUp_),

  KeyDown_(ImGuiNavInput_KeyDown_),

  InternalStart_(ImGuiNavInput_InternalStart_);

  actual val cValue: Int
    get() = value

  actual companion object {
    fun from(value: Int): ImGuiNavInput = when (value) {
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
