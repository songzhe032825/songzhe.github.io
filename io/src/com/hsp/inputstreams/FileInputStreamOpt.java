package com.hsp.inputstreams;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 优化单个字节的读取 效率比较低
 * -> 使用 read(Byte[] b) 对读取文件
 * 为了优化FileInputStreamOpt的读取 往往使用read(byte[] b)
 */
@SuppressWarnings({"all"})
public class FileInputStreamOpt {
    public static void main(String[] args) {

    }
    @Test
    public void readFile01(){
        String filePath = "d: \\hello.txt";
        java.io.FileInputStream fileInputStream = null;
        int readData = 0;
        int readLen = 0;
        //字节数组
        byte[] bytes = new byte[8];//一次读取8个字节
        try {
            //创建
            fileInputStream = new java.io.FileInputStream(filePath);
            //API方法读取：从该输入流读取最多b.length字节的数据到字节数组。
            //如果返回-1  表示读取完毕 并且有while循环遍历(因为文件不可能只有一个)
            while((readLen = fileInputStream.read(bytes)) != -1){
                System.out.println(new String(bytes,0, readLen));//转成字符显示
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
    }
}
