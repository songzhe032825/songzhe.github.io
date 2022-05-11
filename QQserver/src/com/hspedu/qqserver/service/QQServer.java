package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 宋哲
 * @version 1.0
 * 这是服务端 在监听端口9999 等待客户端的连接 并保持通信
 */
public class QQServer {
    private ServerSocket serverSocket = null;
    //HashMap 模拟数据库
    //这里我们也可以使用ConcurrentHashMap 处理并发集合 没有线程安全

    //知识点：hashmap 没有处理线程安全 在多线程情况下是不安全的
    // ConcurrentHashMap 处理线程安全 即线程同步 在多线程情况下是线程安全的
    private static ConcurrentHashMap<String,User> validUsers = new ConcurrentHashMap <>();

    static { //在静态代码块 初始化 validUsers
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("宋哲",new User("宋哲","123456"));
    }
    //验证用户是否有效的方法
    private boolean checkUser(String userId,String passwd){
        //是否合法就看集合里k-v是否存在
        User user = validUsers.get(userId);
        if(user == null){//说明user不存在
          return false;
        }
        if(user.getPasswd().equals(passwd)){//说明用户正确 密码错误
            return false;
        }
        return true;//证明 用户和密码都正确
    }


    public QQServer() {
        //注意：端口可以写在配置文件内
        try {
            System.out.println("服务端在9999端口监听");
            serverSocket = new ServerSocket(9999);
            //循环
            while(true){//当与某个客户端建立连接后 依然监听
                Socket socket = serverSocket.accept();
                //得到socket 关联的对象输入流
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                User user = (User) objectInputStream.readObject();//读取客户端user对象 强转
                //创建message 准备回复客户端
                Message message = new Message();


                //验证
                if(checkUser(user.getUserId(), user.getPasswd())){//合法 登录成功
                    //给客户端发送message对象表示成功
                    message.getMesType();
                    //将message回复 此时需要对象输出流
                    objectOutputStream.writeObject(message);
                    //创建一个线程 和客户端保持一个通讯 该线程需要持有socket
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                    //启动线程 要run方法跑起来
                    serverConnectClientThread.start();
                    //重要的一步 吧该线程对象 放入到一个集合中 进行管理
                    ManageClientThreads.addClientThread(user.getUserId(), serverConnectClientThread);
                } else {
                    //如果登录失败 我们无法启动和服务器通信的线程 关闭socket
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    objectOutputStream.writeObject(message);
                    //关闭socket
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭serverSocket 说明服务端不再监听
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
