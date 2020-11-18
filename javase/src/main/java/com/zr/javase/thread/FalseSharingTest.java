package com.zr.javase.thread;

/**
 * @Author: zhourui
 * @Date: 2020-11-14 10:31
 **/
public class FalseSharingTest {

    public static void main(String[] args) throws InterruptedException {
        testPointer(new Pointer());
    }

    private static void testPointer(Pointer pointer) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.x++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.y++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(System.currentTimeMillis() - start);
    }
}

class Pointer {
    // 避免伪共享: @Contentded + jvm 参数 -XX:-RestrictContended
    // @Contentded
    volatile long x;
    // 避免伪共享：缓存行填充
    // long p1, p2, p3, p4, p5, p6, p7
    volatile long y;
}
