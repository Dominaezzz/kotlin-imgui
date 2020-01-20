#!/usr/bin/env bash

# Should be run in this file's folder.

PROJECT_DIR='../../..'
CIMGUI_OUTPUT_DIR="${PROJECT_DIR}/build/downloads/cimgui-1.74/generator/output/"
JAVA_OUTPUT_DIR="${PROJECT_DIR}/src/jvmMain/java/cimgui/internal"
CPP_OUTPUT_DIR="${PROJECT_DIR}/src/jvmMain/cpp"

mkdir -p ${JAVA_OUTPUT_DIR} ${CPP_OUTPUT_DIR}
rm ${JAVA_OUTPUT_DIR}/*.java
swig -java -c++ -package cimgui.internal -outdir ${JAVA_OUTPUT_DIR} -o "${CPP_OUTPUT_DIR}/wrap.cpp" -I${CIMGUI_OUTPUT_DIR} -DCIMGUI_DEFINE_ENUMS_AND_STRUCTS cimgui.i
