package com.imgui

import cimgui.internal.ImDrawList_AddBezierCurve
import cimgui.internal.ImDrawList_AddCircle
import cimgui.internal.ImDrawList_AddCircleFilled
import cimgui.internal.ImDrawList_AddConvexPolyFilled
import cimgui.internal.ImDrawList_AddDrawCmd
import cimgui.internal.ImDrawList_AddImage
import cimgui.internal.ImDrawList_AddImageQuad
import cimgui.internal.ImDrawList_AddImageRounded
import cimgui.internal.ImDrawList_AddLine
import cimgui.internal.ImDrawList_AddPolyline
import cimgui.internal.ImDrawList_AddQuad
import cimgui.internal.ImDrawList_AddQuadFilled
import cimgui.internal.ImDrawList_AddRect
import cimgui.internal.ImDrawList_AddRectFilled
import cimgui.internal.ImDrawList_AddRectFilledMultiColor
import cimgui.internal.ImDrawList_AddText
import cimgui.internal.ImDrawList_AddTextFontPtr
import cimgui.internal.ImDrawList_AddTriangle
import cimgui.internal.ImDrawList_AddTriangleFilled
import cimgui.internal.ImDrawList_ChannelsMerge
import cimgui.internal.ImDrawList_ChannelsSetCurrent
import cimgui.internal.ImDrawList_ChannelsSplit
import cimgui.internal.ImDrawList_Clear
import cimgui.internal.ImDrawList_ClearFreeMemory
import cimgui.internal.ImDrawList_CloneOutput
import cimgui.internal.ImDrawList_GetClipRectMax
import cimgui.internal.ImDrawList_GetClipRectMin
import cimgui.internal.ImDrawList_ImDrawList
import cimgui.internal.ImDrawList_PathArcTo
import cimgui.internal.ImDrawList_PathArcToFast
import cimgui.internal.ImDrawList_PathBezierCurveTo
import cimgui.internal.ImDrawList_PathClear
import cimgui.internal.ImDrawList_PathFillConvex
import cimgui.internal.ImDrawList_PathLineTo
import cimgui.internal.ImDrawList_PathLineToMergeDuplicate
import cimgui.internal.ImDrawList_PathRect
import cimgui.internal.ImDrawList_PathStroke
import cimgui.internal.ImDrawList_PopClipRect
import cimgui.internal.ImDrawList_PopTextureID
import cimgui.internal.ImDrawList_PrimQuadUV
import cimgui.internal.ImDrawList_PrimRect
import cimgui.internal.ImDrawList_PrimRectUV
import cimgui.internal.ImDrawList_PrimReserve
import cimgui.internal.ImDrawList_PrimVtx
import cimgui.internal.ImDrawList_PrimWriteVtx
import cimgui.internal.ImDrawList_PushClipRect
import cimgui.internal.ImDrawList_PushClipRectFullScreen
import cimgui.internal.ImDrawList_PushTextureID
import cimgui.internal.ImDrawList_UpdateClipRect
import cimgui.internal.ImDrawList_UpdateTextureID
import cimgui.internal.ImDrawList_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImDrawList(
  val ptr: CPointer<cimgui.internal.ImDrawList>
) {
  val flags: Flag<ImDrawListFlags>
    get() = ptr.pointed.Flags.let { ImDrawListFlags.fromMultiple(it) }

  constructor(sharedData: ImDrawListSharedData) : this(ImDrawList_ImDrawList(sharedData.ptr)!!)

  fun addBezierCurve(
    pos0: Vec2,
    cp0: Vec2,
    cp1: Vec2,
    pos1: Vec2,
    col: UInt,
    thickness: Float,
    numSegments: Int = 0
  ) {
    ImDrawList_AddBezierCurve(ptr, pos0.toCValue(), cp0.toCValue(), cp1.toCValue(), pos1.toCValue(),
        col, thickness, numSegments)
  }

  fun addCircle(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int = 12,
    thickness: Float = 1.0f
  ) {
    ImDrawList_AddCircle(ptr, center.toCValue(), radius, col, numSegments, thickness)
  }

  fun addCircleFilled(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int = 12
  ) {
    ImDrawList_AddCircleFilled(ptr, center.toCValue(), radius, col, numSegments)
  }

  fun addConvexPolyFilled(
    points: ImVec2,
    numPoints: Int,
    col: UInt
  ) {
    ImDrawList_AddConvexPolyFilled(ptr, points.ptr, numPoints, col)
  }

  fun addDrawCmd() {
    ImDrawList_AddDrawCmd(ptr)
  }

  fun addImage(
    userTextureId: ImTextureID,
    pMin: Vec2,
    pMax: Vec2,
    uvMin: Vec2 = Vec2.Zero,
    uvMax: Vec2 = Vec2(1f, 1f),
    col: UInt = (255u shl 24) or (255u shl 16) or (255u shl 8) or (255u shl 0)
  ) {
    ImDrawList_AddImage(ptr, userTextureId.value, pMin.toCValue(), pMax.toCValue(),
        uvMin.toCValue(), uvMax.toCValue(), col)
  }

  fun addImageQuad(
    userTextureId: ImTextureID,
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    uv1: Vec2 = Vec2.Zero,
    uv2: Vec2 = Vec2(1f, 0f),
    uv3: Vec2 = Vec2(1f, 1f),
    uv4: Vec2 = Vec2(0f, 1f),
    col: UInt = (255u shl 24) or (255u shl 16) or (255u shl 8) or (255u shl 0)
  ) {
    ImDrawList_AddImageQuad(ptr, userTextureId.value, p1.toCValue(), p2.toCValue(), p3.toCValue(),
        p4.toCValue(), uv1.toCValue(), uv2.toCValue(), uv3.toCValue(), uv4.toCValue(), col)
  }

  fun addImageRounded(
    userTextureId: ImTextureID,
    pMin: Vec2,
    pMax: Vec2,
    uvMin: Vec2,
    uvMax: Vec2,
    col: UInt,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags> = ImDrawCornerFlags.All
  ) {
    ImDrawList_AddImageRounded(ptr, userTextureId.value, pMin.toCValue(), pMax.toCValue(),
        uvMin.toCValue(), uvMax.toCValue(), col, rounding, roundingCorners.value)
  }

  fun addLine(
    p1: Vec2,
    p2: Vec2,
    col: UInt,
    thickness: Float = 1.0f
  ) {
    ImDrawList_AddLine(ptr, p1.toCValue(), p2.toCValue(), col, thickness)
  }

  fun addPolyline(
    points: ImVec2,
    numPoints: Int,
    col: UInt,
    closed: Boolean,
    thickness: Float
  ) {
    ImDrawList_AddPolyline(ptr, points.ptr, numPoints, col, closed, thickness)
  }

  fun addQuad(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt,
    thickness: Float = 1.0f
  ) {
    ImDrawList_AddQuad(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), p4.toCValue(), col,
        thickness)
  }

  fun addQuadFilled(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt
  ) {
    ImDrawList_AddQuadFilled(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), p4.toCValue(), col)
  }

  fun addRect(
    pMin: Vec2,
    pMax: Vec2,
    col: UInt,
    rounding: Float = 0.0f,
    roundingCorners: Flag<ImDrawCornerFlags> = ImDrawCornerFlags.All,
    thickness: Float = 1.0f
  ) {
    ImDrawList_AddRect(ptr, pMin.toCValue(), pMax.toCValue(), col, rounding, roundingCorners.value,
        thickness)
  }

  fun addRectFilled(
    pMin: Vec2,
    pMax: Vec2,
    col: UInt,
    rounding: Float = 0.0f,
    roundingCorners: Flag<ImDrawCornerFlags> = ImDrawCornerFlags.All
  ) {
    ImDrawList_AddRectFilled(ptr, pMin.toCValue(), pMax.toCValue(), col, rounding,
        roundingCorners.value)
  }

  fun addRectFilledMultiColor(
    pMin: Vec2,
    pMax: Vec2,
    colUprLeft: UInt,
    colUprRight: UInt,
    colBotRight: UInt,
    colBotLeft: UInt
  ) {
    ImDrawList_AddRectFilledMultiColor(ptr, pMin.toCValue(), pMax.toCValue(), colUprLeft,
        colUprRight, colBotRight, colBotLeft)
  }

  fun addText(
    pos: Vec2,
    col: UInt,
    textBegin: String,
    textEnd: String? = null
  ) {
    ImDrawList_AddText(ptr, pos.toCValue(), col, textBegin, textEnd)
  }

  fun addText(
    font: ImFont,
    fontSize: Float,
    pos: Vec2,
    col: UInt,
    textBegin: String,
    textEnd: String? = null,
    wrapWidth: Float = 0.0f,
    cpuFineClipRect: ImVec4? = null
  ) {
    ImDrawList_AddTextFontPtr(ptr, font.ptr, fontSize, pos.toCValue(), col, textBegin, textEnd,
        wrapWidth, cpuFineClipRect?.ptr)
  }

  fun addTriangle(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    col: UInt,
    thickness: Float = 1.0f
  ) {
    ImDrawList_AddTriangle(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), col, thickness)
  }

  fun addTriangleFilled(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    col: UInt
  ) {
    ImDrawList_AddTriangleFilled(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), col)
  }

  fun channelsMerge() {
    ImDrawList_ChannelsMerge(ptr)
  }

  fun channelsSetCurrent(n: Int) {
    ImDrawList_ChannelsSetCurrent(ptr, n)
  }

  fun channelsSplit(count: Int) {
    ImDrawList_ChannelsSplit(ptr, count)
  }

  fun clear() {
    ImDrawList_Clear(ptr)
  }

  fun clearFreeMemory() {
    ImDrawList_ClearFreeMemory(ptr)
  }

  fun cloneOutput(): ImDrawList = ImDrawList_CloneOutput(ptr)!!.let(::ImDrawList)

  fun getClipRectMax(): Vec2 = ImDrawList_GetClipRectMax(ptr).fromCValue()

  fun getClipRectMin(): Vec2 = ImDrawList_GetClipRectMin(ptr).fromCValue()

  fun pathArcTo(
    center: Vec2,
    radius: Float,
    aMin: Float,
    aMax: Float,
    numSegments: Int = 10
  ) {
    ImDrawList_PathArcTo(ptr, center.toCValue(), radius, aMin, aMax, numSegments)
  }

  fun pathArcToFast(
    center: Vec2,
    radius: Float,
    aMinOf12: Int,
    aMaxOf12: Int
  ) {
    ImDrawList_PathArcToFast(ptr, center.toCValue(), radius, aMinOf12, aMaxOf12)
  }

  fun pathBezierCurveTo(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    numSegments: Int = 0
  ) {
    ImDrawList_PathBezierCurveTo(ptr, p1.toCValue(), p2.toCValue(), p3.toCValue(), numSegments)
  }

  fun pathClear() {
    ImDrawList_PathClear(ptr)
  }

  fun pathFillConvex(col: UInt) {
    ImDrawList_PathFillConvex(ptr, col)
  }

  fun pathLineTo(pos: Vec2) {
    ImDrawList_PathLineTo(ptr, pos.toCValue())
  }

  fun pathLineToMergeDuplicate(pos: Vec2) {
    ImDrawList_PathLineToMergeDuplicate(ptr, pos.toCValue())
  }

  fun pathRect(
    rectMin: Vec2,
    rectMax: Vec2,
    rounding: Float = 0.0f,
    roundingCorners: Flag<ImDrawCornerFlags> = ImDrawCornerFlags.All
  ) {
    ImDrawList_PathRect(ptr, rectMin.toCValue(), rectMax.toCValue(), rounding,
        roundingCorners.value)
  }

  fun pathStroke(
    col: UInt,
    closed: Boolean,
    thickness: Float = 1.0f
  ) {
    ImDrawList_PathStroke(ptr, col, closed, thickness)
  }

  fun popClipRect() {
    ImDrawList_PopClipRect(ptr)
  }

  fun popTextureID() {
    ImDrawList_PopTextureID(ptr)
  }

  fun primQuadUV(
    a: Vec2,
    b: Vec2,
    c: Vec2,
    d: Vec2,
    uvA: Vec2,
    uvB: Vec2,
    uvC: Vec2,
    uvD: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimQuadUV(ptr, a.toCValue(), b.toCValue(), c.toCValue(), d.toCValue(),
        uvA.toCValue(), uvB.toCValue(), uvC.toCValue(), uvD.toCValue(), col)
  }

  fun primRect(
    a: Vec2,
    b: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimRect(ptr, a.toCValue(), b.toCValue(), col)
  }

  fun primRectUV(
    a: Vec2,
    b: Vec2,
    uvA: Vec2,
    uvB: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimRectUV(ptr, a.toCValue(), b.toCValue(), uvA.toCValue(), uvB.toCValue(), col)
  }

  fun primReserve(idxCount: Int, vtxCount: Int) {
    ImDrawList_PrimReserve(ptr, idxCount, vtxCount)
  }

  fun primVtx(
    pos: Vec2,
    uv: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimVtx(ptr, pos.toCValue(), uv.toCValue(), col)
  }

  fun primWriteVtx(
    pos: Vec2,
    uv: Vec2,
    col: UInt
  ) {
    ImDrawList_PrimWriteVtx(ptr, pos.toCValue(), uv.toCValue(), col)
  }

  fun pushClipRect(
    clipRectMin: Vec2,
    clipRectMax: Vec2,
    intersectWithCurrentClipRect: Boolean = false
  ) {
    ImDrawList_PushClipRect(ptr, clipRectMin.toCValue(), clipRectMax.toCValue(),
        intersectWithCurrentClipRect)
  }

  fun pushClipRectFullScreen() {
    ImDrawList_PushClipRectFullScreen(ptr)
  }

  fun pushTextureID(textureId: ImTextureID) {
    ImDrawList_PushTextureID(ptr, textureId.value)
  }

  fun updateClipRect() {
    ImDrawList_UpdateClipRect(ptr)
  }

  fun updateTextureID() {
    ImDrawList_UpdateTextureID(ptr)
  }

  fun destroy() {
    ImDrawList_destroy(ptr)
  }
}
