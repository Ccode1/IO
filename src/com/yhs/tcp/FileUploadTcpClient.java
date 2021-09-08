package com.yhs.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class FileUploadTcpClient {
    public static void main(String[] args) throws IOException {

        //1.创建一个Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //2.通过Io流发送消息
        OutputStream os = socket.getOutputStream();
        //3.文件流(读取文件)
        FileInputStream fis = new FileInputStream(new File("wuhan.jpg"));
        //4.写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        //通知客户端我已经传输完了
        socket.shutdownOutput();
        //接受服务端传来的断开连接
        InputStream inputStream = socket.getInputStream(); //接收服务端传来的消息
        byte[] buffer2 = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int inlen;
        while ((inlen = inputStream.read(buffer2)) != -1) {
            baos.write(buffer2, 0, inlen);
        }
        System.out.println(baos.toString().trim());
        //关闭资源
        if (baos != null) {
            baos.close();
        }
        if (socket != null) {
            socket.close();
        }
        if (os != null) {
            os.close();
        }
        if (fis != null) {
            fis.close();
        }
    }
}
