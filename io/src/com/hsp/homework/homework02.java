package com.hsp.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 要求：使用BufferedReader读取一个文本文件 为每行加上行号 再连同内容一并输出到屏幕上
 */
public class homework02 {
    public static void main(String[] args) throws IOException {

        String filePath = "d:\\b.txt";
        BufferedReader bufferedReader =null;
        String line = " ";
        //行号
        int linNum = 0;
        bufferedReader= new BufferedReader(new FileReader(filePath));
        while ((line = bufferedReader.readLine())!= null){ //不为空循环读取
            System.out.println(++linNum + line);//为空打印
        }
        bufferedReader.close();
    }
}
