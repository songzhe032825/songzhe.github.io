package com.hsp.files;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 */
public class FileReader {
    public static void main(String[] args) {
        String filePath=  "d:\\hsp.txt";
        java.io.FileReader fileReader = null;
        int data = 0;
        try {
            fileReader = new java.io.FileReader(filePath);
            //一.循环读取 使用read 单个字符获取
            while ((data = fileReader.read()) != -1){
                //将int 强转 char
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //推荐使用第二种方案
    @Test
    public void readFile02(){
        //二.循环读取 使用read 数组获取
        String filePath = "c: \\DumpStack.txt";
        FileInputStream fileInputStream = null;
        int reaLength = 0;
        byte[] buffer = new byte[8];
        try {
            fileInputStream = new FileInputStream(filePath);
            //循环
            //如果返回 -1 说明文件结束
            while(( reaLength = fileInputStream.read(buffer) )!= -1){
                System.out.println(new String(buffer,0,reaLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
