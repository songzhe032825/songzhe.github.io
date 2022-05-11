package com.hsp.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author 宋哲
 * @version 1.0
 * 文件下载的客户端
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {
        //1.接受用户输入 指定下载的文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名");
        String downloadFileName = scanner.next();

        //2.客户端连接服务端 准备发送
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        //3.获取和Socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes(StandardCharsets.UTF_8));
        //设置写入结束标志
        socket.shutdownOutput();

        //4.读取服务端返回的文件(字节数据)
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //5.得到一个输出流准备将Bytes内容写入磁盘
        String filePath = "e:\\" + downloadFileName + ".mp3";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(bytes);
        //6.关闭资源
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        outputStream.close();
        System.out.println("客户端下载完毕  退出..........");
    }
}
