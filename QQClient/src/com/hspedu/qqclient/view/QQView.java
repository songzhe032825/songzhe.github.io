package com.hspedu.qqclient.view;

import com.hspedu.qqclient.service.FileClientService;
import com.hspedu.qqclient.service.ManageClientService;
import com.hspedu.qqclient.service.UserClientService;
import com.hspedu.qqclient.utils.Utility;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * qq客户端登录菜单界面
 */
public class QQView {
    //控制是否显示菜单
    private boolean loop = true;
    private String key="";
    //这个就是为View做服务的属性
    private UserClientService userClientService = new UserClientService();//对象用户登录/服务注册
    private ManageClientService manageClientService = new ManageClientService();//对象用户消息发送的内容
    private FileClientService fileClientService = new FileClientService();//文件的传输

    public static void main(String[] args) throws IOException, ClassNotFoundException {
       new QQView().mainView();
        System.out.println("客户端退出系统1");
    }

    //显示主菜单
    private void mainView() throws IOException, ClassNotFoundException {
        //如果输入不是1 和 9 在退出while 循环重新来
        while(loop){
            System.out.println("===欢迎登录网络通讯系统===1");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择： ");
            key = Utility.readString(1);

            //根据用户的输入来处理不同的逻辑

            switch (key){
                case "1" :
                    System.out.println("请输入用户号");
                    //限制用户号为50个即可
                    String userId= Utility.readString(50);
                    System.out.println(userId);
                    System.out.println("请输入密码 ：");
                    String pwd = Utility.readString(50);
                    System.out.println(pwd);
                    //这里需要到服务端去验证该用户是否合法(大量代码 后续补上)
                    //我们在这里编写一个类 UserClientService[用户登录/注册]
                    if(userClientService.checkUser(userId,pwd)){//还没写完 写逻辑打通再说
                        //如果验证成功 进入二级菜单
                        System.out.println("===欢迎用户"+ userId +"===");
                        while(loop){
                            System.out.println("\n===网络通讯系统二级菜单(用户"+ userId +")===");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.println("请输入你的选择 ：");

                            key = Utility.readString(1);
                            //处理二级逻辑
                            switch (key){
                                case "1" :
                                    userClientService.onlineFriendList();
                                break;
                                case "2" :
                                    String s = Utility.readString(100);
                                    System.out.println("群发消息");
                                    //调用一个方法 将消息封装成message对象 发送给服务端
                                   manageClientService.sendManageAllOne(s,userId);
                                    break;
                                case "3" :
                                    System.out.println("请输入想聊天的用户号(在线):");
                                    String getterId = Utility.readString(30);
                                    System.out.println("请输入想说的话的内容:");
                                    String content = Utility.readString(35);
                                    //在编写一个方法 UserClientService类只负责用户登录 注册 拉取用户列表
                                    //私聊群聊内容不再其内 要重新写一个关于服务的类
                                    System.out.println("私聊消息");
                                    manageClientService.sendManageToOne(content,userId,getterId);
                                    break;
                                case "4" :
                                    System.out.println("请输入你想把文件给指定的用户(在线用户)：");
                                    getterId = Utility.readString(50);
                                    System.out.println("请输入发送的文件的路径 ：(形式：d:\\xx.jpg)");
                                    String src = Utility.readString(100);
                                    System.out.println("请输入发送的文件的对应的路径 ：(形式：d:\\yy.jpg)");
                                    String desc = Utility.readString(50);
                                    //这里userId就是指的是senderId
                                    fileClientService.sendFileTo0ne(desc,src,userId,getterId);
                                break;
                                case "9" :
                                    loop= false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("==登陆服务器失败==");
                    }
                    break;
                case "9" :
                    loop = false;
                    break;
            }
        }
    }
}
