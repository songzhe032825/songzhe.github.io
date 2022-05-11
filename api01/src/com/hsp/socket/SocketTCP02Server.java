package com.hsp.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 宋哲
 * @version 1.0
 * 服务端字符流
 * 思路：
 * 1.socket.getOutputStream()输出流
 * 2.将输出流OutputStream 转成 Writer字符流
 * 3.如何转成Writer字符流？ 这里需要转换流
 * OutputStreamWriter(字节流File...)
 */
@SuppressWarnings({"all"})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //1.在本机子9999端口监听时 等待连接
        //细节：要求在本机没有其他服务在监听9999
        //区别： ServerSocket 和 Socket
        //1.ServerSocket可以创建很多Socket 只要有一次accept()就可以返回一次Socket
        //2.ServerSocket存在可能性多个客户端连接 ServerSocket 可以通过accept() 返回多个Socket[]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听 等待连接");
        //2.当没有客户端连接9999端口时 程序会堵塞 等待连接
        //如果有客户端连接 则会返回Scoket对象 程序继续执行
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket =" + socket.getClass());
        //3. 通过s.getInputStream() [读取]客户端写入到数据通道的数据 显示 read(byte[] b)
        InputStream inputStream = socket.getInputStream();
        //4.IO读取 老师使用InputStreamReader 将 inputStream 转成字符流
        //BufferedReader字符流 InputStreamReader转换流 inputStream 字节流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println("s=" +s);
        inputStream.read("hello,server".getBytes(StandardCharsets.UTF_8));
        //延申 反向传回
        //5.获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        //使用字符输出流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine();//插入换行符 表示回复内容结束
        bufferedWriter.flush();//需要手动刷新
        //6.关闭流和socket流
        inputStream.close();
        socket.close();
        serverSocket.close();
        outputStream.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
