package com.hsp.transformation;

import java.io.*;

/**
 * @author 宋哲
 * @version 1.0
 * 编程将字节流FileInputStream包装成(转换成)字符流InputStreamReader 对文件进行读取
 * （按照utf-8 格式）进而在包装成BufferedReader
 *
 *  演示使用InputStreamReader 转成流解决中文乱码问题
 *  将字节流 FileInputStream 转成字符流  指定编码gdk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\a.txt";
        //解读：1.new FileInputStream(filePath)的字节流转成InputStreamReader字符流 同时指定处理编码方式“gbk"
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //2.把InputStreamReader字符流 传入到 BufferReader包装流之中  但是底层还是字节流 只是包装两次而已
        BufferedReader br = new BufferedReader(isr);
        //3.读取
        String s = br.readLine();
        System.out.println("读取内容：" + s);
        //4.关外层流
        br.close();
    }
}
