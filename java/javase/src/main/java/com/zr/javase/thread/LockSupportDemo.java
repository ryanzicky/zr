package com.zr.javase.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author zhourui
 * @Date 2021/3/29 14:30
 */
public class LockSupportDemo {

    /*public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread t1 = new Thread(() -> {
                if (finalI % 2 == 0) {
                    System.out.println(finalI + "   " + Thread.currentThread().getName());
                }
            }, "t1");
            t1.start();

            Thread t2 = new Thread(() -> {
                if (finalI % 2 != 0) {
                    System.out.println(finalI + "   " + Thread.currentThread().getName());
                }
            }, "t2");
            t2.start();
        }
    }*/
    static Thread t1 = new Thread(), t2 = new Thread();

    public static void main(String[] args) {
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        t1 = new Thread(() -> {
            for (String s : strings) {
                System.out.println(s);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t1.start();


        t2 = new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                System.out.println(i);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });
        t2.start();


    }
}
