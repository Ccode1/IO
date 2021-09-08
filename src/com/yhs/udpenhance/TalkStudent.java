package com.yhs.udpenhance;

public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSender(9090, 2202, "localhost")).start();
        new Thread(new TalkReceive(8808, "老师")).start();
    }
}
