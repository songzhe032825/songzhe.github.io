package com.songzheedu.set_;

import java.util.HashSet;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HashSet01 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        System.out.println("set =" + set);
        set.add("lucy");//可以添加
        set.add("lucy");//加不进去
        set.add(new Dog("tom"));//可以添加
        set.add(new Dog("tom"));//可以添加 因为是不同的对象 只是名字一样
        System.out.println("set =" + set);

        //在加深一下 ，非常经典的面试题
        //看源码分析 add到底发生了什么？ 为何add机制使得底层元素变成重复的了
        set.add(new String("hsp"));//ok
        set.add(new String("hsp"));//这里会不会成功？结论加入不了！！
        System.out.println("set=" + set);

    }
}
class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
