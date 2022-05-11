package com.hspedu.houserent_.utils;

public class TestUtility {
    public static void main(String[] args) {
        //这是一个测试类  使用完毕后 就可以删除了
        //要求输入一个字符串 长度最大为3
        String s = Utility.readString(3);
        System.out.println("s= " + s);
        String s2 = Utility.readString(10,"songzheed");
        System.out.println("s2=" + s2);
    }
}
