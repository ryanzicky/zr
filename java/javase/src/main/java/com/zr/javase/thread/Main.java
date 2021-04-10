package com.zr.javase.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author zhourui
 * @Date 2021/3/15 12:31
 */
public class Main {

    /*public static void main(String[] args) {
        *//*AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);
        System.out.println(atomicInteger.get());*//*

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }

        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            hashMap.put(i, i);
        }

        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer();

    }*/

    /*public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("a");
        },"thread-1");


        Thread t2 = new Thread(() -> {
            System.out.println("b");
        },"thread-2");


        Thread t3 = new Thread(() -> {
            System.out.println("c");
        },"thread-3");
        t1.start();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }*/

    /*public static void main(String[] args) {
        *//*List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }*//*

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
    }*/

    /*public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);

        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
        System.out.println(count);
    }*/

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < 100000; i++) {
            longAdder.increment();
        }
        System.out.println(longAdder);
    }
}
