package com.hsp.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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
 *  * 6.该程序要求使用StreamUtils.java 直接使用
 *  */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //1.创建客户端连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //2.创建读取的磁盘的输入流
        String path = "d:\\hsp.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        //bytes[]就是Path对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //3.通过socket获取到输出流 将bytes数据发送服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应字节数组写入到数据通道
        //4.设置结束的标志

        //===========接收到从服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        bis.close();
        socket.shutdownInput();//设置写入数据的结束标记
        inputStream.close();

        //5.关闭流
        bos.close();
        socket.close();
    }
}
