package com.yhs.udpenhance;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSender(1234, 8808, "localhost")).start();
        new Thread(new TalkReceive(2202, "学生")).start();
    }
}
