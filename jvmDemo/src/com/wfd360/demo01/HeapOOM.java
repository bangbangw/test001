package com.wfd360.demo01;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    /**
     * 内部类
     */
    static class OOMObject {
    }

    /**
     * 测试入口
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
       // System.out.println("-----------");
    }
}
