package com.tank.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author tank
 * @create 2019/11/12 19:57
 */
public class NioTest8 {
    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream("input2.txt");
        FileOutputStream outputStream = new FileOutputStream("output2.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();
        ByteBuffer buf = ByteBuffer.allocateDirect(512);
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
