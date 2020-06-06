/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class ImGuiWindow {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ImGuiWindow(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ImGuiWindow obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        CImGuiJNI.delete_ImGuiWindow(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(String value) {
    CImGuiJNI.ImGuiWindow_Name_set(swigCPtr, this, value);
  }

  public String getName() {
    return CImGuiJNI.ImGuiWindow_Name_get(swigCPtr, this);
  }

  public void setID(long value) {
    CImGuiJNI.ImGuiWindow_ID_set(swigCPtr, this, value);
  }

  public long getID() {
    return CImGuiJNI.ImGuiWindow_ID_get(swigCPtr, this);
  }

  public void setFlags(int value) {
    CImGuiJNI.ImGuiWindow_Flags_set(swigCPtr, this, value);
  }

  public int getFlags() {
    return CImGuiJNI.ImGuiWindow_Flags_get(swigCPtr, this);
  }

  public void setFlagsPreviousFrame(int value) {
    CImGuiJNI.ImGuiWindow_FlagsPreviousFrame_set(swigCPtr, this, value);
  }

  public int getFlagsPreviousFrame() {
    return CImGuiJNI.ImGuiWindow_FlagsPreviousFrame_get(swigCPtr, this);
  }

  public void setWindowClass(ImGuiWindowClass value) {
    CImGuiJNI.ImGuiWindow_WindowClass_set(swigCPtr, this, ImGuiWindowClass.getCPtr(value), value);
  }

  public ImGuiWindowClass getWindowClass() {
    long cPtr = CImGuiJNI.ImGuiWindow_WindowClass_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindowClass(cPtr, false);
  }

  public void setViewport(ImGuiViewportP value) {
    CImGuiJNI.ImGuiWindow_Viewport_set(swigCPtr, this, ImGuiViewportP.getCPtr(value), value);
  }

  public ImGuiViewportP getViewport() {
    long cPtr = CImGuiJNI.ImGuiWindow_Viewport_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiViewportP(cPtr, false);
  }

  public void setViewportId(long value) {
    CImGuiJNI.ImGuiWindow_ViewportId_set(swigCPtr, this, value);
  }

  public long getViewportId() {
    return CImGuiJNI.ImGuiWindow_ViewportId_get(swigCPtr, this);
  }

  public void setViewportPos(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_ViewportPos_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getViewportPos() {
    long cPtr = CImGuiJNI.ImGuiWindow_ViewportPos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setViewportAllowPlatformMonitorExtend(int value) {
    CImGuiJNI.ImGuiWindow_ViewportAllowPlatformMonitorExtend_set(swigCPtr, this, value);
  }

  public int getViewportAllowPlatformMonitorExtend() {
    return CImGuiJNI.ImGuiWindow_ViewportAllowPlatformMonitorExtend_get(swigCPtr, this);
  }

  public void setPos(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_Pos_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getPos() {
    long cPtr = CImGuiJNI.ImGuiWindow_Pos_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setSize(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_Size_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getSize() {
    long cPtr = CImGuiJNI.ImGuiWindow_Size_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setSizeFull(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_SizeFull_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getSizeFull() {
    long cPtr = CImGuiJNI.ImGuiWindow_SizeFull_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setContentSize(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_ContentSize_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getContentSize() {
    long cPtr = CImGuiJNI.ImGuiWindow_ContentSize_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setContentSizeExplicit(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_ContentSizeExplicit_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getContentSizeExplicit() {
    long cPtr = CImGuiJNI.ImGuiWindow_ContentSizeExplicit_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setWindowPadding(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_WindowPadding_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getWindowPadding() {
    long cPtr = CImGuiJNI.ImGuiWindow_WindowPadding_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setWindowRounding(float value) {
    CImGuiJNI.ImGuiWindow_WindowRounding_set(swigCPtr, this, value);
  }

  public float getWindowRounding() {
    return CImGuiJNI.ImGuiWindow_WindowRounding_get(swigCPtr, this);
  }

  public void setWindowBorderSize(float value) {
    CImGuiJNI.ImGuiWindow_WindowBorderSize_set(swigCPtr, this, value);
  }

  public float getWindowBorderSize() {
    return CImGuiJNI.ImGuiWindow_WindowBorderSize_get(swigCPtr, this);
  }

  public void setNameBufLen(int value) {
    CImGuiJNI.ImGuiWindow_NameBufLen_set(swigCPtr, this, value);
  }

  public int getNameBufLen() {
    return CImGuiJNI.ImGuiWindow_NameBufLen_get(swigCPtr, this);
  }

  public void setMoveId(long value) {
    CImGuiJNI.ImGuiWindow_MoveId_set(swigCPtr, this, value);
  }

  public long getMoveId() {
    return CImGuiJNI.ImGuiWindow_MoveId_get(swigCPtr, this);
  }

  public void setChildId(long value) {
    CImGuiJNI.ImGuiWindow_ChildId_set(swigCPtr, this, value);
  }

  public long getChildId() {
    return CImGuiJNI.ImGuiWindow_ChildId_get(swigCPtr, this);
  }

  public void setScroll(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_Scroll_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getScroll() {
    long cPtr = CImGuiJNI.ImGuiWindow_Scroll_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setScrollMax(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_ScrollMax_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getScrollMax() {
    long cPtr = CImGuiJNI.ImGuiWindow_ScrollMax_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setScrollTarget(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_ScrollTarget_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getScrollTarget() {
    long cPtr = CImGuiJNI.ImGuiWindow_ScrollTarget_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setScrollTargetCenterRatio(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_ScrollTargetCenterRatio_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getScrollTargetCenterRatio() {
    long cPtr = CImGuiJNI.ImGuiWindow_ScrollTargetCenterRatio_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setScrollbarSizes(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_ScrollbarSizes_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getScrollbarSizes() {
    long cPtr = CImGuiJNI.ImGuiWindow_ScrollbarSizes_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setScrollbarX(boolean value) {
    CImGuiJNI.ImGuiWindow_ScrollbarX_set(swigCPtr, this, value);
  }

  public boolean getScrollbarX() {
    return CImGuiJNI.ImGuiWindow_ScrollbarX_get(swigCPtr, this);
  }

  public void setScrollbarY(boolean value) {
    CImGuiJNI.ImGuiWindow_ScrollbarY_set(swigCPtr, this, value);
  }

  public boolean getScrollbarY() {
    return CImGuiJNI.ImGuiWindow_ScrollbarY_get(swigCPtr, this);
  }

  public void setViewportOwned(boolean value) {
    CImGuiJNI.ImGuiWindow_ViewportOwned_set(swigCPtr, this, value);
  }

  public boolean getViewportOwned() {
    return CImGuiJNI.ImGuiWindow_ViewportOwned_get(swigCPtr, this);
  }

  public void setActive(boolean value) {
    CImGuiJNI.ImGuiWindow_Active_set(swigCPtr, this, value);
  }

  public boolean getActive() {
    return CImGuiJNI.ImGuiWindow_Active_get(swigCPtr, this);
  }

  public void setWasActive(boolean value) {
    CImGuiJNI.ImGuiWindow_WasActive_set(swigCPtr, this, value);
  }

  public boolean getWasActive() {
    return CImGuiJNI.ImGuiWindow_WasActive_get(swigCPtr, this);
  }

  public void setWriteAccessed(boolean value) {
    CImGuiJNI.ImGuiWindow_WriteAccessed_set(swigCPtr, this, value);
  }

  public boolean getWriteAccessed() {
    return CImGuiJNI.ImGuiWindow_WriteAccessed_get(swigCPtr, this);
  }

  public void setCollapsed(boolean value) {
    CImGuiJNI.ImGuiWindow_Collapsed_set(swigCPtr, this, value);
  }

  public boolean getCollapsed() {
    return CImGuiJNI.ImGuiWindow_Collapsed_get(swigCPtr, this);
  }

  public void setWantCollapseToggle(boolean value) {
    CImGuiJNI.ImGuiWindow_WantCollapseToggle_set(swigCPtr, this, value);
  }

  public boolean getWantCollapseToggle() {
    return CImGuiJNI.ImGuiWindow_WantCollapseToggle_get(swigCPtr, this);
  }

  public void setSkipItems(boolean value) {
    CImGuiJNI.ImGuiWindow_SkipItems_set(swigCPtr, this, value);
  }

  public boolean getSkipItems() {
    return CImGuiJNI.ImGuiWindow_SkipItems_get(swigCPtr, this);
  }

  public void setAppearing(boolean value) {
    CImGuiJNI.ImGuiWindow_Appearing_set(swigCPtr, this, value);
  }

  public boolean getAppearing() {
    return CImGuiJNI.ImGuiWindow_Appearing_get(swigCPtr, this);
  }

  public void setHidden(boolean value) {
    CImGuiJNI.ImGuiWindow_Hidden_set(swigCPtr, this, value);
  }

  public boolean getHidden() {
    return CImGuiJNI.ImGuiWindow_Hidden_get(swigCPtr, this);
  }

  public void setIsFallbackWindow(boolean value) {
    CImGuiJNI.ImGuiWindow_IsFallbackWindow_set(swigCPtr, this, value);
  }

  public boolean getIsFallbackWindow() {
    return CImGuiJNI.ImGuiWindow_IsFallbackWindow_get(swigCPtr, this);
  }

  public void setHasCloseButton(boolean value) {
    CImGuiJNI.ImGuiWindow_HasCloseButton_set(swigCPtr, this, value);
  }

  public boolean getHasCloseButton() {
    return CImGuiJNI.ImGuiWindow_HasCloseButton_get(swigCPtr, this);
  }

  public void setResizeBorderHeld(byte value) {
    CImGuiJNI.ImGuiWindow_ResizeBorderHeld_set(swigCPtr, this, value);
  }

  public byte getResizeBorderHeld() {
    return CImGuiJNI.ImGuiWindow_ResizeBorderHeld_get(swigCPtr, this);
  }

  public void setBeginCount(short value) {
    CImGuiJNI.ImGuiWindow_BeginCount_set(swigCPtr, this, value);
  }

  public short getBeginCount() {
    return CImGuiJNI.ImGuiWindow_BeginCount_get(swigCPtr, this);
  }

  public void setBeginOrderWithinParent(short value) {
    CImGuiJNI.ImGuiWindow_BeginOrderWithinParent_set(swigCPtr, this, value);
  }

  public short getBeginOrderWithinParent() {
    return CImGuiJNI.ImGuiWindow_BeginOrderWithinParent_get(swigCPtr, this);
  }

  public void setBeginOrderWithinContext(short value) {
    CImGuiJNI.ImGuiWindow_BeginOrderWithinContext_set(swigCPtr, this, value);
  }

  public short getBeginOrderWithinContext() {
    return CImGuiJNI.ImGuiWindow_BeginOrderWithinContext_get(swigCPtr, this);
  }

  public void setPopupId(long value) {
    CImGuiJNI.ImGuiWindow_PopupId_set(swigCPtr, this, value);
  }

  public long getPopupId() {
    return CImGuiJNI.ImGuiWindow_PopupId_get(swigCPtr, this);
  }

  public void setAutoFitFramesX(byte value) {
    CImGuiJNI.ImGuiWindow_AutoFitFramesX_set(swigCPtr, this, value);
  }

  public byte getAutoFitFramesX() {
    return CImGuiJNI.ImGuiWindow_AutoFitFramesX_get(swigCPtr, this);
  }

  public void setAutoFitFramesY(byte value) {
    CImGuiJNI.ImGuiWindow_AutoFitFramesY_set(swigCPtr, this, value);
  }

  public byte getAutoFitFramesY() {
    return CImGuiJNI.ImGuiWindow_AutoFitFramesY_get(swigCPtr, this);
  }

  public void setAutoFitChildAxises(byte value) {
    CImGuiJNI.ImGuiWindow_AutoFitChildAxises_set(swigCPtr, this, value);
  }

  public byte getAutoFitChildAxises() {
    return CImGuiJNI.ImGuiWindow_AutoFitChildAxises_get(swigCPtr, this);
  }

  public void setAutoFitOnlyGrows(boolean value) {
    CImGuiJNI.ImGuiWindow_AutoFitOnlyGrows_set(swigCPtr, this, value);
  }

  public boolean getAutoFitOnlyGrows() {
    return CImGuiJNI.ImGuiWindow_AutoFitOnlyGrows_get(swigCPtr, this);
  }

  public void setAutoPosLastDirection(int value) {
    CImGuiJNI.ImGuiWindow_AutoPosLastDirection_set(swigCPtr, this, value);
  }

  public int getAutoPosLastDirection() {
    return CImGuiJNI.ImGuiWindow_AutoPosLastDirection_get(swigCPtr, this);
  }

  public void setHiddenFramesCanSkipItems(int value) {
    CImGuiJNI.ImGuiWindow_HiddenFramesCanSkipItems_set(swigCPtr, this, value);
  }

  public int getHiddenFramesCanSkipItems() {
    return CImGuiJNI.ImGuiWindow_HiddenFramesCanSkipItems_get(swigCPtr, this);
  }

  public void setHiddenFramesCannotSkipItems(int value) {
    CImGuiJNI.ImGuiWindow_HiddenFramesCannotSkipItems_set(swigCPtr, this, value);
  }

  public int getHiddenFramesCannotSkipItems() {
    return CImGuiJNI.ImGuiWindow_HiddenFramesCannotSkipItems_get(swigCPtr, this);
  }

  public void setSetWindowPosAllowFlags(int value) {
    CImGuiJNI.ImGuiWindow_SetWindowPosAllowFlags_set(swigCPtr, this, value);
  }

  public int getSetWindowPosAllowFlags() {
    return CImGuiJNI.ImGuiWindow_SetWindowPosAllowFlags_get(swigCPtr, this);
  }

  public void setSetWindowSizeAllowFlags(int value) {
    CImGuiJNI.ImGuiWindow_SetWindowSizeAllowFlags_set(swigCPtr, this, value);
  }

  public int getSetWindowSizeAllowFlags() {
    return CImGuiJNI.ImGuiWindow_SetWindowSizeAllowFlags_get(swigCPtr, this);
  }

  public void setSetWindowCollapsedAllowFlags(int value) {
    CImGuiJNI.ImGuiWindow_SetWindowCollapsedAllowFlags_set(swigCPtr, this, value);
  }

  public int getSetWindowCollapsedAllowFlags() {
    return CImGuiJNI.ImGuiWindow_SetWindowCollapsedAllowFlags_get(swigCPtr, this);
  }

  public void setSetWindowDockAllowFlags(int value) {
    CImGuiJNI.ImGuiWindow_SetWindowDockAllowFlags_set(swigCPtr, this, value);
  }

  public int getSetWindowDockAllowFlags() {
    return CImGuiJNI.ImGuiWindow_SetWindowDockAllowFlags_get(swigCPtr, this);
  }

  public void setSetWindowPosVal(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_SetWindowPosVal_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getSetWindowPosVal() {
    long cPtr = CImGuiJNI.ImGuiWindow_SetWindowPosVal_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setSetWindowPosPivot(ImVec2 value) {
    CImGuiJNI.ImGuiWindow_SetWindowPosPivot_set(swigCPtr, this, ImVec2.getCPtr(value), value);
  }

  public ImVec2 getSetWindowPosPivot() {
    long cPtr = CImGuiJNI.ImGuiWindow_SetWindowPosPivot_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2(cPtr, false);
  }

  public void setIDStack(ImVector_ImGuiID value) {
    CImGuiJNI.ImGuiWindow_IDStack_set(swigCPtr, this, ImVector_ImGuiID.getCPtr(value), value);
  }

  public ImVector_ImGuiID getIDStack() {
    long cPtr = CImGuiJNI.ImGuiWindow_IDStack_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVector_ImGuiID(cPtr, false);
  }

  public void setDC(ImGuiWindowTempData value) {
    CImGuiJNI.ImGuiWindow_DC_set(swigCPtr, this, ImGuiWindowTempData.getCPtr(value), value);
  }

  public ImGuiWindowTempData getDC() {
    long cPtr = CImGuiJNI.ImGuiWindow_DC_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindowTempData(cPtr, false);
  }

  public void setOuterRectClipped(ImRect value) {
    CImGuiJNI.ImGuiWindow_OuterRectClipped_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getOuterRectClipped() {
    long cPtr = CImGuiJNI.ImGuiWindow_OuterRectClipped_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public void setInnerRect(ImRect value) {
    CImGuiJNI.ImGuiWindow_InnerRect_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getInnerRect() {
    long cPtr = CImGuiJNI.ImGuiWindow_InnerRect_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public void setInnerClipRect(ImRect value) {
    CImGuiJNI.ImGuiWindow_InnerClipRect_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getInnerClipRect() {
    long cPtr = CImGuiJNI.ImGuiWindow_InnerClipRect_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public void setWorkRect(ImRect value) {
    CImGuiJNI.ImGuiWindow_WorkRect_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getWorkRect() {
    long cPtr = CImGuiJNI.ImGuiWindow_WorkRect_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public void setClipRect(ImRect value) {
    CImGuiJNI.ImGuiWindow_ClipRect_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getClipRect() {
    long cPtr = CImGuiJNI.ImGuiWindow_ClipRect_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public void setContentRegionRect(ImRect value) {
    CImGuiJNI.ImGuiWindow_ContentRegionRect_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getContentRegionRect() {
    long cPtr = CImGuiJNI.ImGuiWindow_ContentRegionRect_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public void setHitTestHoleSize(ImVec2ih value) {
    CImGuiJNI.ImGuiWindow_HitTestHoleSize_set(swigCPtr, this, ImVec2ih.getCPtr(value), value);
  }

  public ImVec2ih getHitTestHoleSize() {
    long cPtr = CImGuiJNI.ImGuiWindow_HitTestHoleSize_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2ih(cPtr, false);
  }

  public void setHitTestHoleOffset(ImVec2ih value) {
    CImGuiJNI.ImGuiWindow_HitTestHoleOffset_set(swigCPtr, this, ImVec2ih.getCPtr(value), value);
  }

  public ImVec2ih getHitTestHoleOffset() {
    long cPtr = CImGuiJNI.ImGuiWindow_HitTestHoleOffset_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVec2ih(cPtr, false);
  }

  public void setLastFrameActive(int value) {
    CImGuiJNI.ImGuiWindow_LastFrameActive_set(swigCPtr, this, value);
  }

  public int getLastFrameActive() {
    return CImGuiJNI.ImGuiWindow_LastFrameActive_get(swigCPtr, this);
  }

  public void setLastFrameJustFocused(int value) {
    CImGuiJNI.ImGuiWindow_LastFrameJustFocused_set(swigCPtr, this, value);
  }

  public int getLastFrameJustFocused() {
    return CImGuiJNI.ImGuiWindow_LastFrameJustFocused_get(swigCPtr, this);
  }

  public void setLastTimeActive(float value) {
    CImGuiJNI.ImGuiWindow_LastTimeActive_set(swigCPtr, this, value);
  }

  public float getLastTimeActive() {
    return CImGuiJNI.ImGuiWindow_LastTimeActive_get(swigCPtr, this);
  }

  public void setItemWidthDefault(float value) {
    CImGuiJNI.ImGuiWindow_ItemWidthDefault_set(swigCPtr, this, value);
  }

  public float getItemWidthDefault() {
    return CImGuiJNI.ImGuiWindow_ItemWidthDefault_get(swigCPtr, this);
  }

  public void setStateStorage(ImGuiStorage value) {
    CImGuiJNI.ImGuiWindow_StateStorage_set(swigCPtr, this, ImGuiStorage.getCPtr(value), value);
  }

  public ImGuiStorage getStateStorage() {
    long cPtr = CImGuiJNI.ImGuiWindow_StateStorage_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiStorage(cPtr, false);
  }

  public void setColumnsStorage(ImVector_ImGuiColumns value) {
    CImGuiJNI.ImGuiWindow_ColumnsStorage_set(swigCPtr, this, ImVector_ImGuiColumns.getCPtr(value), value);
  }

  public ImVector_ImGuiColumns getColumnsStorage() {
    long cPtr = CImGuiJNI.ImGuiWindow_ColumnsStorage_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImVector_ImGuiColumns(cPtr, false);
  }

  public void setFontWindowScale(float value) {
    CImGuiJNI.ImGuiWindow_FontWindowScale_set(swigCPtr, this, value);
  }

  public float getFontWindowScale() {
    return CImGuiJNI.ImGuiWindow_FontWindowScale_get(swigCPtr, this);
  }

  public void setFontDpiScale(float value) {
    CImGuiJNI.ImGuiWindow_FontDpiScale_set(swigCPtr, this, value);
  }

  public float getFontDpiScale() {
    return CImGuiJNI.ImGuiWindow_FontDpiScale_get(swigCPtr, this);
  }

  public void setSettingsOffset(int value) {
    CImGuiJNI.ImGuiWindow_SettingsOffset_set(swigCPtr, this, value);
  }

  public int getSettingsOffset() {
    return CImGuiJNI.ImGuiWindow_SettingsOffset_get(swigCPtr, this);
  }

  public void setDrawList(ImDrawList value) {
    CImGuiJNI.ImGuiWindow_DrawList_set(swigCPtr, this, ImDrawList.getCPtr(value), value);
  }

  public ImDrawList getDrawList() {
    long cPtr = CImGuiJNI.ImGuiWindow_DrawList_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImDrawList(cPtr, false);
  }

  public void setDrawListInst(ImDrawList value) {
    CImGuiJNI.ImGuiWindow_DrawListInst_set(swigCPtr, this, ImDrawList.getCPtr(value), value);
  }

  public ImDrawList getDrawListInst() {
    long cPtr = CImGuiJNI.ImGuiWindow_DrawListInst_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImDrawList(cPtr, false);
  }

  public void setParentWindow(ImGuiWindow value) {
    CImGuiJNI.ImGuiWindow_ParentWindow_set(swigCPtr, this, ImGuiWindow.getCPtr(value), value);
  }

  public ImGuiWindow getParentWindow() {
    long cPtr = CImGuiJNI.ImGuiWindow_ParentWindow_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindow(cPtr, false);
  }

  public void setRootWindow(ImGuiWindow value) {
    CImGuiJNI.ImGuiWindow_RootWindow_set(swigCPtr, this, ImGuiWindow.getCPtr(value), value);
  }

  public ImGuiWindow getRootWindow() {
    long cPtr = CImGuiJNI.ImGuiWindow_RootWindow_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindow(cPtr, false);
  }

  public void setRootWindowDockStop(ImGuiWindow value) {
    CImGuiJNI.ImGuiWindow_RootWindowDockStop_set(swigCPtr, this, ImGuiWindow.getCPtr(value), value);
  }

  public ImGuiWindow getRootWindowDockStop() {
    long cPtr = CImGuiJNI.ImGuiWindow_RootWindowDockStop_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindow(cPtr, false);
  }

  public void setRootWindowForTitleBarHighlight(ImGuiWindow value) {
    CImGuiJNI.ImGuiWindow_RootWindowForTitleBarHighlight_set(swigCPtr, this, ImGuiWindow.getCPtr(value), value);
  }

  public ImGuiWindow getRootWindowForTitleBarHighlight() {
    long cPtr = CImGuiJNI.ImGuiWindow_RootWindowForTitleBarHighlight_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindow(cPtr, false);
  }

  public void setRootWindowForNav(ImGuiWindow value) {
    CImGuiJNI.ImGuiWindow_RootWindowForNav_set(swigCPtr, this, ImGuiWindow.getCPtr(value), value);
  }

  public ImGuiWindow getRootWindowForNav() {
    long cPtr = CImGuiJNI.ImGuiWindow_RootWindowForNav_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindow(cPtr, false);
  }

  public void setNavLastChildNavWindow(ImGuiWindow value) {
    CImGuiJNI.ImGuiWindow_NavLastChildNavWindow_set(swigCPtr, this, ImGuiWindow.getCPtr(value), value);
  }

  public ImGuiWindow getNavLastChildNavWindow() {
    long cPtr = CImGuiJNI.ImGuiWindow_NavLastChildNavWindow_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiWindow(cPtr, false);
  }

  public void setNavLastIds(SWIGTYPE_p_unsigned_int value) {
    CImGuiJNI.ImGuiWindow_NavLastIds_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_int getNavLastIds() {
    long cPtr = CImGuiJNI.ImGuiWindow_NavLastIds_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
  }

  public void setNavRectRel(ImRect value) {
    CImGuiJNI.ImGuiWindow_NavRectRel_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getNavRectRel() {
    long cPtr = CImGuiJNI.ImGuiWindow_NavRectRel_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public void setMemoryCompacted(boolean value) {
    CImGuiJNI.ImGuiWindow_MemoryCompacted_set(swigCPtr, this, value);
  }

  public boolean getMemoryCompacted() {
    return CImGuiJNI.ImGuiWindow_MemoryCompacted_get(swigCPtr, this);
  }

  public void setMemoryDrawListIdxCapacity(int value) {
    CImGuiJNI.ImGuiWindow_MemoryDrawListIdxCapacity_set(swigCPtr, this, value);
  }

  public int getMemoryDrawListIdxCapacity() {
    return CImGuiJNI.ImGuiWindow_MemoryDrawListIdxCapacity_get(swigCPtr, this);
  }

  public void setMemoryDrawListVtxCapacity(int value) {
    CImGuiJNI.ImGuiWindow_MemoryDrawListVtxCapacity_set(swigCPtr, this, value);
  }

  public int getMemoryDrawListVtxCapacity() {
    return CImGuiJNI.ImGuiWindow_MemoryDrawListVtxCapacity_get(swigCPtr, this);
  }

  public void setDockNode(ImGuiDockNode value) {
    CImGuiJNI.ImGuiWindow_DockNode_set(swigCPtr, this, ImGuiDockNode.getCPtr(value), value);
  }

  public ImGuiDockNode getDockNode() {
    long cPtr = CImGuiJNI.ImGuiWindow_DockNode_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiDockNode(cPtr, false);
  }

  public void setDockNodeAsHost(ImGuiDockNode value) {
    CImGuiJNI.ImGuiWindow_DockNodeAsHost_set(swigCPtr, this, ImGuiDockNode.getCPtr(value), value);
  }

  public ImGuiDockNode getDockNodeAsHost() {
    long cPtr = CImGuiJNI.ImGuiWindow_DockNodeAsHost_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImGuiDockNode(cPtr, false);
  }

  public void setDockId(long value) {
    CImGuiJNI.ImGuiWindow_DockId_set(swigCPtr, this, value);
  }

  public long getDockId() {
    return CImGuiJNI.ImGuiWindow_DockId_get(swigCPtr, this);
  }

  public void setDockTabItemStatusFlags(int value) {
    CImGuiJNI.ImGuiWindow_DockTabItemStatusFlags_set(swigCPtr, this, value);
  }

  public int getDockTabItemStatusFlags() {
    return CImGuiJNI.ImGuiWindow_DockTabItemStatusFlags_get(swigCPtr, this);
  }

  public void setDockTabItemRect(ImRect value) {
    CImGuiJNI.ImGuiWindow_DockTabItemRect_set(swigCPtr, this, ImRect.getCPtr(value), value);
  }

  public ImRect getDockTabItemRect() {
    long cPtr = CImGuiJNI.ImGuiWindow_DockTabItemRect_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ImRect(cPtr, false);
  }

  public void setDockOrder(short value) {
    CImGuiJNI.ImGuiWindow_DockOrder_set(swigCPtr, this, value);
  }

  public short getDockOrder() {
    return CImGuiJNI.ImGuiWindow_DockOrder_get(swigCPtr, this);
  }

  public void setDockIsActive(boolean value) {
    CImGuiJNI.ImGuiWindow_DockIsActive_set(swigCPtr, this, value);
  }

  public boolean getDockIsActive() {
    return CImGuiJNI.ImGuiWindow_DockIsActive_get(swigCPtr, this);
  }

  public void setDockTabIsVisible(boolean value) {
    CImGuiJNI.ImGuiWindow_DockTabIsVisible_set(swigCPtr, this, value);
  }

  public boolean getDockTabIsVisible() {
    return CImGuiJNI.ImGuiWindow_DockTabIsVisible_get(swigCPtr, this);
  }

  public void setDockTabWantClose(boolean value) {
    CImGuiJNI.ImGuiWindow_DockTabWantClose_set(swigCPtr, this, value);
  }

  public boolean getDockTabWantClose() {
    return CImGuiJNI.ImGuiWindow_DockTabWantClose_get(swigCPtr, this);
  }

  public ImGuiWindow() {
    this(CImGuiJNI.new_ImGuiWindow(), true);
  }

}
