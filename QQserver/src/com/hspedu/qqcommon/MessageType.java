package com.hspedu.qqcommon;

/**
 * @author 宋哲
 * @version 1.0
 * 表示消息类型
 */
public interface MessageType {
    //老师解读
    //1.在接口中定义了一些常量
    //2.不同的常量的值，表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED = "1";//表示登录成功
    String MESSAGE_LOGIN_FAIL = "2";  //表示登陆失败
    String MESSAGE_COMM_MES ="3";//普通私聊信息
    String MESSAGE_GET_ONLINE ="4";//要求返回在线用户列表
    String MESSAGE_RET_ONLINE ="5";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT ="6";//客户端请求退出
    String MESSAGE_ALL_MES ="7";//普通群聊信息
    String MESSAGE_FILE_MES ="8";//发送文件
}
