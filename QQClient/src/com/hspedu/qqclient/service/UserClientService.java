package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 宋哲
 * @version 1.0
 * 该类完成用户的登录验证和用户注册
 */
public class UserClientService {

    private User u = new User();//为何将User做成属性 我们可能在其他地方使用User信息
    //因为Socket在其他地方也要使用并且放在启程中去 因此做成属性
    private Socket socket ;

    //根据用户 和 密码到服务器验证该用户是否合法
    public boolean checkUser(String userId,String pwd) throws IOException, ClassNotFoundException {
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        //可以到服务端发送  192.168.1.4 本机地址   9999 端口号
        socket = new Socket(InetAddress.getByName("192.168.1.4"), 9999);
        //得到对象流 准备user对象发过去
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(u);//发送user对象

        //读取服务端回送的message对象 同理也要得到对象流
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Message m = (Message) ois.readObject();//强转
        if (m.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {

            //一旦成功 就要启动线程 不启动线程socket无法维护
            //创建一个服务器保证通信的线程 >> 创建一个类 ClientConnectService
            //等待
            ClientConnectServiceThread clientConnectServiceThread = new ClientConnectServiceThread(socket);
            //启动客户端线程
            clientConnectServiceThread.start();
            //如果方便后面是多线程给服务器端连接的话 需要放入集合中管理..
            ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServiceThread);
            b = true;
        } else {
           //登录失败 就无法启动和服务器通信的线程 关闭socket
            socket.close();
        }
        return b;
    }
    //向服务器端请求在线用户列表
    public void onlineFriendList() throws IOException {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        //如果没有设置Sender发送的id 服务端会显示空指针异常
        message.setSender(u.getUserId());

        //发送给服务器
        //从管理集合的线程中的 通过userId 得到线程 根据线程得到socket
        //得到当前线程的socket所对应的ObjectOutPutStream对象流\
        ClientConnectServiceThread clientConnectServiceThread = ManageClientConnectServerThread.getClientConnectServiceThread(u.getUserId());
        Socket socket = clientConnectServiceThread.getSocket();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        try {
            objectOutputStream.writeObject(message);//发送一个Message对象像服务端要求在线用户列表
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
    //编写方法 退出客户端 并给服务端发送一个退出系统message对象
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//根据用户id来指定哪一个客户端退出
        try {
            //发送message
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            System.out.println(u.getUserId() + "退出系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
