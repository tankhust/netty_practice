package com.tank.netty.zeroCopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author tank
 * @create 2019/11/18 19:11
 */
public class NewIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String fileName = "/Users/tank/Desktop/zookeeper-3.4.14.tar.gz";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);//实际传输的字节数
        System.out.println("发送字节："+ transferCount + ",耗时：" + (System.currentTimeMillis() - startTime));
        fileChannel.close();

    }
}
