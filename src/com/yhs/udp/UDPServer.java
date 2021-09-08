package com.yhs.udp;

import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPServer {
    //等待客户端的链接
    public static void main(String[] args) throws IOException {
        //1.开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //2.接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet); //阻塞接收
        System.out.println(packet.getAddress().getHostName());
        System.out.println(new String(packet.getData(), 0, buffer.length).trim());
        //3.关闭资源
        socket.close();

    }
}
