package com.tank.netty.nio;

import io.netty.buffer.ByteBuf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author tank
 * @create 2019/11/12 19:57
 */
public class NioTest4 {
    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(10);
        while (true) {
            buf.clear();// 如果注释掉该段代码会怎么样呢？
            int read = inputStreamChannel.read(buf);
            if (-1 == read) {
                break;
            }
            buf.flip();
            outputStreamChannel.write(buf);
        }
        inputStreamChannel.close();
        outputStreamChannel.close();
    }
}
