package com.hspedu.debug_;

import java.util.Arrays;

public class Debug04 {
    //演示执行到下一个断点 同时支持动态下断点
    public static void main(String[] args) {
        int arr[] = {8,-1,199,70,10};
        //程序 追入sort的源码 底层如何实现  》debug方式追踪数据
        Arrays.sort(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i] + "\t");
        }
        System.out.println("hello100");
        System.out.println("hello200");
        System.out.println("hello300");
    }
}
