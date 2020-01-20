%typemap(jstype) (const char* const items[],int items_count) "String[]";
%typemap(jtype) (const char* const items[],int items_count) "String[]";
%typemap(jni) (const char* const items[],int items_count) "jobjectArray";
%typemap(javain) (const char* const items[],int items_count) "$javainput";

%typemap(in, numinputs=1) (const char* const items[],int items_count) {
    if (!$input) {
        SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "swigCPtr null");
        return $null;
    }

    $2 = JCALL1(GetArrayLength, jenv, $input);
    $1 = new char*[$2]; // Consider putting this on the stack, when small enough. 20?

    for (int i = 0; i < $2; i++) {
        jstring j_string = (jstring)JCALL2(GetObjectArrayElement, jenv, $input, i);
        const char *c_string = JCALL2(GetStringUTFChars, jenv, j_string, 0);
        $1[i] = (char*) c_string;
        JCALL1(DeleteLocalRef, jenv, j_string);
    }
}

%typemap(freearg) (const char* const items[],int items_count) {
    for (int i = 0; i < $2; i++) {
        jstring j_string = (jstring)JCALL2(GetObjectArrayElement, jenv, $input, i);
        const char *c_string = $1[i];
        JCALL2(ReleaseStringUTFChars, jenv, j_string, c_string);
        JCALL1(DeleteLocalRef, jenv, j_string);
    }
    delete[] $1;
}
