package com.hsp.files;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * Writer 一定要关闭流或者刷新
 * new FileWriter(FilE / String) :覆盖模式
 * new FileWriter(FilE / String,true) :追加模式
 */
@SuppressWarnings({"all"})
public class FileWriter {
    public static void main(String[] args) {
        String filePath = "D:\\note.txt";
        java.io.FileWriter fileWriter = null;
        char[] chars ={'a', 'b', 'd', 'e'};
        try {
            fileWriter  = new java.io.FileWriter(filePath);//默认是覆盖写入
            //写入单个字符write(int)
            // fileWriter.write( 'H');
            //写入指定数组 write(char[]):写入指定数组
            fileWriter.write(chars);
            //write(String off len) 写入字符串的指定部分
            fileWriter.write("北京欢迎你",0,4);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对于我们FileWriter 一定要关闭流 或者flush才能真正的数据写入到文件
            //一会老韩追源码就懂了 如果不关闭看看后果如何？
            try {
                //fileWriter.flush();也可以
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        //程序结束
        System.out.println("程序结束");
    }
  }
}
