package com.zr.javase.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author zhourui
 * @Date 2021/3/27 10:54
 */
public class ThreadLocalDemo {

    static ThreadLocal<Integer> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread((() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        })).start();

        new Thread((() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(1);
        })).start();
    }
}
