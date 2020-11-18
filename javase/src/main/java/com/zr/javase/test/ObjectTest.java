package com.zr.javase.test;

import org.openjdk.jol.info.ClassLayout;

/**
 * 查看对象头
 *
 * @Author: zhourui
 * @Date: 2020-11-18 15:15
 **/
public class ObjectTest {

    public static void main(String[] args) {
        Object obj = new Object();

        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }
}
