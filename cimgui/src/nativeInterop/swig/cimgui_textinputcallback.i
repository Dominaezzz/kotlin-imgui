%ignore UserDataInputCallback;
%ignore jvmInputCallback;

%inline %{

#include <assert.h>

struct UserDataInputCallback {
    JNIEnv *env;
    jobject callback;
};

static int jvmInputCallback(ImGuiInputTextCallbackData* data) {
    struct UserDataInputCallback *userData = (UserDataInputCallback*) data->UserData;
    JNIEnv *env = userData->env;

    // TODO: Cache these at library load.
    const jclass interfaceClass = env->FindClass("cimgui/internal/InputTextCallback");
    assert(interfaceClass);
    const jmethodID invokeMethod = env->GetMethodID(interfaceClass, "invoke", "(J)I");
    assert(invokeMethod);

    // We make sure to set this to NULL and hide it from Java code.
    data->UserData = NULL;
    int value = (int) env->CallIntMethod(userData->callback, invokeMethod, (jlong)data);
    return value;
}

%}

%typemap(jstype) (ImGuiInputTextCallback callback,void* user_data) "InputTextCallback";
%typemap(jtype) (ImGuiInputTextCallback callback,void* user_data) "InputTextCallback";
%typemap(jni) (ImGuiInputTextCallback callback,void* user_data) "jobject";
%typemap(javain) (ImGuiInputTextCallback callback,void* user_data) "$javainput";

%typemap(in, numinputs=1) (ImGuiInputTextCallback callback,void* user_data) (UserDataInputCallback userData) {
    if ($input) {
        userData.env = jenv;
        userData.callback = $input;
        $1 = jvmInputCallback;
        $2 = &userData;
    } else {
        $1 = NULL;
        $2 = NULL;
    }
}
