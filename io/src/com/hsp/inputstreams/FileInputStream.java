package com.hsp.inputstreams;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 字节流 二进制文件
 *单个字节读取 效率很低 往往会用到read(byte[] b)字节数组
 * 演示FileInputStream 使用 （字节输入流 文件--》》 程序）
 */
@SuppressWarnings({"all"})
public class FileInputStream {
    public FileInputStream(String filePath) {
    }

    public static void main(String[] args) {

    }
    @Test
    public int readFile01(byte[] bytes){
        String filePath = "d: \\hello.txt";
        java.io.FileInputStream fileInputStream = null;
        int readData = 0;
        //字节数组
        byte[] buf1 = new byte[0]; //一次读取8个字节
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new java.io.FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。此方法将堵塞 直到
            //某些输入
            //调用read() 读取字节的数据
            //如果返回-1  表示读取完毕 并且有while循环遍历(因为文件不可能只有一个)
            while((readData = fileInputStream.read()) != -1){
                System.out.println((char)readData);//把int 转成char显示
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭文件流释放资源  因为流是资源  很重要！！
            //类名.close
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return readData;
    }

}

