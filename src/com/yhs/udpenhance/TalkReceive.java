package com.yhs.udpenhance;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
    DatagramSocket socket = null;
    private int toPort;
    private String msgFrom;

    public TalkReceive(int toPort, String msgFrom) {
        this.toPort = toPort;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(toPort);

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getData().length);
                System.out.println(msgFrom + ":" + msg.trim());
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
