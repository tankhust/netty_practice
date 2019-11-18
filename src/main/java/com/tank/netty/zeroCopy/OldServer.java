package com.tank.netty.zeroCopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author tank
 * @create 2019/11/18 15:33
 */
public class OldServer {
    public static void main(String[] args) throws  Exception{
        ServerSocket serverSocket = new ServerSocket(8899);
        while (true) {

            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            try {
                byte[] byteArray = new byte[4096];
                while (true) {
                    int readCount = dataInputStream.read(byteArray, 0, byteArray.length);

                    if (-1 == readCount) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
