package com.yhs.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
public class TcpSever {
    static ServerSocket serverSocket = null;
    static Socket socket = null;
    static InputStream is = null;
    static ByteArrayOutputStream baos = null;

    public static void main(String[] args) {
        try {
            //1. 要有一个地址
            serverSocket = new ServerSocket(9090);
            while (true) {

                //2. 等待客户端链接过来
                socket = serverSocket.accept();
                //3. 读取客户端的消息
                is = socket.getInputStream();
                //3.1 管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) { //缓冲区只要没有读完，就一直while循环
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos.toString().trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
