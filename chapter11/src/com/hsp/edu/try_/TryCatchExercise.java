package com.hsp.edu.try_;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * @author 宋哲
 * @version 1.0
 */
public class TryCatchExercise {
    public static void main(String[] args) {
        //如果用户输入不是一个整数，就提示他反复输入，直到输入一个整数为止
        //思路：1.创建Scanner
        //2.使用无限循环 去接受一个输入
        //3.然后将该输入的值转出int
        //4.如果在转换时 抛出异常 说明输入的内容不是一个整数的int的内容
        //5.如果没有抛出异常 则break 该循环
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr= "";
        while (true){
            System.out.println("请输入一个整数");//假如输入hello
            //有可能抛出异常
            inputStr= scanner.next();
            try {
                //如果没有抛出异常 则break 该循环
                num = Integer.parseInt(inputStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是一个整数");
            }
        }
        System.out.println("输入的值 num=" +num);
    }
}
