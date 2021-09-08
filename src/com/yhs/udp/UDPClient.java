package com.yhs.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//UDP是面向无连接的，不需要连接服务器
public class UDPClient {
    public static void main(String[] args) throws Exception {
        //1.建立一个Socket
        DatagramSocket socket = new DatagramSocket();
        //2.建一个包
        //2.1 新建一个发送数据
        String msg = "你好啊，我的世界!";
        //2.2发送给谁
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, address, port);
        //3.发送数据包
        socket.send(packet);
        //4.关闭流
        socket.close();
    }

}
