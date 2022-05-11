package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.*;

/**
 * @author 宋哲
 * @version 1.0
 * 该类对象完成文件传输服务
 *
 * @desc 目标文件 把该文件传输到对方的哪个目录
 * @src 源文件
 * @senderId 发送用户id
 * @getterId 接收者用户id
 */
public class FileClientService {
    public void sendFileTo0ne(String desc,String src,String senderId,String getterId){
        //读取src文件 >> message  设计到文件IO流知识点
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setDesc(desc);
        message.setGetter(getterId);
        message.setSrc(src);

        //需要将文件读取
        //将文件输入流把磁盘文件读入到字节数组
        FileInputStream fileInputStream = null;
        //文件编程可以创建文件对象拿到长度
        byte[] fileBytes = new byte[(int)new File(src).length()];

        //创建输入流
        try {
            fileInputStream = new FileInputStream(src);
        //将src磁盘文件读入到程序的字节数组客户端A中
            fileInputStream.read(fileBytes);
        //将文件字节数组设置到message对象
            message.setFileBytes(fileBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //提示客户端A给客户端B 传输文件
        System.out.println("\n" + senderId +
                "给" +getterId+ "发送文件：" + src
                + "到对方电脑的目录" + desc
        );

        //真正的发送 通过socket 拿到对象输出流 把message对象信息打通到信息通道即可
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.
                    getClientConnectServiceThread(senderId).getSocket()
                    .getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
