package com.hsp.edu.array_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ArraySortCustom {
    //定制排序练习代码 很重要
    public static void main(String[] args) {
        int arr [] = {23,4,-5267,-25,1,9 };
        //调方法bubble02 定制排序 传两个参数(数组arr,匿名内部类)
        // Comparator()会找下面的接口Comparator去调用方法
        bubble02(arr, new Comparator() {
            @Override
            //解读代码Object o1会找下面compare方法内的arr[j],Object o2--》arr[j+1]
            //进行传参
            public int compare(Object o1, Object o2) {
                //把o1数组对象通过向下转型，把编译类型转为Integer 然后通过自动拆箱
                //把Integer转为int类型
                int i1 = (Integer)o1;//拆箱
                int i2 = (Integer)o2;
                return i1-i2; //return i2 - i1
            }
        });
        System.out.println("=====排序后=====");
        System.out.println(Arrays.toString(arr));
    }
    //结合冒泡 + 定制排序 Comparator c接口
    public static void bubble02(int [] arr, Comparator c){
        int temp = 0;
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = i; j < arr.length-1-i; j++) {
                //这里是修改的关键 通过接口Comparator来调用底层方法compare
                if(c.compare(arr[j] ,arr[j+1])>0){
                    temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
