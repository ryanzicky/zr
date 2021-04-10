package com.zr.javase.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhourui
 * @Date 2021/3/31 11:15
 */
public class ReenTrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        try {
            lock.lock();
        } finally {
            lock.unlock();
        }

    }
}
