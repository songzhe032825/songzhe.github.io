package com.hsp.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 宋哲
 * @version 1.0
 * /** 网络上传文件1
 *  * @author 宋哲
 *  * @version 1.0
 *  * 1.编写一个服务端和一个客户端
 *  * 2.服务端在9999端口监听
 *  * 3.客户端连接到服务端 发送一张图片e:\\qie.png
 *  * 4.服务器端接收到客户端发送的图片 保存到src下 发送”收到图片“再退出
 *  * 5.客户端接受到服务端发送的”收到图片" 再退出
 *  * 6.该程序要求使用StreamUtils.java
 *  */

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1.服务端在本机监听“8888”端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听....");
        //2.等待客户端的连接 如果有客户端的存在就会有socket
        Socket socket = serverSocket.accept();
        //....
        //3.读取客户端发送数据
        //通过socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //4.将得到 bytes数组
        String destPath = "src:\\hsp2.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath));
        bos.write(bytes);
        bos.close();

        //向客户端回复“收到照片”
        //通过socket 获取输出流(字符)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("已收到图片");
        bw.flush();//把内容刷新到数据通道
        socket.shutdownInput();//设置写入结束标记

        //5 关闭
        bis.close();
        socket.close();
        serverSocket.close();
        bw.close();
    }
}
