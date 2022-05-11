package com.hsp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**字节流客户端
 * @author 宋哲
 * @version 1.0
 * 客户端
 * 客户端与服务器端各有一个socket
 * 设置写入结束标记 socket.shutdownOutput()
 */
public class SocketTCP01Client {
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
        outputStream.write("hello,server".getBytes(StandardCharsets.UTF_8));
        //在hello,server 后面加上结束标记设置
        socket.shutdownOutput();
        //4.获取socket相关联的输入流 读取数据 显示 反向返回 节点流搞定
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while((readLen = inputStream.read(buf))!= -1){
            System.out.println(new String(buf,0,readLen));
        }
        //5.关闭流对象和socket 必须关闭
        outputStream.close();
        socket.close();
        inputStream.close();
    }
}
