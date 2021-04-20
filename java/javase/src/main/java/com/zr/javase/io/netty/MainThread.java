package com.zr.javase.io.netty;

/**
 * @Author zhourui
 * @Date 2021/4/19 19:49
 */
public class MainThread {

    public static void main(String[] args) {
        // 这里不做关于IO和业务的事情
        // 1. 创建IO Thread(一个或者多个)
        SelectorThreadGroup boss = new SelectorThreadGroup(3);
        // boss有自己的线程组
        SelectorThreadGroup worker = new SelectorThreadGroup(3);
        // worker有自己的线程组

        // 混杂模式，只有一个线程负责accept，每个都会被分配client，进行R/W
//        SelectorThreadGroup stg = new SelectorThreadGroup(3);

        // 2. 我应该把监听(9999) server 注册到某一个selector上
        boss.setWorker(worker);
        /**
         * boss里选一个线程注册listen，触发bind，从而，这个不选中的线程得持有workerGroup
         * 因为未来 listen 一旦accept得到client后得去worker中next出一个线程分配
         */

        boss.bind(9999);
        boss.bind(8888);
        boss.bind(7777);
    }
}
