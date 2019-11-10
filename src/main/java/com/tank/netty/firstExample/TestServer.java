package com.tank.netty.firstExample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty http server
 * @author tank
 * @create 2019/11/05 08:56
 */
public class TestServer {
    /**
     * 流程：
     * 1. 服务器启动
     * 2. 服务器里定义自己的Initializer
     * 3. 在Initializer里定义 自己定义的和netty提供的处理器
     * 4. 实现自定义的处理器特定的回调方法
     * 5. 回调方法被调用
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{

        EventLoopGroup bossGroup = new NioEventLoopGroup();// 接受连接的，发送给worker进行处理
        EventLoopGroup workerGroup = new NioEventLoopGroup();// 真正处理连接的

        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();//简化启动
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
