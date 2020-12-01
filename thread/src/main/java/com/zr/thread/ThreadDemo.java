package com.zr.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhourui
 * @Date: 2020-11-14 14:23
 **/
public class ThreadDemo extends Thread {

    private String name;
    private static int sum = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "好");
    }

    public static void main(String[] args) throws InterruptedException {
//        new ThreadDemo("hello").run();
//
//        new ThreadDemo("hello").start();
        test();
    }

    public static void test() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    for (int j = 0; j < 10000; j++) {
                        sum++;
                    }
                } finally {
                    lock.unlock();
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(sum);
    }
}
