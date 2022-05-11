package com.hsp.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 宋哲
 * @version 1.0
 * 演示InetAddress 类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-DN2EEN50/192.168.1.4

        //2.根据指定主机名 获取InetAddress
        InetAddress byName = InetAddress.getByName("LAPTOP-DN2EEN50");
        System.out.println(byName);

        //3. 根据域名返回  InetAddress对象
        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        System.out.println(allByName);
    }
}
