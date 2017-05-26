package com.xu.jnicppdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
/*
* C++也是可以开发JNI的
*
* ## c++ 开发JNI
* C的预处理命令
* #开头的就是c/c++的预处理命令
* 在编译之前 先会走预编译阶段 预编译阶段的作用就是 把 include进来的头文件 copy到源文件中
* define这些宏定义 用真实的值替换一下
* #if #else #endif 该删除的删除掉
*
* c++开发jni代码时 env不再是结构体Jninativeinterface的二级指针
* _JNIEnv JNIEnv  _JNIEnv 是C++的结构体 C++结构体跟C区别 C++的结构体可以定义函数
* env 是JNIEnv的一级指针 也就是结构体_JNIEnv的一级指针 env-> 来调用 结构体里的函数
* _JNIEnv的函数 实际上调用的就是结构体JNINativeInterface的同名函数指针
* 在调用时第一个参数 env已经传进去了

* C++的函数要先声明再使用 可以把javah生成的头文件include进来作为函数的声明
* include的方法 <> "" ""
* 如果用"" 来导入头文件 系统会先到 源代码所在的文件夹去找头文件 如果找不到再到系统指定的incude文件夹下找
* //用<> 直接到系统指定的include目录下去找

* */
public class MainActivity extends AppCompatActivity {

    static{
        System.loadLibrary("cpp");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v){
        Toast.makeText(getApplicationContext(), helloFromCPP(), Toast.LENGTH_SHORT).show();
    }

    public native String helloFromCPP();
}
