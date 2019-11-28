package com.tank.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author tank
 * @create 2019/11/23 19:51
 */
public class ByteBufTest0 {
    public static void main(String[] args) {
        ByteBuf bytebuf = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            bytebuf.writeByte(i);
        }

//        for (int i = 0; i < ByteBufTest0.capacity(); i++) {
//            System.out.println(ByteBufTest0.getByte(i));
//        }// 绝对方法

        for (int i = 0; i < bytebuf.capacity(); i++) {
            System.out.println(bytebuf.readByte());
        }// 相对方法
    }
}
