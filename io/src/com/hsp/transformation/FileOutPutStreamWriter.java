package com.hsp.transformation;

import java.io.*;

/**
 * @author 宋哲
 * @version 1.0
 * 演示OutPutStreamWriter使用
 * 把FileOutPutStream字节流 转换成 OutPutStreamWriter 字符流
 * 指定编码方式 gbk/utf-8
 */
public class FileOutPutStreamWriter {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\sz.txt";
        //new FileOutputStream(file,"utf-8")字节流转成  OutputStreamWriter 字符流
        //这里不需要缓存包装流 这里是指定编码 而且FileWriter改变不了编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");
        osw.write("函数");
        osw.close();
    }
}
