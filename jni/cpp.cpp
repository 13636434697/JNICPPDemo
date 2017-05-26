#include <jni.h>   //如果用"" 来导入头文件 系统会先到 源代码所在的文件夹去找头文件 如果找不到再到系统指定的incude文件夹下找
#include "com_xu_jnicppdemo_MainActivity.h" //用<> 直接到系统指定的include目录下去找

//c++的函数是先声明后使用
JNIEXPORT jstring JNICALL Java_com_xu_jnicppdemo_MainActivity_helloFromCPP
  (JNIEnv * env, jobject obj){
  //这里env就是结构体的别名，是一级指针了，不用加*了，只需要传一个参数，因为在调用的时候就传了this，不用在传this了
  //在调用结构体的时候，同名函数在调用结构体的函数指针的时候，把第一个参数传进去了，因为c++也是面向对象，也有this
	return env->NewStringUTF("hello from cpp");
}