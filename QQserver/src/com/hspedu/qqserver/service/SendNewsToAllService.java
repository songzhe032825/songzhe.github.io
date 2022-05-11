package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.utils.Utility;

import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 宋哲
 * @version 1.0
 */
public class SendNewsToAllService implements Runnable{
    @Override
    public void run() {
        System.out.println("请输入服务器需要推送的新闻/消息");
        String news = Utility.readString(100);
        //构建消息类型 群发消息
        Message message = new Message();
        message.setSender("服务器");
        message.setContent(news);
        message.setSendTime(new Date().toString());
        System.out.println("服务器推送给消息给所有人" + news);

        //当前所有的通信线程 得到socket 并发送message
        HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()){
            //当前在线用户 取出其id
            String onLineUserId = iterator.next().toString();
            //根据id取出线程
            ServerConnectClientThread serverConnectClientThread = hm.get(onLineUserId);//ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverConnectClientThread.getSocket());
        }
    }
}
