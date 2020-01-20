%ignore UserDataCustomCallback;
%ignore jvmCustomCallback;

%inline %{

#include <assert.h>

struct UserDataCustomCallback {
    JNIEnv *env;
    jobject callback;
};

static void jvmCustomCallback(ImGuiSizeCallbackData* data) {
    struct UserDataCustomCallback *userData = (UserDataCustomCallback*) data->UserData;
    JNIEnv *env = userData->env;

    // TODO: Cache these at library load.
    const jclass interfaceClass = env->FindClass("cimgui/internal/CustomCallback");
    assert(interfaceClass);
    const jmethodID invokeMethod = env->GetMethodID(interfaceClass, "invoke", "(J)");
    assert(invokeMethod);

    // We make sure to set this to NULL and hide it from Java code.
    data->UserData = NULL;
    env->CallVoidMethod(userData->callback, invokeMethod, (jlong)data);

    // FIXME: What if callback is not called. i.e user does not call `ImGui.begin(...)`.
    env->DeleteGlobalRef(userData->callback);
}

%}

%typemap(jstype) (ImGuiSizeCallback custom_callback,void* custom_callback_data) "CustomCallback";
%typemap(jtype) (ImGuiSizeCallback custom_callback,void* custom_callback_data) "CustomCallback";
%typemap(jni) (ImGuiSizeCallback custom_callback,void* custom_callback_data) "jobject";
%typemap(javain) (ImGuiSizeCallback custom_callback,void* custom_callback_data) "$javainput";

%typemap(in, numinputs=1) (ImGuiSizeCallback custom_callback,void* custom_callback_data) (UserDataCustomCallback userData) {
    if ($input) {
        userData.env = jenv;
        userData.callback = JCALL1(NewGlobalRef, jenv, $input);
        $1 = jvmCustomCallback;
        $2 = &userData;
    } else {
        $1 = NULL;
        $2 = NULL;
    }
}
