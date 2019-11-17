package com.tank.netty.nio;


import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author tank
 * @create 2019/11/11 21:38
 */
public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("NioTest.txt");
        FileChannel channel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);

        byteBuffer.flip();
        byteBuffer.clear();

        while (byteBuffer.remaining() > 0) {
            byte b = byteBuffer.get();
            System.out.println("Character: " + (char) b);
        }

        inputStream.close();
    }
}
