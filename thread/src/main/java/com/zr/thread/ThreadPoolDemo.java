package com.zr.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhourui
 * @Date: 2020-12-03 11:19
 **/
public class ThreadPoolDemo {

    private volatile static ThreadPoolExecutor executor;

    public static ThreadPoolExecutor newThreadPool() {
        if (executor == null) {
            synchronized (ThreadPoolDemo.class) {
                if (executor == null) {
                    executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4 + 1,
                            Runtime.getRuntime().availableProcessors() * 40 + 1,
                            60L,
                            TimeUnit.MILLISECONDS,
                            new ArrayBlockingQueue<>(40), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return executor;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = newThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行!");
            });
        }
    }
}
