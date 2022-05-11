package com.hsp.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 宋哲
 * @version
 * 中文乱码问题
 *
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取"d:\\data.txt"  文件到程序
        //思路：
        /*1.先创建字符输入流 BufferReader  处理流（里面放节点流）
        * 2.使用BufferedReader 对象读取a.txt
        * 3.默认情况下读取文件按照 是UTF-8编码读取 如果编码发生问题出现乱码
        * */
        String filePath = "d:\\a.txt ";
        BufferedReader br= new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println("读取到内容 : " + s);
        br.close();
    }
}
