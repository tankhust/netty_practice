package com.tank.netty.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author tank
 * @create 2019/11/17 19:51
 */
public class NioTest13 {
    public static void main(String[] args) throws IOException {
        String inputFile = "NioTest13_In.txt";
        String outputFile = "NioTest13_Out.txt";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");

        long length = new File(inputFile).length();

        FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
        FileChannel outputFileChannel = outputRandomAccessFile.getChannel();

        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY,0,length);


        System.out.println("==========================");

        Charset.availableCharsets().forEach((k,v) -> {
            System.out.println(k + ", " + v);
        });


        System.out.println("==========================");

        /**
         * unicode是一种编码方式，utf-8是一种存储方式
         */
        Charset charset = Charset.forName("iso-8859-1");//为什么这里用iso-8859-1编解码，得到的文件还是utf-8的
        CharsetEncoder encoder = charset.newEncoder();
        CharsetDecoder decoder = charset.newDecoder();

        CharBuffer charBuffer = decoder.decode(inputData);

        System.out.println(charBuffer.get(12));

        ByteBuffer outputData = encoder.encode(charBuffer);

//        ByteBuffer outputData = charset.forName("utf-8").encode(charBuffer);

        outputFileChannel.write(outputData);
        inputRandomAccessFile.close();
        outputRandomAccessFile.close();
    }
}
