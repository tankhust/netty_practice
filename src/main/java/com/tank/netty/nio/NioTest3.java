package com.tank.netty.nio;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author tank
 * @create 2019/11/11 21:38
 */
public class NioTest3 {
    public static void main(String[] args) throws Exception {
        FileOutputStream outputStream = new FileOutputStream("NioTest3.txt");
        FileChannel channel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] bytes = "hello world tank".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byteBuffer.put(bytes[i]);
        }

        byteBuffer.flip();

        channel.write(byteBuffer);

        outputStream.close();
    }
}
