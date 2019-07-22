package com.wfd360.demo01;
/**
 * @Copyright (C)
 * @Author: 姿势帝
 * @Date: 2019-07-15 17:17
 * @Description: 栈内存溢出测试
 * <p>
 * 测试代码设计思路
 * 通过不断地建立线程的方式倒是可以产生内存溢出异常
 * jvm参数
 * -Xss 180k:设置每个线程的堆栈大小(最小180k),默认是1M
 * 特别注意：
 * 特别提示一下，如果读者要尝试运行上面这段代码，记得要先保存当前的工作。
 * 由于在Windows平台的虚拟机中，Java的线程是映射到操作系统的内核线程上的，
 * 因此上述代码执行时有较大的风险，可能会导致操作系统假死。
 * </p>
 */
public class JavaVMStackOOM {
    //统计线程数
    private static int threadNum;
    //让线程不停止
    private void dontStop() {
        while (true) {
        }
    }
    //不停的开启线下，指导抛出异常
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            threadNum++;
            thread.start();
        }
    }

    /**
     * 测试方法入口
     * @param args
     */
    public static void main(String[] args)  {
        try {
            JavaVMStackOOM oom = new JavaVMStackOOM();
            oom.stackLeakByThread();
        }catch (Throwable e){
            System.out.println("threadNum=" + JavaVMStackOOM.threadNum);
            e.printStackTrace();
        }
    }
}
