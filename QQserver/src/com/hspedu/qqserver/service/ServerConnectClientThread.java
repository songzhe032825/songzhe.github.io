package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 宋哲
 * @version 1.0
 * 该线程类对应的对象和某一个客户端保持连接
 * 与客户端接受消息message的线程类
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    //ServerConnectClientThread该线程和客户哪个保持通讯的
    private String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        userId = userId;
    }
    public void getSocket(){
        return;
    }

    @Override
    public void run() {//线程处于run状态，可以发送/接受客户端message消息
        while(true){
            try {
                System.out.println("服务端和客户端"+ userId +"保持通讯 读取数据");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                //后面会使用message
                //判断这个message类型 然后做相应的业务处理
                if(message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE)) {
                    //客户端显示在线列表
                    /*
                     * 在线用户列表 100 200 宋哲
                     * */
                    System.out.println("客户端在线用户列表");
                    //方便debug 打印一句话
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回message 需要构建message对象里面包含客户列表信息返回给客户端
                    Message message2 = new Message();
                    //添加信息 首先返回消息的类型给客户端
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE);
                    message2.setContent(onlineUser);
                    //我作为服务端对象返回给客户端的是接收者 而客户端是发送者对象需要sender
                    // 英文单词：发送者是sender 接受着getter
                    message2.setGetter(message.getSender());
                    //接下来  1.写入数据通道socket 返回给客户端
                    //2.同时还要写socket获取的对象输出流
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message2);
                }else if(message.getMesType().equals(MessageType.MESSAGE_ALL_MES)){//群发消息
                    //思路：需要遍历线程的集合 把所以的socket得到 然后把message进行转发即可
                    //因为HashMap是私有的 我需要通过get来获取hm
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    //接下来进行K-V遍历
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()){
                        //取出在线用户的id
                        String onLineUserId = iterator.next().toString();

                        if(!onLineUserId.equals(message.getMesType())){//这行代码注解 目的是：群发消息是排除自己
                            //进行转发message
                            //hm.get(onLineUserId) 线程
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(hm.get(onLineUserId).socket.getOutputStream());
                            objectOutputStream.writeObject(message);//真正的转发
                        }
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){//发送普通消息内容
                    //根据message获取getterId 然后在获取对应的线程 serverConnectClientThread
                    //对于服务器 ：message.getSender()是自己发自己相当于发送到服务器 应该是接受客户端是getter
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getSender());
                    //根据线程在获取对象输出流 将message对象转发给指定的客户端
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverConnectClientThread.socket.getOutputStream());
                    objectOutputStream.writeObject(message);//转发 提示如果客户不在线 可以保存到数据库
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//客户端退出
                    System.out.println(message.getSender() + "退出");
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    //关闭连接
                    socket.close();
                    //退出线程 也就是while循环的run方法
                    break;
                }else if(message.getMesType().equals(MessageType.MESSAGE_ALL_MES)) {//群发消息
                    //显示在客户端的控制台
                }else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){//文件传输
                    //根据getterId获取对应的线程 通过message转发
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverConnectClientThread.socket.getOutputStream());
                    //转发message
                    objectOutputStream.writeObject(message);

                } else {
                    System.out.println("是其他信息message 暂时不处理");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
