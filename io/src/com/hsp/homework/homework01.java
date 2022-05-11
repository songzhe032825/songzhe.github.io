package com.hsp.homework;

import java.io.*;

/**
 * @author 宋哲
 * @version 1.0
 * 1.在判断d盘下是否有文件夹mytemp,如果没有就创建mytemp
 * 2.在d:\\mytemp 目录下 创建文件 hello.txt
 * 3.如果hello.txt 已经存在 提示该文件已经存在 就不要重复创建了
 *4.并且在hello.txt 文件中 写入hello,world~~
 */
public class homework01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "d:\\mytemp";
        File file = new File(directoryPath);
        if(!file.exists()){
            //创建
            if(!file.mkdirs()){
                System.out.println("创建目录成功");
            } else {
                System.out.println("创建目录失败");
            }
        }

        String filePath = directoryPath + "\\hello.txt"; //d:\mytemp\hello.txt;
        file = new File(filePath);

        if(!file.exists()){
            //创建文件
            if(file.createNewFile()){
                System.out.println(filePath + "创建成功");
                //写入hello world  bufferWriter字符输入流写入内容
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("hello,world ~~~ 韩顺平教育");
                bufferedWriter.close();
            } else {
                System.out.println(filePath + "创建失败");
            }
        }

        //如果文件已经存在 给出提示信息
        System.out.println(filePath + "已经存在 不再重复创建");
    }
}
