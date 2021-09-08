package com.yhs.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {


    public static void main(String[] args) throws UnknownHostException {
        //查询本机地址
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        //查询本机地址
        InetAddress inetAddress2 = InetAddress.getByName("localhost");
        System.out.println(inetAddress2);
        //查询本机地址
        InetAddress inetAddress3 = InetAddress.getLocalHost();
        System.out.println(inetAddress3);

        //查询网站IP地址
        InetAddress inetAddress4 = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress4);

        //常用方法
        System.out.println(inetAddress4.getCanonicalHostName()); //获得规范的名字
        System.out.println(inetAddress4.getHostAddress());//ip
        System.out.println(inetAddress3.getHostName());//域名||自己主机的名字
    }
}
