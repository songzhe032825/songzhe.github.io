package com.hsp.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 宋哲
 * @version 1.0
 * 字符流客户端
 *思路：
 * TCP编程练习作业
 * 1.使用字符流的方式 编写一个客户端程序和服务端程序
 * 2.客户端发送name 服务端接收到后 返回 我是nova nova是你自己的名字
 * 3.客户端发送 hobby 服务端接受到后 返回java程序
 * 4.不是这两个问题 回复你说啥呢
 */
@SuppressWarnings({"all"})
public class HomeSocketTCP02Client {
    public static void main(String[] args) throws IOException {
       //思路
        //1.连接服务端 (ip,端口)
        //解读：连接本机的9999端口,如果连接成功 返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 在9999端口监听 等待连接");
        System.out.println(socket.getClass());
        //2.连接上后，生成Socket 通过socket.get()OutputStream()输出流对象
        //一定要跟数据通道关联的
        OutputStream outputStream = socket.getOutputStream();
        //3.读取通过输出流 写入数据到 数据通道 write()
        //要求字符流   OutputStreamWriter转换流  outputStream 字节流  BufferedWriter字符流(包装流)(writer子类)
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //从键盘读取用户问题
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题");
        String question= scanner.next();

        bufferedWriter.write(question);
        bufferedWriter.newLine();//换行符 写入内容结束 并且要求对方使用readLine()!!!!!
        bufferedWriter.flush();//如果使用的字符流 需要手动刷新 否则数据不会写入数据通道
        //在hello,server 后面加上结束标记设置
        socket.shutdownOutput();
        //4.获取socket相关联的输入流 读取数据 显示 反向返回 节点流搞定
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //5.关闭流对象和socket 必须关闭
        outputStream.close();
        socket.close();
        inputStream.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
