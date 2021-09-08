package com.yhs.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
//Sender端进行消息接收的时候

public class UdpSender01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        while (true) {
            //准备数据，控制台读取数据到缓冲区
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String msg = reader.readLine();
            DatagramPacket packet = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8), 0, msg.getBytes().length, new InetSocketAddress("localhost", 6666));
            socket.send(packet);
            if (msg.equals("bye")) {
                socket.close();
            }


            //接收服务端发送的消息
            byte[] buffer = new byte[1024];
            DatagramPacket packageReceive = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packageReceive);
            //读取接受的消息
            byte[] data = packageReceive.getData();
            String msgReceive = new String(data, 0, data.length);
            //System.out.println(msgReceive.trim().length());
            System.out.println("哥哥:" + msgReceive.trim());
            if (msgReceive.trim().equals("bye")) {
                break;
            }

        }


    }
}
