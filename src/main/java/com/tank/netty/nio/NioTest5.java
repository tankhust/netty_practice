package com.tank.netty.nio;

import java.nio.ByteBuffer;

/**
 * @author tank
 * @create 2019/11/12 20:28
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(64);
        bytebuffer.putInt(64);
        bytebuffer.putChar('草');
        bytebuffer.putDouble(12.3324);
        bytebuffer.putChar('你');
        bytebuffer.putLong(12312341L);

        bytebuffer.flip();

        System.out.println(bytebuffer.getInt());
        System.out.println(bytebuffer.getChar());
        System.out.println(bytebuffer.getDouble());
        System.out.println(bytebuffer.getChar());
        System.out.println(bytebuffer.getLong());
    }
}
