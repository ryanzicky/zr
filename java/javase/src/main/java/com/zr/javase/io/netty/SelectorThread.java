package com.zr.javase.io.netty;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author zhourui
 * @Date 2021/4/19 19:49
 */
public class SelectorThread implements Runnable {

    // 每个线程对应一个selector
    // 多线程情况下，该主机，该程序的并发客户端被分配到多个selector上
    // 注意，每个客户端，只绑定到一个selector上
    // 其实不会有交互问题

    Selector selector = null;
    LinkedBlockingQueue<Channel> lbq = new LinkedBlockingQueue<>();
    SelectorThreadGroup stg;

    SelectorThread(SelectorThreadGroup stg) {
        try {
            this.stg = stg;
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // Loop
        while (true) {
            try {

                // 1. select()
                /*阻塞 wakeup()*/
                System.out.println(Thread.currentThread().getName() + " :  before select......" + selector.keys().size());
                int nums = selector.select();
//                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " :  after select......" + selector.keys().size());
                // 2. 处理selectkeys
                if (nums > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = keys.iterator();
                    // 线程处理的过程
                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        iter.remove();

                        // 复杂，接收客户端的过程(接收之后，要注册，新的客户端，注册到哪里呢？)
                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                        } else if (key.isWritable()) {

                        }
                    }
                }
                // 3. 处理一些task
                if (!lbq.isEmpty()) { // 队列是个啥东西？堆里的对象，线程的栈是独立的，堆是共享的
                    // 只有方法的逻辑，本地变量是线程隔离的
                    Channel c = lbq.take();
                    if (c instanceof ServerSocketChannel) {
                        ServerSocketChannel server = (ServerSocketChannel) c;
                        server.register(selector, SelectionKey.OP_ACCEPT);
                    } else if (c instanceof SocketChannel) {
                        SocketChannel client = (SocketChannel) c;
                        ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
                        client.register(selector, SelectionKey.OP_READ, buffer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void readHandler(SelectionKey key) {
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel client = (SocketChannel) key.channel();
        buffer.clear();
        while (true) {
            try {
                int num = client.read(buffer);
                if (num > 0) {
                    // 将读到的内容反转，然后直接写出
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        client.write(buffer);
                    }
                    buffer.clear();
                } else if (num == 0) {
                    break;
                } else if (num < 0) {
                    // 客户端断开了
                    System.out.println("client: " + client.getRemoteAddress() + "closed......");
                    key.cancel();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void acceptHandler(SelectionKey key) {
        System.out.println("acceptHandler.....");
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        try {
            SocketChannel client = server.accept();
            client.configureBlocking(false);

            // choose a selector and register!
            stg.nextSelector(client);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
