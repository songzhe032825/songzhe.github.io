package com.hsp.outputstream_;

import java.io.*;

/**
 * @author 宋哲
 * @version 1.0
 * BufferedReader 和  BufferedWriter 结合方式完成文本文件拷贝
 * BufferedReader 和  BufferedWriter 按照字符操作
 * 不要去按照二进制文件操作 可能会损坏 比如：音频 照片 ......
 */
public class BufferCopy01 {
    public static void main(String[] args) {
         String srcFilePath = "d:\\a.txt";
         String destFilePath = "d:\\a2.txt";
         BufferedReader br = null;
         BufferedWriter bw = null;
         //定义局部变量 文本文件 按行读取即可
         String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            //读取 并且 写入
            //如何读取: 切记while循环 判断是不是空
            while((line = br.readLine()) != null){
                //写入
                bw.write(line);
                //换行
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                if( bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
