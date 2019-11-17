package com.tank.netty.nio;

import java.nio.ByteBuffer;

/**
 * Slice Buffer 与原Buffer共享相同的底层数组
 * @author tank
 * @create 2019/11/12 20:28
 */
public class NioTest6 {
    public static void main(String[] args) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(101);
        for (int i = 0; i < bytebuffer.capacity(); i++) {
            bytebuffer.put((byte) i);
        }
        bytebuffer.position(2);
        bytebuffer.limit(6);

        ByteBuffer slice = bytebuffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            b *= 2;
            slice.put(i, b);
        }
        bytebuffer.position(0);
        bytebuffer.limit(bytebuffer.capacity());
        while (bytebuffer.hasRemaining()) {
            System.out.println(bytebuffer.get());
        }
    }
}
