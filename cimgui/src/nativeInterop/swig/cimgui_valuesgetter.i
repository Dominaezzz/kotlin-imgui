%ignore UserDataValuesGetter;
%ignore jvmValuesGetter;

%inline %{

#include <assert.h>

struct UserDataValuesGetter {
    JNIEnv *env;
    jobject callback;
};

static float jvmValuesGetter(void* data, int idx) {
    struct UserDataValuesGetter *userData = (UserDataValuesGetter*) data;
    JNIEnv *env = userData->env;

    // TODO: Cache these at library load.
    const jclass interfaceClass = env->FindClass("cimgui/internal/ValuesGetter");
    assert(interfaceClass);
    const jmethodID valueMethod = env->GetMethodID(interfaceClass, "getValue", "(I)F");
    assert(valueMethod);

    jfloat value = env->CallFloatMethod(userData->callback, valueMethod, (jint)idx);
    return (float) value;
}

%}

%typemap(jstype) (float(*values_getter)(void* data,int idx),void* data) "ValuesGetter";
%typemap(jtype) (float(*values_getter)(void* data,int idx),void* data) "ValuesGetter";
%typemap(jni) (float(*values_getter)(void* data,int idx),void* data) "jobject";
%typemap(javain) (float(*values_getter)(void* data,int idx),void* data) "$javainput";

%typemap(in, numinputs=1) (float(*values_getter)(void* data,int idx),void* data) (UserDataValuesGetter userData) {
    userData.env = jenv;
    userData.callback = $input;
    $1 = jvmValuesGetter;
    $2 = &userData;
}
