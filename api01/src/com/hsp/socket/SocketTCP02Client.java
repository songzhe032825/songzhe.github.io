package com.hsp.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 宋哲
 * @version 1.0
 * 字符流客户端
 *思路：
 * 1.socket.getInputStream()输入流
 * 2.将InputStream()输入流转成->字符流Reader()
 * 3.InputStreamReader(字节流
 * 4.写设置写入结束标记 writer.newLine() 注意需要使用readLine()方式才能读取到
 */
@SuppressWarnings({"all"})
public class SocketTCP02Client {
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
        bufferedWriter.write("hello,server 字符流");
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
