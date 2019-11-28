package com.tank.netty.handler3;

import com.oracle.javafx.jmx.SGMXBean;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author tank
 * @create 2019/11/28 23:03
 */
public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String message = "sent from client!";
            int length = message.getBytes(Charset.forName("utf-8")).length;
            byte[] content = message.getBytes(Charset.forName("utf-8"));

            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setContent(content);
            personProtocol.setLength(length);

            ctx.writeAndFlush(personProtocol);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.println("客户端接受到的数据：");
        System.out.println("长度：" + length);
        System.out.println("内容：" + new String(content, Charset.forName("utf-8")));
        System.out.println("客户端端接受到的消息数量:" + ++this.count);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
