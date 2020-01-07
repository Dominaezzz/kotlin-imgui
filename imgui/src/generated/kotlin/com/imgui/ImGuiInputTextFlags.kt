package com.imgui

import cimgui.internal.ImGuiInputTextFlags_AllowTabInput
import cimgui.internal.ImGuiInputTextFlags_AlwaysInsertMode
import cimgui.internal.ImGuiInputTextFlags_AutoSelectAll
import cimgui.internal.ImGuiInputTextFlags_CallbackAlways
import cimgui.internal.ImGuiInputTextFlags_CallbackCharFilter
import cimgui.internal.ImGuiInputTextFlags_CallbackCompletion
import cimgui.internal.ImGuiInputTextFlags_CallbackHistory
import cimgui.internal.ImGuiInputTextFlags_CallbackResize
import cimgui.internal.ImGuiInputTextFlags_CharsDecimal
import cimgui.internal.ImGuiInputTextFlags_CharsHexadecimal
import cimgui.internal.ImGuiInputTextFlags_CharsNoBlank
import cimgui.internal.ImGuiInputTextFlags_CharsScientific
import cimgui.internal.ImGuiInputTextFlags_CharsUppercase
import cimgui.internal.ImGuiInputTextFlags_CtrlEnterForNewLine
import cimgui.internal.ImGuiInputTextFlags_EnterReturnsTrue
import cimgui.internal.ImGuiInputTextFlags_Multiline
import cimgui.internal.ImGuiInputTextFlags_NoHorizontalScroll
import cimgui.internal.ImGuiInputTextFlags_NoMarkEdited
import cimgui.internal.ImGuiInputTextFlags_NoUndoRedo
import cimgui.internal.ImGuiInputTextFlags_Password
import cimgui.internal.ImGuiInputTextFlags_ReadOnly
import kotlin.Int

enum class ImGuiInputTextFlags(
  override val value: Int
) : Flag<ImGuiInputTextFlags> {
  CharsDecimal(ImGuiInputTextFlags_CharsDecimal.toInt()),

  CharsHexadecimal(ImGuiInputTextFlags_CharsHexadecimal.toInt()),

  CharsUppercase(ImGuiInputTextFlags_CharsUppercase.toInt()),

  CharsNoBlank(ImGuiInputTextFlags_CharsNoBlank.toInt()),

  AutoSelectAll(ImGuiInputTextFlags_AutoSelectAll.toInt()),

  EnterReturnsTrue(ImGuiInputTextFlags_EnterReturnsTrue.toInt()),

  CallbackCompletion(ImGuiInputTextFlags_CallbackCompletion.toInt()),

  CallbackHistory(ImGuiInputTextFlags_CallbackHistory.toInt()),

  CallbackAlways(ImGuiInputTextFlags_CallbackAlways.toInt()),

  CallbackCharFilter(ImGuiInputTextFlags_CallbackCharFilter.toInt()),

  AllowTabInput(ImGuiInputTextFlags_AllowTabInput.toInt()),

  CtrlEnterForNewLine(ImGuiInputTextFlags_CtrlEnterForNewLine.toInt()),

  NoHorizontalScroll(ImGuiInputTextFlags_NoHorizontalScroll.toInt()),

  AlwaysInsertMode(ImGuiInputTextFlags_AlwaysInsertMode.toInt()),

  ReadOnly(ImGuiInputTextFlags_ReadOnly.toInt()),

  Password(ImGuiInputTextFlags_Password.toInt()),

  NoUndoRedo(ImGuiInputTextFlags_NoUndoRedo.toInt()),

  CharsScientific(ImGuiInputTextFlags_CharsScientific.toInt()),

  CallbackResize(ImGuiInputTextFlags_CallbackResize.toInt()),

  Multiline(ImGuiInputTextFlags_Multiline.toInt()),

  NoMarkEdited(ImGuiInputTextFlags_NoMarkEdited.toInt());

  override val info: Flag.EnumInfo<ImGuiInputTextFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiInputTextFlags> = Flag.enumInfo()
  }
}
