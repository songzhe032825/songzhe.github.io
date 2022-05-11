package com.hsp.edu.Wrapper;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Integer01 {
    public static void main(String[] args) {
        //演示int <----> Integer(n1)
        //jdk5前是手动装箱和拆箱
        //手动装箱 int <-----> Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        //手动拆箱  正常来说，基本数据类型无法直接转换成包装类 但是为何却能实现？
        //理由：其实这里地城代码使用的是Integer.ValueOf(n1);依然是Integer包装类
        //的ValueOf()方法。本质上是依旧是手动装箱 只是系统帮你完成了
        //Integer  --> int
        int i = integer.intValue();

        //jdk5之后  自动装箱  int ----> Integer
        int n2 = 200;
        Integer integer2 = n2;

        //自动拆箱   Integer --->  int
        //按理说：包装类对象无法直接转换成基本数据类型 但底层代码 intValue()方法实现了
        int n3 = integer2;

    }
}
