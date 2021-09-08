package com.yhs.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketSever {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true) {
            System.out.println("等待连接。。。。。。");
            //阻塞方法
            Socket clientSocket = serverSocket.accept();
            System.out.println("有客户连接");

        }
    }
}
