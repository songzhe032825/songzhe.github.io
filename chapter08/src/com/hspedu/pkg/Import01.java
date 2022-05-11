package com.hspedu.pkg;

//老韩建议需要什么类导入什么类 不建议全导入

import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        /*
         * 语法：import包
         * 我们引入一个包时的主要目的使用该包下的类
         * 比如：import java.util.Scanner 就只是引入一个类Scanner
         * import java.util*;  表示将java.util 包所有引入
         * 案例： 使用系统提供的Arrays 完成 数组排序
         * */
        //使用系统提供 Arrays 完成 数组排序
        int[] arr = {0, 772, 33, 2, 44, -5, 333};
        //比如对其进行排序
        //传统方法是 自己编写排序(冒泡)
        //系统是提供给了相关的类 可以方便完成Arrays
        Arrays.sort(arr);
        for(int i = 0; i < arr.length;i++) {
            System.out.println(arr[i] + "\t");
        }
    }
}
