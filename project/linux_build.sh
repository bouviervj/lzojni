#!/bin/bash

echo "Build 64 bits version ..."
JVM_PATH=/usr/lib/jvm/java-7-openjdk-amd64

echo "Compiling 64 Bits version"
gcc -m64 -shared -fPIC -std=c99 -static-libgcc -I ../ant-build/stubs/ -I ../c_code/include/ -I $JVM_PATH/include -I $JVM_PATH/include/linux -o ../ant-build/dll/lzojni64.a ../c_code/src/org_minilzo_common_LZOjni.c ../c_code/src/minilzo.c

echo "Compiling 32 Bits version"
gcc -m32 -shared -fPIC -std=c99 -static-libgcc -I ../ant-build/stubs/ -I ../c_code/include/ -I $JVM_PATH/include -I $JVM_PATH/include/linux -o ../ant-build/dll/lzojni32.a ../c_code/src/org_minilzo_common_LZOjni.c ../c_code/src/minilzo.c

