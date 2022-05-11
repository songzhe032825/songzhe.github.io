package com.hsp.edu.homework;

import java.util.Locale;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework06 {
    /*1.编写java程序 输入形式为：HanShunPing的人名 以HanPing Han.S的形式打印
    出来 其中.S是中间单词的首字母
    2.例如输入“Willian Jefferson Clinton 输出形式为：Clinton Willian.J
    * */
    //考察知识点 ： 《《字符串相关的使用》》
    /*思路分析：
    1.对输入的字符串进行分割 运用split(" ")
    2.分割后对得到的数组String[] 进行格式化String.format()来搞定
    3.担心传过来的数据是空的 可以对数据进行校验即可
    * */
    public static void main(String[] args) {
        String name = "HanShunPing";
        printName(name);
    }

    //编写方法 完成输出格式要求的字符串
    public static void printName(String str){
       if(str == null) {
           System.out.println("str 不能为空");
           return;//解读这个方法，如果真的为空的话直接返回就行 也不需要抛出异常
       }
        String[] name = str.split(" ");
        if(name.length != 3){
            System.out.println("输入的字符串格式不对");
            return;
        }
        //需求：进行格式化String.format()来搞定
        //问题：以HanPing Han.S的形式打印出来 其中.S是中间单词的首字母
        //String.format("Ping,Han.S");模板
        //name[1].toUpperCase(Locale.ROOT).charAt(0)); 表示中间字符内容全部大写取其中一个字符内容
        String format = String.format("%s,%s.%c", name[2], name[0], name[1].toUpperCase(Locale.ROOT).charAt(0));
        System.out.println(format);
    }
}
