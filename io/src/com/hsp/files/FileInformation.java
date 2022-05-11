package com.hsp.files;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 宋哲
 * @version 1.0
 * 获取文件信息
 */
@SuppressWarnings({"all"})
public class FileInformation {
    public static void main(String[] args) {

    }
@Test
    //获取文件信息的方法
    public void info(){
        //先创建文件对象
        File file = new File("d:\\news1.txt");
        //调用相应的方法的到对应的信息
        System.out.println("文件名字 =" + file.getName());
        //绝对路径
        System.out.println("文件绝对路径 =" + file.getAbsolutePath());
        //文件父级目录
        System.out.println("文件父级目录 ="  + file.getParent());
        //文件大小 按照字节统计
        System.out.println("文件大小 ="  + file.length());
        //文件是否存在
        System.out.println("文件是否存在 ="  + file.exists());
        //文件是不是一个文件
        System.out.println("文件是否存在 ="  + file.isFile());
        //文件是不是一个目录
        System.out.println("文件是否是目录 ="  + file.isDirectory());
    }
}


