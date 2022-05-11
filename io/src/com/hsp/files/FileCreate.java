package com.hsp.files;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 演示创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    //单元测试
    @Test
    //方式一： new File(String pathname)
    public void creat01()  {
        //文件路径写清楚即可
        String filePath = "d:\\news1.txt";
        //使用一个方法File(io流提示) 自动生成的
        File file = new File(filePath);

        //创建File对象 会抛出异常
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("如果没有异常 文件创建成功");
    }
    //方式2：new File(File parent,String child) //根据父目录文件 + 子路径构建
    //如果创建d:\\news2.txt的话 解析说明1.：File parent：d:\\
    //2.子路径也就是文件名：news2.txt
    @Test
    public void creat02(){
        File parentFile = new File("d:\\");//父目录
        String fileName = "news2.txt";//子路径
        //创建真正的文件 但这里的file对象 在Java程序中只是一个对象仅此而已
        File file = new File(parentFile, fileName);
        try {
            //只有file对象真正调用createNewFile()才是真正的执行
            //并且这才是真正将信息写入对应磁盘上
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("没有异常");
    }
    @Test
    //方式3：new File(String parent, String child) //根据父目录 + 子路径构建
    public void create03(){
        String parentPath = "d:\\";
        String filePath = "news3.txt";
        File file = new File(parentPath,filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("没有异常");
    }
}
