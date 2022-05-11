package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author 宋哲
 * @version 1.0
 * 在这里获取服务端信息 run方法
 */
public class ClientConnectServiceThread extends Thread{
    //该线程需要持有Socket 网络编程又叫Socket编程
    private Socket socket;

    //启动线程专用
    @Override
    public void run() {
        //线程需要在后台和服务器通讯 因此我需要while循环
        while (true){
            System.out.println("我们的客户端线程等待服务器端的发送消息");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                //需要判罚message类型 做业务处理
                if(message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表显示 肯定是根据getContent()返回给服务端信息的
                    String[] onLineUsers = message.getContent().split("");
                    System.out.println("==当前在线用户列表==");
                    for (int i = 0; i < onLineUsers.length; i++) {
                        System.out.println("用户 = " + onLineUsers[i]);
                    }
                }else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    System.out.println("\n" + message.getSender() + "对" + message.getGetter()
                            + "说" + message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_ALL_MES)) {
                    //通过getSender ..给getter提示信息
                    System.out.println("\n" + message.getSender() + "对"
                            + "说" + message.getContent());
                }else  if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    //客户端B接受到服务端传来的message文件 打印信息
                    System.out.println("\n" + message.getSender() + "给" + message.getGetter()+
                            "发文件 ：" +message.getSrc() + "到我的电脑目录来：" + message.getDesc());
                    //取出message的文件字节数组 通过文件输出流传入到磁盘给客户端B
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDesc());//通过路径
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n保存文件成功");
                } else {
                    System.out.println("其他类型message 暂时不处理");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //可以接受socket对象
    public ClientConnectServiceThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
