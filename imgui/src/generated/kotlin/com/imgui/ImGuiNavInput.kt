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
import cimgui.internal.ImGuiNavInput_KeyTab_
import cimgui.internal.ImGuiNavInput_KeyUp_
import cimgui.internal.ImGuiNavInput_LStickDown
import cimgui.internal.ImGuiNavInput_LStickLeft
import cimgui.internal.ImGuiNavInput_LStickRight
import cimgui.internal.ImGuiNavInput_LStickUp
import cimgui.internal.ImGuiNavInput_Menu
import cimgui.internal.ImGuiNavInput_TweakFast
import cimgui.internal.ImGuiNavInput_TweakSlow

enum class ImGuiNavInput(
  val value: ImGuiNavInput_
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

  KeyTab_(ImGuiNavInput_KeyTab_),

  KeyLeft_(ImGuiNavInput_KeyLeft_),

  KeyRight_(ImGuiNavInput_KeyRight_),

  KeyUp_(ImGuiNavInput_KeyUp_),

  KeyDown_(ImGuiNavInput_KeyDown_),

  InternalStart_(ImGuiNavInput_InternalStart_);
}
