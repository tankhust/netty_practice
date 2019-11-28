package com.tank.netty.handler2;

import com.tank.netty.handler.MyByteToLongDecoder2;
import com.tank.netty.handler.MyLongToByteEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author tank
 * @create 2019/11/07 13:40
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyClientHandler());

    }
}
