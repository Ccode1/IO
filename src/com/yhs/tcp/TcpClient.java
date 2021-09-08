package com.yhs.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端
public class TcpClient {
    static Socket socket = null;
    static OutputStream os = null;

    public static void main(String[] args) {

        try {
            //1.要知道服务端的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            //2.端口号
            int port = 9090;
            //3.创建一个socket连接
            socket = new Socket(serverIP, port);
            //4.发送消息 ，通过IO流
            os = socket.getOutputStream();
            os.write("您好，欢迎学习Java网络编程".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
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
        }
    }
}
