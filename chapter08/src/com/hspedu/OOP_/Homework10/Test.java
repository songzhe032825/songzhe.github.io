package com.hspedu.OOP_.Homework10;

public class Test {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("has",20,"程序员",'女',35000);
        Doctor doctor2 = new Doctor("has",20,"程序员",'女',35000);
        //equals 重写方法的考察
        System.out.println(doctor1.equals(doctor2));
    }
}
