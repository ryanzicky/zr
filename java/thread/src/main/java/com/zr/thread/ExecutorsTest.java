package com.zr.thread;

import java.util.concurrent.*;

/**
 * @Author: zhourui
 * @Date: 2020-11-14 15:48
 **/
public class ExecutorsTest {

    // 阻塞队列有界 OOM
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
    // 耗费CPU和内存
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    // 阻塞队列有界 OOM
    private static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    // 第31个线程报拒绝异常
    // 提交顺序 1. 核心线程 2. 阻塞队列 3. 非核心线程
    // 执行顺序 1. 核心线程 2. 非核心线程 3. 阻塞队列
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            fixedThreadPool.execute(new MyTask(i));
            threadPoolExecutor.execute(new MyTask(i));
        }
    }
}

class MyTask implements Runnable {
    private int i;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
