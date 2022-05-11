package com.hspedu.pkg;

import com.hspedu.modifier.A;
//在不同的包下面访问不同的类 就会引入包
public class Test {
    public static void main(String[] args) {
        A a = new A();
        //为何只引出n1呢？ 结论：在不同的包下可以访问 public 修饰的属性或方法
        //无妨访问protected 默认 private修饰的属性或方法
        System.out.println(a.n1);
        a.m1();
    }
}