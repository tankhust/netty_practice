package com.tank.netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author tank
 * @create 2019/11/13 10:24
 */
public class NioTest10 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10.txt", "rw");
        FileChannel randomAccessFileChannel = randomAccessFile.getChannel();
        FileLock lock = randomAccessFileChannel.lock(3, 6, true);
        System.out.println(lock.isValid());
        System.out.println(lock.isShared());
        lock.release();
        randomAccessFile.close();

    }
}
