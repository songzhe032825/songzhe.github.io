package com.hsp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**字节流服务端
 * @author 宋哲
 * @version 1.0
 * 1.编写一个服务器端 和一个客户端
 * 2.服务器端在9999端口监听
 * 3.客户端连接到服务器端 发送hello server 然后退出
 * 4.服务器端口接受到 客户端发送的信息 输出 并输出
 * 主机/服务端（接受请求连接）
 * 思路：1.在本机的9999端口监听 等待连接
 * 2.在没有客户端连接9999端口时 程序会堵塞 等待连接
 * 3.通过scoket.getInputStream() 读取客户端写入到数据通道的数据 显示
 * 主机/客户端（发起连接）
 * 思路：
 * 1.连接服务端（ip 端口）
 * 2.连接上后通过socket生成通过socket.getOutputStream
 * 3.通过输出流，写入数据到数据通道
 *
 *
 * Socket 理解
 * 1.TCP编程 可靠
 * 2.UDP编程 不可靠
 * 结束标记设置shutdownInput()
 */
public class SocketTCP01Server {
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
        //4.IO读取
        byte[] buf = new byte[1024];//先缓冲
        int readLen = 0;
        while ((readLen = inputStream.read(buf))!= -1){
            System.out.println(new String(buf,0,readLen));//根据读取到的实际长度 显示内容
        }
        inputStream.read("hello,server".getBytes(StandardCharsets.UTF_8));

        //延申 反向传回
        //5.获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client打个招呼".getBytes(StandardCharsets.UTF_8));
        //在hello,server 后面加上结束标记设置
        socket.shutdownInput();
                //6.关闭流和socket流
                inputStream.close();
                socket.close();
                serverSocket.close();
                outputStream.close();
            }
        }
