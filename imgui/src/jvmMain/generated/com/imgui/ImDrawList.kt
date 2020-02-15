package com.imgui

import cimgui.internal.CImGui.ImDrawList_AddBezierCurve
import cimgui.internal.CImGui.ImDrawList_AddCircle
import cimgui.internal.CImGui.ImDrawList_AddCircleFilled
import cimgui.internal.CImGui.ImDrawList_AddConvexPolyFilled
import cimgui.internal.CImGui.ImDrawList_AddDrawCmd
import cimgui.internal.CImGui.ImDrawList_AddImage
import cimgui.internal.CImGui.ImDrawList_AddImageQuad
import cimgui.internal.CImGui.ImDrawList_AddImageRounded
import cimgui.internal.CImGui.ImDrawList_AddLine
import cimgui.internal.CImGui.ImDrawList_AddNgon
import cimgui.internal.CImGui.ImDrawList_AddNgonFilled
import cimgui.internal.CImGui.ImDrawList_AddPolyline
import cimgui.internal.CImGui.ImDrawList_AddQuad
import cimgui.internal.CImGui.ImDrawList_AddQuadFilled
import cimgui.internal.CImGui.ImDrawList_AddRect
import cimgui.internal.CImGui.ImDrawList_AddRectFilled
import cimgui.internal.CImGui.ImDrawList_AddRectFilledMultiColor
import cimgui.internal.CImGui.ImDrawList_AddText
import cimgui.internal.CImGui.ImDrawList_AddTextFontPtr
import cimgui.internal.CImGui.ImDrawList_AddTriangle
import cimgui.internal.CImGui.ImDrawList_AddTriangleFilled
import cimgui.internal.CImGui.ImDrawList_ChannelsMerge
import cimgui.internal.CImGui.ImDrawList_ChannelsSetCurrent
import cimgui.internal.CImGui.ImDrawList_ChannelsSplit
import cimgui.internal.CImGui.ImDrawList_Clear
import cimgui.internal.CImGui.ImDrawList_ClearFreeMemory
import cimgui.internal.CImGui.ImDrawList_CloneOutput
import cimgui.internal.CImGui.ImDrawList_GetClipRectMax_nonUDT
import cimgui.internal.CImGui.ImDrawList_GetClipRectMin_nonUDT
import cimgui.internal.CImGui.ImDrawList_ImDrawList
import cimgui.internal.CImGui.ImDrawList_PathArcTo
import cimgui.internal.CImGui.ImDrawList_PathArcToFast
import cimgui.internal.CImGui.ImDrawList_PathBezierCurveTo
import cimgui.internal.CImGui.ImDrawList_PathClear
import cimgui.internal.CImGui.ImDrawList_PathFillConvex
import cimgui.internal.CImGui.ImDrawList_PathLineTo
import cimgui.internal.CImGui.ImDrawList_PathLineToMergeDuplicate
import cimgui.internal.CImGui.ImDrawList_PathRect
import cimgui.internal.CImGui.ImDrawList_PathStroke
import cimgui.internal.CImGui.ImDrawList_PopClipRect
import cimgui.internal.CImGui.ImDrawList_PopTextureID
import cimgui.internal.CImGui.ImDrawList_PrimQuadUV
import cimgui.internal.CImGui.ImDrawList_PrimRect
import cimgui.internal.CImGui.ImDrawList_PrimRectUV
import cimgui.internal.CImGui.ImDrawList_PrimReserve
import cimgui.internal.CImGui.ImDrawList_PrimUnreserve
import cimgui.internal.CImGui.ImDrawList_PrimVtx
import cimgui.internal.CImGui.ImDrawList_PrimWriteVtx
import cimgui.internal.CImGui.ImDrawList_PushClipRect
import cimgui.internal.CImGui.ImDrawList_PushClipRectFullScreen
import cimgui.internal.CImGui.ImDrawList_PushTextureID
import cimgui.internal.CImGui.ImDrawList_UpdateClipRect
import cimgui.internal.CImGui.ImDrawList_UpdateTextureID
import cimgui.internal.CImGui.ImDrawList_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawList(
  val ptr: cimgui.internal.ImDrawList
) {
  actual val flags: Flag<ImDrawListFlags>
    get() = ptr.flags.let { ImDrawListFlags.fromMultiple(it) }

  actual constructor(sharedData: ImDrawListSharedData) :
      this(ImDrawList_ImDrawList(sharedData.ptr)!!)

  actual fun addBezierCurve(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt,
    thickness: Float,
    numSegments: Int
  ) {
    usingVec2 { ptrP1 -> 
      usingVec2 { ptrP2 -> 
        usingVec2 { ptrP3 -> 
          usingVec2 { ptrP4 -> 
            ImDrawList_AddBezierCurve(ptr, ptrP1, ptrP2, ptrP3, ptrP4, col.toLong(), thickness,
                numSegments)
          }
        }
      }
    }
  }

  actual fun addCircle(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int,
    thickness: Float
  ) {
    usingVec2 { ptrCenter -> 
      ImDrawList_AddCircle(ptr, ptrCenter, radius, col.toLong(), numSegments, thickness)
    }
  }

  actual fun addCircleFilled(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int
  ) {
    usingVec2 { ptrCenter -> 
      ImDrawList_AddCircleFilled(ptr, ptrCenter, radius, col.toLong(), numSegments)
    }
  }

  actual fun addConvexPolyFilled(
    points: ImVec2,
    numPoints: Int,
    col: UInt
  ) {
    ImDrawList_AddConvexPolyFilled(ptr, points.ptr, numPoints, col.toLong())
  }

  actual fun addDrawCmd() {
    ImDrawList_AddDrawCmd(ptr)
  }

  actual fun addImage(
    userTextureId: ImTextureID,
    pMin: Vec2,
    pMax: Vec2,
    uvMin: Vec2,
    uvMax: Vec2,
    col: UInt
  ) {
    usingVec2 { ptrPMin -> 
      usingVec2 { ptrPMax -> 
        usingVec2 { ptrUvMin -> 
          usingVec2 { ptrUvMax -> 
            ImDrawList_AddImage(ptr, userTextureId.value, ptrPMin, ptrPMax, ptrUvMin, ptrUvMax,
                col.toLong())
          }
        }
      }
    }
  }

  actual fun addImageQuad(
    userTextureId: ImTextureID,
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    uv1: Vec2,
    uv2: Vec2,
    uv3: Vec2,
    uv4: Vec2,
    col: UInt
  ) {
    usingVec2 { ptrP1 -> 
      usingVec2 { ptrP2 -> 
        usingVec2 { ptrP3 -> 
          usingVec2 { ptrP4 -> 
            usingVec2 { ptrUv1 -> 
              usingVec2 { ptrUv2 -> 
                usingVec2 { ptrUv3 -> 
                  usingVec2 { ptrUv4 -> 
                    ImDrawList_AddImageQuad(ptr, userTextureId.value, ptrP1, ptrP2, ptrP3, ptrP4,
                        ptrUv1, ptrUv2, ptrUv3, ptrUv4, col.toLong())
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  actual fun addImageRounded(
    userTextureId: ImTextureID,
    pMin: Vec2,
    pMax: Vec2,
    uvMin: Vec2,
    uvMax: Vec2,
    col: UInt,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags>
  ) {
    usingVec2 { ptrPMin -> 
      usingVec2 { ptrPMax -> 
        usingVec2 { ptrUvMin -> 
          usingVec2 { ptrUvMax -> 
            ImDrawList_AddImageRounded(ptr, userTextureId.value, ptrPMin, ptrPMax, ptrUvMin,
                ptrUvMax, col.toLong(), rounding, roundingCorners.value)
          }
        }
      }
    }
  }

  actual fun addLine(
    p1: Vec2,
    p2: Vec2,
    col: UInt,
    thickness: Float
  ) {
    usingVec2 { ptrP1 -> 
      usingVec2 { ptrP2 -> 
        ImDrawList_AddLine(ptr, ptrP1, ptrP2, col.toLong(), thickness)
      }
    }
  }

  actual fun addNgon(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int,
    thickness: Float
  ) {
    usingVec2 { ptrCenter -> 
      ImDrawList_AddNgon(ptr, ptrCenter, radius, col.toLong(), numSegments, thickness)
    }
  }

  actual fun addNgonFilled(
    center: Vec2,
    radius: Float,
    col: UInt,
    numSegments: Int
  ) {
    usingVec2 { ptrCenter -> 
      ImDrawList_AddNgonFilled(ptr, ptrCenter, radius, col.toLong(), numSegments)
    }
  }

  actual fun addPolyline(
    points: ImVec2,
    numPoints: Int,
    col: UInt,
    closed: Boolean,
    thickness: Float
  ) {
    ImDrawList_AddPolyline(ptr, points.ptr, numPoints, col.toLong(), closed, thickness)
  }

  actual fun addQuad(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt,
    thickness: Float
  ) {
    usingVec2 { ptrP1 -> 
      usingVec2 { ptrP2 -> 
        usingVec2 { ptrP3 -> 
          usingVec2 { ptrP4 -> 
            ImDrawList_AddQuad(ptr, ptrP1, ptrP2, ptrP3, ptrP4, col.toLong(), thickness)
          }
        }
      }
    }
  }

  actual fun addQuadFilled(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    col: UInt
  ) {
    usingVec2 { ptrP1 -> 
      usingVec2 { ptrP2 -> 
        usingVec2 { ptrP3 -> 
          usingVec2 { ptrP4 -> 
            ImDrawList_AddQuadFilled(ptr, ptrP1, ptrP2, ptrP3, ptrP4, col.toLong())
          }
        }
      }
    }
  }

  actual fun addRect(
    pMin: Vec2,
    pMax: Vec2,
    col: UInt,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags>,
    thickness: Float
  ) {
    usingVec2 { ptrPMin -> 
      usingVec2 { ptrPMax -> 
        ImDrawList_AddRect(ptr, ptrPMin, ptrPMax, col.toLong(), rounding, roundingCorners.value,
            thickness)
      }
    }
  }

  actual fun addRectFilled(
    pMin: Vec2,
    pMax: Vec2,
    col: UInt,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags>
  ) {
    usingVec2 { ptrPMin -> 
      usingVec2 { ptrPMax -> 
        ImDrawList_AddRectFilled(ptr, ptrPMin, ptrPMax, col.toLong(), rounding,
            roundingCorners.value)
      }
    }
  }

  actual fun addRectFilledMultiColor(
    pMin: Vec2,
    pMax: Vec2,
    colUprLeft: UInt,
    colUprRight: UInt,
    colBotRight: UInt,
    colBotLeft: UInt
  ) {
    usingVec2 { ptrPMin -> 
      usingVec2 { ptrPMax -> 
        ImDrawList_AddRectFilledMultiColor(ptr, ptrPMin, ptrPMax, colUprLeft.toLong(),
            colUprRight.toLong(), colBotRight.toLong(), colBotLeft.toLong())
      }
    }
  }

  actual fun addText(
    pos: Vec2,
    col: UInt,
    textBegin: String,
    textEnd: String?
  ) {
    usingVec2 { ptrPos -> 
      ImDrawList_AddText(ptr, ptrPos, col.toLong(), textBegin, textEnd)
    }
  }

  actual fun addText(
    font: ImFont,
    fontSize: Float,
    pos: Vec2,
    col: UInt,
    textBegin: String,
    textEnd: String?,
    wrapWidth: Float,
    cpuFineClipRect: ImVec4?
  ) {
    usingVec2 { ptrPos -> 
      ImDrawList_AddTextFontPtr(ptr, font.ptr, fontSize, ptrPos, col.toLong(), textBegin, textEnd,
          wrapWidth, cpuFineClipRect?.ptr)
    }
  }

  actual fun addTriangle(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    col: UInt,
    thickness: Float
  ) {
    usingVec2 { ptrP1 -> 
      usingVec2 { ptrP2 -> 
        usingVec2 { ptrP3 -> 
          ImDrawList_AddTriangle(ptr, ptrP1, ptrP2, ptrP3, col.toLong(), thickness)
        }
      }
    }
  }

  actual fun addTriangleFilled(
    p1: Vec2,
    p2: Vec2,
    p3: Vec2,
    col: UInt
  ) {
    usingVec2 { ptrP1 -> 
      usingVec2 { ptrP2 -> 
        usingVec2 { ptrP3 -> 
          ImDrawList_AddTriangleFilled(ptr, ptrP1, ptrP2, ptrP3, col.toLong())
        }
      }
    }
  }

  actual fun channelsMerge() {
    ImDrawList_ChannelsMerge(ptr)
  }

  actual fun channelsSetCurrent(n: Int) {
    ImDrawList_ChannelsSetCurrent(ptr, n)
  }

  actual fun channelsSplit(count: Int) {
    ImDrawList_ChannelsSplit(ptr, count)
  }

  actual fun clear() {
    ImDrawList_Clear(ptr)
  }

  actual fun clearFreeMemory() {
    ImDrawList_ClearFreeMemory(ptr)
  }

  actual fun cloneOutput(): ImDrawList = ImDrawList_CloneOutput(ptr)!!.let(::ImDrawList)

  actual fun getClipRectMax(): Vec2 = returnVec2 { returnVal ->
    ImDrawList_GetClipRectMax_nonUDT(returnVal, ptr)
  }

  actual fun getClipRectMin(): Vec2 = returnVec2 { returnVal ->
    ImDrawList_GetClipRectMin_nonUDT(returnVal, ptr)
  }

  actual fun pathArcTo(
    center: Vec2,
    radius: Float,
    aMin: Float,
    aMax: Float,
    numSegments: Int
  ) {
    usingVec2 { ptrCenter -> 
      ImDrawList_PathArcTo(ptr, ptrCenter, radius, aMin, aMax, numSegments)
    }
  }

  actual fun pathArcToFast(
    center: Vec2,
    radius: Float,
    aMinOf12: Int,
    aMaxOf12: Int
  ) {
    usingVec2 { ptrCenter -> 
      ImDrawList_PathArcToFast(ptr, ptrCenter, radius, aMinOf12, aMaxOf12)
    }
  }

  actual fun pathBezierCurveTo(
    p2: Vec2,
    p3: Vec2,
    p4: Vec2,
    numSegments: Int
  ) {
    usingVec2 { ptrP2 -> 
      usingVec2 { ptrP3 -> 
        usingVec2 { ptrP4 -> 
          ImDrawList_PathBezierCurveTo(ptr, ptrP2, ptrP3, ptrP4, numSegments)
        }
      }
    }
  }

  actual fun pathClear() {
    ImDrawList_PathClear(ptr)
  }

  actual fun pathFillConvex(col: UInt) {
    ImDrawList_PathFillConvex(ptr, col.toLong())
  }

  actual fun pathLineTo(pos: Vec2) {
    usingVec2 { ptrPos -> 
      ImDrawList_PathLineTo(ptr, ptrPos)
    }
  }

  actual fun pathLineToMergeDuplicate(pos: Vec2) {
    usingVec2 { ptrPos -> 
      ImDrawList_PathLineToMergeDuplicate(ptr, ptrPos)
    }
  }

  actual fun pathRect(
    rectMin: Vec2,
    rectMax: Vec2,
    rounding: Float,
    roundingCorners: Flag<ImDrawCornerFlags>
  ) {
    usingVec2 { ptrRectMin -> 
      usingVec2 { ptrRectMax -> 
        ImDrawList_PathRect(ptr, ptrRectMin, ptrRectMax, rounding, roundingCorners.value)
      }
    }
  }

  actual fun pathStroke(
    col: UInt,
    closed: Boolean,
    thickness: Float
  ) {
    ImDrawList_PathStroke(ptr, col.toLong(), closed, thickness)
  }

  actual fun popClipRect() {
    ImDrawList_PopClipRect(ptr)
  }

  actual fun popTextureID() {
    ImDrawList_PopTextureID(ptr)
  }

  actual fun primQuadUV(
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
    usingVec2 { ptrA -> 
      usingVec2 { ptrB -> 
        usingVec2 { ptrC -> 
          usingVec2 { ptrD -> 
            usingVec2 { ptrUvA -> 
              usingVec2 { ptrUvB -> 
                usingVec2 { ptrUvC -> 
                  usingVec2 { ptrUvD -> 
                    ImDrawList_PrimQuadUV(ptr, ptrA, ptrB, ptrC, ptrD, ptrUvA, ptrUvB, ptrUvC,
                        ptrUvD, col.toLong())
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  actual fun primRect(
    a: Vec2,
    b: Vec2,
    col: UInt
  ) {
    usingVec2 { ptrA -> 
      usingVec2 { ptrB -> 
        ImDrawList_PrimRect(ptr, ptrA, ptrB, col.toLong())
      }
    }
  }

  actual fun primRectUV(
    a: Vec2,
    b: Vec2,
    uvA: Vec2,
    uvB: Vec2,
    col: UInt
  ) {
    usingVec2 { ptrA -> 
      usingVec2 { ptrB -> 
        usingVec2 { ptrUvA -> 
          usingVec2 { ptrUvB -> 
            ImDrawList_PrimRectUV(ptr, ptrA, ptrB, ptrUvA, ptrUvB, col.toLong())
          }
        }
      }
    }
  }

  actual fun primReserve(idxCount: Int, vtxCount: Int) {
    ImDrawList_PrimReserve(ptr, idxCount, vtxCount)
  }

  actual fun primUnreserve(idxCount: Int, vtxCount: Int) {
    ImDrawList_PrimUnreserve(ptr, idxCount, vtxCount)
  }

  actual fun primVtx(
    pos: Vec2,
    uv: Vec2,
    col: UInt
  ) {
    usingVec2 { ptrPos -> 
      usingVec2 { ptrUv -> 
        ImDrawList_PrimVtx(ptr, ptrPos, ptrUv, col.toLong())
      }
    }
  }

  actual fun primWriteVtx(
    pos: Vec2,
    uv: Vec2,
    col: UInt
  ) {
    usingVec2 { ptrPos -> 
      usingVec2 { ptrUv -> 
        ImDrawList_PrimWriteVtx(ptr, ptrPos, ptrUv, col.toLong())
      }
    }
  }

  actual fun pushClipRect(
    clipRectMin: Vec2,
    clipRectMax: Vec2,
    intersectWithCurrentClipRect: Boolean
  ) {
    usingVec2 { ptrClipRectMin -> 
      usingVec2 { ptrClipRectMax -> 
        ImDrawList_PushClipRect(ptr, ptrClipRectMin, ptrClipRectMax, intersectWithCurrentClipRect)
      }
    }
  }

  actual fun pushClipRectFullScreen() {
    ImDrawList_PushClipRectFullScreen(ptr)
  }

  actual fun pushTextureID(textureId: ImTextureID) {
    ImDrawList_PushTextureID(ptr, textureId.value)
  }

  actual fun updateClipRect() {
    ImDrawList_UpdateClipRect(ptr)
  }

  actual fun updateTextureID() {
    ImDrawList_UpdateTextureID(ptr)
  }

  actual fun destroy() {
    ImDrawList_destroy(ptr)
  }
}
