package com.zr.thread;

/**
 * @Author: zhourui
 * @Date: 2020-11-14 14:23
 **/
public class ThreadDemo extends Thread {

    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "好");
    }

    public static void main(String[] args) {
        new ThreadDemo("hello").run();

        new ThreadDemo("hello").start();
    }

    public void test() {
        System.out.println("test");
    }
}
