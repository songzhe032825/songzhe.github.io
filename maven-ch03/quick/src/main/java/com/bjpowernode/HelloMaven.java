package com.bjpowernode;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HelloMaven {

    public int add(int a,int b) {
       return a + b;
    }

    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(10, 20);
        System.out.println("res=" +res);
    }
}
