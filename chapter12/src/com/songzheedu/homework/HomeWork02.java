package com.songzheedu.homework;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {
        /*使用ArrayList完成对象 Car(name String) 的各种操作
        *
        * */
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Car("宝马",4444));
        arrayList.add(new Car("宾利",3333333));
        arrayList.add(new Car("奔驰",63333333));
        arrayList.add(new Car("夏利",43333333));
        arrayList.add(new Car("菲尔普",53333333));

        arrayList.remove("宝马");
        arrayList.contains("宾利");
        int size = arrayList.size();
        System.out.println("size =" + size);
        //放集合进去
        arrayList.containsAll(arrayList);

        //增强for循环
        for (Object o :arrayList) {
            System.out.println("o =" + o);
        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("next = " + next);
        }
    }
}
class Car{
   private String name;
   private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}