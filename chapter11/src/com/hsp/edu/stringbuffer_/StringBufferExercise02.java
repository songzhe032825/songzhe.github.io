package com.hsp.edu.stringbuffer_;

import java.util.Scanner;

/**
 * @author 宋哲
 * @version 1.0
 */
public class StringBufferExercise02 {
    /*输入商品名称和商品价格  要求打印效果示例，使用前面学习的方法完成：
    * 商品名  商品价格
    * 手机  123，564.59
    * 要求：价格的小数点前面每三位用逗号隔开
    * 【难点：就是接收到的字符串 怎么把字符串进行格式化？？  对字符串的一种处理】
    *
    * 思路分析：
    * 1.定义一个Scanner对象 接受用户输入的价格(String)
    * 2.希望使用到 StringBuffer的insert 需要将String 转换成 StringBuffer
    * 3.然后可以使用相关方法 对字符串进行处理
    * */
    public static void main(String[] args) {
        Scanner  myScanner = new Scanner(System.in);
        String price = "123464.59";
        //如何将String 转换成 StringBuffer
        StringBuffer sb= new StringBuffer(price);
        //先完成最简单的实现123,464.59
        //找到小数点的索引 然后再该位置前三位插入“.”即可
        //int i = sb.lastIndexOf(".");

        //上面的两个步骤只是考虑加一个 但是需求要很多情况，此时涉及到for循环
        for(int i =sb.lastIndexOf(".")-3; i>0 ; i-=3 ){
            sb= sb.insert(i,",");
        }
        System.out.println(sb);//123,464.59

    }

}
