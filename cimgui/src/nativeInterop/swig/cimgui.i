%module CImGui

%inline %{
#define CIMGUI_DEFINE_ENUMS_AND_STRUCTS
%}

%{
/* Includes the header in the wrapper code */
#include "cimgui.h"

// TODO: Look at implication of doing this... for caching jmethodid.
//
// #include "jni.h"
//
// static JavaVM *cached_jvm = 0;
//
// JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void *reserved) {
//     cached_jvm = jvm;
//     return JNI_VERSION_1_1;
// }
//
// static JNIEnv* JNU_GetEnv() {
//     JNIEnv *env;
//     jint rc = cached_jvm->GetEnv((void **)&env, JNI_VERSION_1_1);
//     if (rc == JNI_EDETACHED) throw std::runtime_error("Current thread not attached");
//     if (rc == JNI_EVERSION) throw std::runtime_error("jni version not supported");
//     return env;
// }

%}

%ignore igTextV;
%ignore igTextColoredV;
%ignore igTextDisabledV;
%ignore igTextWrappedV;
%ignore igLabelTextV;
%ignore igBulletTextV;
%ignore igTreeNodeVStr;
%ignore igTreeNodeVPtr;
%ignore igTreeNodeExVStr;
%ignore igTreeNodeExVPtr;
%ignore igSetTooltipV;
%ignore ImGuiTextBuffer_appendfv;


%include cimgui_stringarray.i
%include cimgui_valuesgetter.i
%include cimgui_itemsgetter.i
%include cimgui_customcallback.i
%include cimgui_textinputcallback.i

// This is to make sure enums are naked constants.
%include "enumtypeunsafe.swg"
%javaconst(1);

// This is to make `getCPtr` public.
SWIG_JAVABODY_PROXY(public, public, SWIGTYPE)
SWIG_JAVABODY_TYPEWRAPPER(public, public, public, SWIGTYPE)

// use default pointer handling instead of strings. i.e for igInputText
%include various.i

/* use the BYTE argout typemap to get around this. Changes in the string
 * can be seen in Java. */
%apply (char *BYTE) { (char* buf) };

%typemap(javacode) SWIGTYPE* %{
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    $javaclassname that = ($javaclassname) o;

    return swigCPtr == that.swigCPtr;
  }

  @Override
  public int hashCode() {
    return (int) (swigCPtr ^ (swigCPtr >>> 32));
  }
%}

/* Parse the header file to generate wrappers */
%include "cimgui.h"

%clear BYTE;

// use default pointer handling instead of strings. For everything.
%apply SWIGTYPE * { char* };

// Override exposing char as Java char.
%typemap(jstype) (char) "byte";
%typemap(jtype) (char) "byte";
%typemap(jni) (char) "jbyte";
%typemap(javain) (char) "$javainput";

%include "cpointer.i"
%pointer_functions(int, intp);
%pointer_functions(unsigned int, uintp);
%pointer_functions(size_t, size_tp);
%pointer_functions(bool, boolp);
%pointer_functions(float, floatp);
%pointer_functions(double, doublep);
%pointer_functions(unsigned char*, unsigned_charpp);
%pointer_functions(void*, voidp);

%include "carrays.i"
%array_functions(int, intArray);
%array_functions(float, floatArray);
%array_functions(bool, boolArray);
%array_functions(unsigned short, ushortArray);
%array_functions(ImDrawCmd, ImDrawCmdArray);
%array_functions(ImDrawList*, pImDrawListArray);
