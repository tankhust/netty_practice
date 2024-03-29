package com.tank.netty.nio;


import java.nio.ByteBuffer;

/**
 * 只读buffer,可以随时将一个普通buffer通过asReadOnlyBuffer转换为一个只读的buffer
 * 而不能将只读的buffer转换为一个普通buffer
 * @author tank
 * @create 2019/11/12 20:28
 */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.getClass());
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        readOnlyBuffer.position(0);
        readOnlyBuffer.put((byte) 2);
    }
}
