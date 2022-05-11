package com.hsp.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 宋哲
 * @version 1.0
 * 先写文件下载的服务器
 *
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        //1.监听 9999 端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户端连接
        Socket socket = serverSocket.accept();
        //3.读取 客户端发送要下载的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String downLoad = "";
        //需求客户端发送的内容比较多需要while循环读取
        while( (len = inputStream.read(b)) != -1){
            downLoad += new String(b,0,len);
        }
        System.out.println("客户端希望下载文件名=" + downLoad);

        //如果客户下载的是 高山流水 我们就返回该文件 否则一律返回 无名.mp3

        String resFileName = "";
        if("高山流水".equals(downLoad)){
            resFileName = "src\\高山流水.mp3";
        } else {
            resFileName = "src\\无名.mp3";
        }

        //4.创建输入流 读取文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));
        //5.使用工具类StreamUtils读取文件到一个字节数组

        //如何读取？
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        //6.得到Socket关联的输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        //7.写入数据通道 返回客户端
        bufferedOutputStream.write(bytes);
        //设置结束标记
        socket.shutdownInput();
        //8.关闭相关资源

        //输入流资源关闭
        bufferedInputStream.close();
        //客户端传来的文件关闭资源
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
