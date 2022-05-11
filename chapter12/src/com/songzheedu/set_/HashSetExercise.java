package com.songzheedu.set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HashSetExercise {
    /*定义一个Employee类 该类包括：private成员属性name age要求
     *1.创建3个Employee放入 HashSet中
     *2.当name 和 age 的值相同时 认为是相同员工 不能添加到HashSet集合中
     * */
    public static void main(String[] args) {
        HashSet hashset = new HashSet();
        //无序的
        hashset.add(new Employee("milan",22));//ok
        hashset.add(new Employee("smith",52));//ok
        hashset.add(new Employee("milan",22));//不ok
        hashset.add(new Employee("jordan",24));//不ok
        hashset.add(new Employee("carter",25));//不ok
        hashset.add(new Employee("Yao",26));//不ok
        hashset.add(new Employee("Yao",27));//不ok
        System.out.println("hashSet =" + hashset);
    }
}
class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//如果name 和 age 值相同 则返回相同的hashcode值

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}