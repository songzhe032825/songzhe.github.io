package com.hsp.files;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 宋哲
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Directory_ {
    public static void main(String[] args) {

    }
    //判断 d:\\ news1.txt 是否存在 如果存在就删除
    @Test
    public void m1(){
        String filePath = "d:\\news2.txt";
        File file = new File(filePath);
        if(file.exists()){
            if(file.delete()){
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else{
            System.out.println("该文件不存在....");
        }
    }
//判断 d:\\demo2 是否存在 存在就删除 否则就提示不存在
//这里我们需要体会到 在Java编程中 目录也被当文件
    @Test
    public void m2(){
        String filePath = "d:\\demo2";
        File file = new File(filePath);
        if(file.exists()){
            if(file.delete()){
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else{
            System.out.println("该文件不存在....");
        }

    }
}

