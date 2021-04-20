package com.zr.javase.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @Author zhourui
 * @Date 2021/4/13 10:28
 */
public class SocketNIO {

    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        ss.configureBlocking(false); // 重点 OS NONBLOCKING

        ss.setOption(StandardSocketOptions.TCP_NODELAY, false);

        while (true) {
            Thread.sleep(1000);
            // 接收客户端连接
            SocketChannel client = ss.accept(); // 不会阻塞？ -1 null
            // accept 调用内核了：1. 没有客户端连接进来，返回值？在BIO的时候一直卡着，但是在NIO，不卡着，返回-1，NULL
            // 如果客户端的连接，accept返回的是这个客户端的fd 5，client object
            // NONBLOCKING 就是代码能往下走了，只不过有不同的情况

            if (client == null) {
                System.out.println("null ......");
            } else {
                client.configureBlocking(false); // 重点   socket(服务端的listen socket<连接请求三次握手后，往我这里扔，我去通过accept得到连接 socket，连接socket<连接后的数据读写>)

                int port = client.socket().getPort();
                System.out.println("client...port: " + port);
                clients.add(client);
            }

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);// 可以在堆里，堆外

            // 遍历已经连接进来的客户端能不能读写数据
            for (SocketChannel c : clients) { // 串行化  多线程
                int num = c.read(buffer); // >0 -1 0 // 非阻塞
                if (num > 0) {
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);

                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() + ": " + b);
                    buffer.clear();
                }
            }
        }
    }
}
