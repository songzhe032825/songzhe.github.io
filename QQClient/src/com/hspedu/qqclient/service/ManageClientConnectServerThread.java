package com.hspedu.qqclient.service;

import java.util.HashMap;

/**
 * @author 宋哲
 * @version 1.0
 * 该类管理客户端连接到服务器端线程类
 */
public class ManageClientConnectServerThread {
    //k - string  v: 线程类型
    //我们把多个线程放入集合中 k:用户id v:线程
    private static HashMap<String,ClientConnectServiceThread> hm = new HashMap<>();
    //将某个线程加入集合中
    public static void addClientConnectServerThread(String userId,ClientConnectServiceThread clientConnectServiceThread){
        hm.put(userId,clientConnectServiceThread);
    }
    //通过用户id得到对应的线程
    public static ClientConnectServiceThread getClientConnectServiceThread(String userId){
        return hm.get(userId);
    }
}
