package com.hspedu.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 宋哲
 * @version 1.0
 * 管理客户端的线程的集合
 */
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();
    //添加线程对象到hm集合
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }
    //根据userId返回线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    //从集合中移除某个对象(根据id)
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }

    //给群聊ServerConnectClientThread 提供一个get方法来获取私有的集合 返回hm
    public static HashMap<String,ServerConnectClientThread> getHm (){
        return hm;
    }

    //在这里返回在线用户列表
    public  static String getOnlineUser(){
        //根据key就是userId来集合遍历获取在线用户列表 keySet
        Iterator<String> iterator = hm.keySet().iterator();
        String onLineUserList = "";
        while (iterator.hasNext()){
            onLineUserList += iterator.next().toString() + " ";
        }
        return onLineUserList;
    }
}
