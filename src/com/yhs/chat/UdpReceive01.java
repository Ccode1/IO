package com.yhs.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;


public class UdpReceive01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            //准备接受包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);
            //读取接收过来的数据
            byte[] msg = packet.getData();
            String reveiceMsg = new String(msg, 0, msg.length);
            //System.out.println(reveiceMsg.trim().length());
            System.out.println("憨憨:" + reveiceMsg.trim());
            if (reveiceMsg.equals("bye")) {
                break;
            }
            //给客户端发送消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String msgSender = reader.readLine();
            DatagramPacket packetSender = new DatagramPacket(msgSender.getBytes(StandardCharsets.UTF_8), 0, msgSender.getBytes().length, new InetSocketAddress("localhost", 8888));
            socket.send(packetSender);
            if (msgSender.trim().equals("bye")) {
                break;
            }

        }
        socket.close();

    }
}
