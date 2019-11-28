package com.tank.netty.test;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

/**
 * @author tank
 * @create 2019/11/18 20:24
 */
public class test {
    public static void main(String[] args) {
        int res = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        System.out.println(NettyRuntime.availableProcessors());
    }
}
