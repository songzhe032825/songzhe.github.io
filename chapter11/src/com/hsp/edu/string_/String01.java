package com.hsp.edu.string_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class String01 {
    public static void main(String[] args) {
        //1.String对象用于保存字符串中 也就是一组序列
        //小细节："Jack"是字符串常量 双引号引起的字符序列  name 是字符串变量
        //2.字符串的字符使用Unicode字符编码，一个字符(不区分字母还是汉字)占两个字节
        //3.String 类有很多构造器 构造器的方法重载
        //4.String 是final 类 不能被其他的类继承
        //5.String 有属性 private final char value[] 用于存放字符串内容
        //6.value 是一个final类型 不可以修改(地址) 即：value 不能指向新的地址
        //但是单个字符内容是可以变化的 举例子
        String name = "Jack";
        name = "tom";

        final char[] value = {'a','b','c'};
        value [0] ='h';//修改某一个值可以
        //但是修改地址就不可以
        char[] v2 = {'r','t','y'};
        //value = v2;报错 不能给这个数组分配新的value


     }
}
