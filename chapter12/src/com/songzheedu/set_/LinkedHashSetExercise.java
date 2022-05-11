package com.songzheedu.set_;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author 宋哲
 * @version 1.0
 */
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        //必须要求两者都同才加不进去 缺一个都能加进去！！！！！！！
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥迪",1000));
        linkedHashSet.add(new Car("奥迪",12000));
        linkedHashSet.add(new Car("法拉第",1000));
        linkedHashSet.add(new Car("捷达",41000));
        linkedHashSet.add(new Car("奥迪",1000));
        linkedHashSet.add(new Car("保时捷",98761000));
        System.out.println("linkedHashSet =" + linkedHashSet);

    }
}
class  Car{
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

    //重写equals 和 hashcode
    //当name 和 price 相同时 就返回相同的 hashcode值  equals返回T
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
