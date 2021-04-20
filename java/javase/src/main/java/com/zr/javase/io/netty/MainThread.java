package com.zr.javase.io.netty;

/**
 * @Author zhourui
 * @Date 2021/4/19 19:49
 */
public class MainThread {

    public static void main(String[] args) {
        // 这里不做关于IO和业务的事情
        // 1. 创建IO Thread(一个或者多个)
        SelectorThreadGroup stg = new SelectorThreadGroup(1);
        // 混杂模式，只有一个线程负责accept，每个都会被分配client，进行R/W
//        SelectorThreadGroup stg = new SelectorThreadGroup(3);

        // 2. 我应该把监听(9999) server 注册到某一个selector上
        stg.bind(9999);
    }
}
