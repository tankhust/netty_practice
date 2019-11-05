package com.tank.netty.firstExample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author tank
 * @create 2019/11/05 20:47
 */

/**
 * 2. 服务器里定义自己的Initializer
 * 3. 在Initializer里定义 自己定义的和netty提供的处理器handler codec
 * 4. 实现自定义的处理器特定的回调方法
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());
    }
}
