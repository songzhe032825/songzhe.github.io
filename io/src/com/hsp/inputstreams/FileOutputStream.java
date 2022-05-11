package com.hsp.inputstreams;

import org.junit.jupiter.api.Test;

/**
 * @author 宋哲
 * @version 1.0
 * 要求使用FileOutStream 在a.txt文件中写入 "hello world" 如果文件不存在
 * 会创建文件（前提目录已存在）
 */
public class FileOutputStream {

    public FileOutputStream(String filePath) {
    }
    @Test
    public void writeTile(byte[] bytes){
        String filePath = "d:\\ hi.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            //写入一个字符串
            //fileOutputStream.write('H');
            //写入字符串
            String str = "hello,world!";
            //str.getBytes() 可以把 字符串 >> 字节数组
            fileOutputStream.writeTile(str.getBytes());
        } finally {
            try {
                fileOutputStream.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }
}
