package com.yhs.udpenhance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class TalkSender implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;
    private int fromPort;
    private int toPort;
    private String toIP;


    public TalkSender(int fromPort, int toPort, String toIP) {
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.toIP = toIP;
        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String msg = reader.readLine();
                DatagramPacket packet = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8),
                        0, msg.getBytes(StandardCharsets.UTF_8).length, new InetSocketAddress(this.toIP, this.toPort));

                socket.send(packet);
                //System.out.println(msg.trim());
                if (msg.trim().equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
