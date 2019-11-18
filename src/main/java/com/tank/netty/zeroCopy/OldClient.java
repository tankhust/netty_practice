package com.tank.netty.zeroCopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author tank
 * @create 2019/11/18 15:42
 */
public class OldClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 8899);

        String fileName = "/Users/tank/Desktop/zookeeper-3.4.14.tar.gz";
        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        int readCount = 0;
        long total = 0;

        long startTime = System.currentTimeMillis();
        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送字节："+ total + ",耗时：" + (System.currentTimeMillis() - startTime));
        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
