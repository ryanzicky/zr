package com.zr.javase.io.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zhourui
 * @Date 2021/4/20 10:40
 */
public class SelectorThreadGroup {

    SelectorThread[] sts;
    ServerSocketChannel server = null;
    AtomicInteger xid = new AtomicInteger(0);

    public SelectorThreadGroup(int num) {
        // 线程数
        sts = new SelectorThread[num];
        for (int i = 0; i < num; i++) {
            sts[i] = new SelectorThread(this);

            new Thread(sts[i]).start();
        }
    }

    public void bind(int port) {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            // 注册到哪个selector上呢？
            nextSelector(server);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nextSelector(Channel c) {
        SelectorThread st = next(); // 在main线程中，取到堆里的selectorThread对象

        // 1. 通过队列传递数据，消息
        st.lbq.add(c);
        // 2. 通过打断阻塞，让对应的线程去自己在打断后完成注册selector
        st.selector.wakeup();

        // 重点：c有可能是server，有可能是client
        /*ServerSocketChannel s = (ServerSocketChannel) c;
        // 呼应上，int nums = selector.select(); // 阻塞 wakeup()
        // 会被阻塞的!!!
        try {
            s.register(st.selector, SelectionKey.OP_ACCEPT);
            st.selector.wakeup(); // 功能是让selector的select()方法，立刻返回，不阻塞!
            System.out.println("aaaaaaaaaaaaa");

        } catch (ClosedChannelException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 无论 serversocket socket 都复用这个方法
     *
     * @return
     */
    private SelectorThread next() {
        int index = xid.incrementAndGet() % sts.length;
        return sts[index];
    }

}
