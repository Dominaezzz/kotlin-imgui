/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cimgui.internal;

public class StbUndoRecord {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public StbUndoRecord(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(StbUndoRecord obj) {
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
        CImGuiJNI.delete_StbUndoRecord(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setWhere(int value) {
    CImGuiJNI.StbUndoRecord_where_set(swigCPtr, this, value);
  }

  public int getWhere() {
    return CImGuiJNI.StbUndoRecord_where_get(swigCPtr, this);
  }

  public void setInsert_length(int value) {
    CImGuiJNI.StbUndoRecord_insert_length_set(swigCPtr, this, value);
  }

  public int getInsert_length() {
    return CImGuiJNI.StbUndoRecord_insert_length_get(swigCPtr, this);
  }

  public void setDelete_length(int value) {
    CImGuiJNI.StbUndoRecord_delete_length_set(swigCPtr, this, value);
  }

  public int getDelete_length() {
    return CImGuiJNI.StbUndoRecord_delete_length_get(swigCPtr, this);
  }

  public void setChar_storage(int value) {
    CImGuiJNI.StbUndoRecord_char_storage_set(swigCPtr, this, value);
  }

  public int getChar_storage() {
    return CImGuiJNI.StbUndoRecord_char_storage_get(swigCPtr, this);
  }

  public StbUndoRecord() {
    this(CImGuiJNI.new_StbUndoRecord(), true);
  }

}
