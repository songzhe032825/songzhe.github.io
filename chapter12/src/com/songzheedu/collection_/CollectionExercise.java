package com.songzheedu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
public class CollectionExercise {
    public static void main(String[] args) {
        /*1.创建3个Dog(name age)对象 放入到ArrayList中 赋给List引用
        * 2.用迭代器和增强for循环两种方式来遍历
        * 3.重写Dog的toString 方法输出name 和 age
        * */
        List list = new ArrayList();
        list.add(new Dog("旺财",3));
        list.add(new Dog("二哈",5));
        list.add(new Dog("雪橇",1));
        //第一种 迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println("dog =" + dog);
        }
        //第二种 增强for循环
        for (Object dog :list) {
            System.out.println(dog);
        }
    }
}
class Dog{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
