package com.wfd360.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池溢出
 * -XX:PermSize=1m -XX:MaxPermSize=2m
 * <p>
 * -XX:PermSize
 * 　　持久代（方法区）的初始内存大小。（例如：-XX:PermSize=64m）
 * -XX:MaxPermSize
 * 　　持久代（方法区）的最大内存大小。（例如：-XX:MaxPermSize=512m）
 */
public class RuntimeConstantPoolOOM {
    // private static  int i=0;
    public static void main(String[] args) {

        List<String> ss = new ArrayList<String>();
        //使用list来保持常量池引用，避免发生full GC的操作：
        int i = 0;
        while (true) {
            ss.add(String.valueOf(i++).intern());
            //其中intern（）是一个native的方法，而且是一个外部引用的方法：
        }


    }
}

