package com.hsp.BufferWriter_;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author 宋哲
 * @version 1.0
 * 演示BufferWriter
 */
public class BufferWriter_ {
    public static void main(String[] args) throws Exception{
        String filePath= "d:\\wo.txt";
        //创建BufferWriter  追加方式在节点流后面加个true即可   S覆盖方式没有true
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write("hello1,韩式拌饭");
        bufferedWriter.newLine();//插入和系统相关的换行符
        bufferedWriter.write("hello2,韩式拌饭");
        bufferedWriter.newLine();
        bufferedWriter.write("hello3,韩式拌饭");
        //插入一个换行符
        //记得关闭外层流
        bufferedWriter.close();
    }
}
