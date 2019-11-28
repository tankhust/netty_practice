package com.tank.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author tank
 * @create 2019/11/28 12:49
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encoder invoked!");
        System.out.println(msg);
        System.out.println();
        System.out.println();
        out.writeLong(msg);

    }
}
