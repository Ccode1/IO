package com.yhs.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClientTest {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String msg = "你的名字";
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),msg.getBytes().length,new InetSocketAddress("localhost",8080));
        socket.send(packet);
        socket.close();
    }
}
