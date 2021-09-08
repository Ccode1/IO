package com.yhs.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadTcpServer {

    static ServerSocket serverSocket = null;
    static Socket socket = null;
    static InputStream inputStream = null;
    static FileOutputStream fos = null;

    public static void main(String[] args) {

        try {
            //1.创建一个server地址
            serverSocket = new ServerSocket(9000);
            //2.等待客户端信息
            socket = serverSocket.accept(); //阻塞式监听，会一直等待客户端连接，不然代码不动
            //3.获取信息客户信息

            inputStream = socket.getInputStream();
            //4.管道流，将输入流中的信息写到管道中
            fos = new FileOutputStream("revicewuhan.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println(fos.toString().trim());//消除空格
            //告诉客户端我接收完毕
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我接收完毕了，你可以断开了".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
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
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
