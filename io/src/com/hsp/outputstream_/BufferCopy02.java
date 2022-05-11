package com.hsp.outputstream_;

import java.io.*;

/**
 * @author 宋哲
 * @version 1.0
 * 编程完成图片/音乐的拷贝(要求使用Buffered..流)
 * bufferInputStream 和 bufferOutputStream 可以处理字节二进制文件
 * 而bufferReader和bufferWriter能处理字符文本文件 但不能处理二进制文件
 * 思考：字节流可以操作二进制文件 可以操作文本文件吗？？
 * 答案：可以 因为字节是根本 但是会乱码 效率很低  但是字符流无法操作二进制文件
 */
public class BufferCopy02 {
    public static void main(String[] args) {
        //源文件路径
       /* String srcFilePath = "d:\\code.jpg";
        //目的地文件路径
        String destFilePath = "d:\\hsp.jpg";*/

        //视频
        String srcFilePath = "d:\\高山流水.mp3";
        //目的地文件路径
        String destFilePath = "d:\\三国杀.mp3";

        //创建bufferOutputStream 和 bufferInputStream 对象
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // FileInputStream 是 BufferedInputStream的子类
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            //循环读取文件  while循环
            byte[] buff = new byte[1024];
            int readLen = 0;
            //当返回 -1 表示文件读取完毕
            while((readLen = bis.read(buff) )!= -1){
                //读取完毕之后 需要写
                bos.write(buff,0,readLen);
            }

            System.out.println("文件拷贝完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流 关闭外层处理流即可
            try {
                if(bis != null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
