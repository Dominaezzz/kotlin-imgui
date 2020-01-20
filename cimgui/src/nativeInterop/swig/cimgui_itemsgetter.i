%ignore UserDataItemsGetter;
%ignore jvmItemsGetter;

%inline %{

#include <assert.h>

struct UserDataItemsGetter {
    JNIEnv *env;
    jobject callback;
    jstring item;
    const char* item_cstr;
};

static bool jvmItemsGetter(void* data, int idx, const char** out_text) {
    UserDataItemsGetter *userData = (UserDataItemsGetter*) data;
    JNIEnv *env = userData->env;

    // TODO: Cache these at library load.
    const jclass interfaceClass = env->FindClass("cimgui/internal/ItemsGetter");
    assert(interfaceClass);
    const jmethodID itemMethod = env->GetMethodID(interfaceClass, "getItem", "(I)Ljava/lang/String;");
    assert(itemMethod);

    // Need to free the results of the previous call to this function.
    if (userData->item_cstr != NULL) {
        env->ReleaseStringUTFChars(userData->item, userData->item_cstr);
        env->DeleteLocalRef(userData->item);
        userData->item = NULL;
        userData->item_cstr = NULL;
    }

    jstring value = (jstring) env->CallObjectMethod(userData->callback, itemMethod, (jint)idx);
    if (value != NULL) {
        const char* c_string = env->GetStringUTFChars(value, 0);
        assert(c_string);
        *out_text = c_string;

        // Remember these so we can free them in the next call.
        userData->item = value;
        userData->item_cstr = c_string;
        return true;
    } else {
        return false;
    }
}

%}

%typemap(jstype) (bool(*items_getter)(void* data,int idx,const char** out_text),void* data) "ItemsGetter";
%typemap(jtype) (bool(*items_getter)(void* data,int idx,const char** out_text),void* data) "ItemsGetter";
%typemap(jni) (bool(*items_getter)(void* data,int idx,const char** out_text),void* data) "jobject";
%typemap(javain) (bool(*items_getter)(void* data,int idx,const char** out_text),void* data) "$javainput";

%typemap(in, numinputs=1) (bool(*items_getter)(void* data,int idx,const char** out_text),void* data) (UserDataItemsGetter userData) {
    userData.env = jenv;
    userData.callback = $input;
    userData.item = NULL;
    userData.item_cstr = NULL;
    $1 = jvmItemsGetter;
    $2 = &userData;
}

%typemap(freearg) (bool(*items_getter)(void* data,int idx,const char** out_text),void* data) {
    UserDataItemsGetter *userData = (UserDataItemsGetter*) $2; // TODO: Eliminate need for this line.
    if (userData->item_cstr != NULL) {
        JCALL2(ReleaseStringUTFChars, jenv, userData->item, userData->item_cstr);
        JCALL1(DeleteLocalRef, jenv, userData->item);
    }
}
