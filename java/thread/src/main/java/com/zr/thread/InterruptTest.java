package com.zr.thread;

/**
 * @Author: zhourui
 * @Date: 2020-11-19 14:00
 **/
public class InterruptTest {

    public static void main(String[] args) {
        System.out.println("begin");
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
                System.out.println(i);

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("=========");
                }

                if (i == 10) {
                    break;
                }
            }
        });

        t1.start();
        t1.interrupt();

        System.out.println("end");
    }
}
