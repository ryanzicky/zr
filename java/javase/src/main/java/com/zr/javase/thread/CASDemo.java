package com.zr.javase.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zhourui
 * @Date 2021/3/26 20:37
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < 10000; i++) {
            atomicInteger.incrementAndGet();
        }
    }
}
