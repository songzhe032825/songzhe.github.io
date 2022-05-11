package com.hsp.edu.array_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ArrayToString {
    public static void main(String[] args) {
        Integer[] integer ={1,20,345};
        //传统方法 遍历数组
       for (int i = 0; i < integer.length; i++) {
            System.out.println(integer[i]);
        }
        //太麻烦了 Arrays提供了Arrays.toString() 显示数组信息
        System.out.println(Arrays.toString(integer));
        //传统排序 可以写冒泡 但是太麻烦了 可以直接使用Arrays提供的
        //1.sort方法排序即可  而且数组是引用类型 通过sort排序之后  会直接影响到实参结果arr
        //2.sort重载的，也可以通过传入一个接口 Comparator实现定制排序
        Integer arr[] = {1,234,45,33333,2};
        //Arrays.sort(arr);//这个是默认排序方法  不是定制排序
        //先注销默认方法 定制排序  <Integer>:这个是泛型 后面会讲
        //3.Arrays调用定制排序时 传入俩个参数 第一个是arr数组 第二个是实现Comparator接口的匿名内部类 要求实现
        //compare方法
        //4.先演示效果 再解释 这里体现了接口一种方式 下断点 看源代码
        Arrays.sort(arr, new Comparator() {//先把泛型删了 默认Object类
            @Override
            public int compare(Object o1, Object o2) {
                //向下转型转成Integer类 i1 对象
                Integer i1 = (Integer)o1;
                //向下转型转成Integer类 i2
                Integer i2 = (Integer)o2;
                return i2-i1;
                //return i1-i2;也可以输出效果不一样
            }
        });
        System.out.println("=========排序之后=========");
        System.out.println(Arrays.toString(arr));
    }
}
