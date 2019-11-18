package com.tank.netty.zeroCopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author tank
 * @create 2019/11/18 19:06
 */
public class NewIOServer {
    public static void main(String[] args) throws Exception{
        InetSocketAddress address = new InetSocketAddress(8899);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket socket = serverSocketChannel.socket();
        socket.setReuseAddress(true);
        socket.bind(address);

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);

            int readCount = 0;
            while (-1 != readCount) {
                try {
                    readCount = socketChannel.read(buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                buffer.rewind();
            }
        }
    }
}
