package com.tank.netty.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @author tank
 * @create 2019/11/10 19:26
 */
public class NioTest1 {
    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
