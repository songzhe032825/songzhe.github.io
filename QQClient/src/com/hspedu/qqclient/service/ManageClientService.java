package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * @author 宋哲
 * @version 1.0
 * 该对象和服务端提供消息服务
 * 私聊 群聊内容
 *
 *私聊
   @ content 发送内容
 * @ senderId 发送用户id
 * @ getterId 接受用户id
 *
 * 群聊
 * @ content 发送内容
 *  * @ senderId 发送用户id
 */
@SuppressWarnings({"all"})
public class ManageClientService {

//群聊  不能用getterId 因为这是特指某一个私聊用户的
    public void sendManageAllOne(String content,String senderId){
        //创建message信息
        Message message = new Message();
        //封装
        message.setSender(senderId);
        //设置消息类型
        message.setMesType(MessageType.MESSAGE_ALL_MES);
        message.setContent(content);
        //发送指定时间设置到message对象
        message.setSendTime(new Date().toString());
        System.out.println(senderId + "对"  + "说" + content);

        //接下来通过socket方法来发送个服务器
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServiceThread(senderId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

//私聊
    public void sendManageToOne(String content,String senderId,String getterId){
        //创建message信息
        Message message = new Message();
        //封装
        message.setSender(senderId);
        //设置消息类型
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setGetter(getterId);
        message.setContent(content);
        //发送指定时间设置到message对象
        message.setSendTime(new Date().toString());
        System.out.println(senderId + "对" + getterId + "说" + content);

        //接下来通过socket方法来发送个服务器
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServiceThread(senderId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
