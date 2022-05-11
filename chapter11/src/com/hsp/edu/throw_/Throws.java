package com.hsp.edu.throw_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Throws {
    public static void main(String[] args) {

    }
    public void f1() throws FileNotFoundException {
        //读文件的操作可能会产生FileInputStream files = new
        // FileInputStream("d://aa.txt");
        //创建一个文件流对象  后面io会将 输入输出流
        //1.第一种方式 编译异常FileNotException必须处理 可以try-catch
        //2.第二种方式 throws 抛出异常 在方法后写throws FileNotException
        //让调用f1()的调用者去处理
        //3.throws 后面的异常类型既可以是方法中产生的异常类型 也可以是他的父类
        //4.throws 关键字后也可以是 异常列表 既可以抛出多个异常
        FileInputStream fileInputStream = new FileInputStream("d://aa.txt");
        }

}


