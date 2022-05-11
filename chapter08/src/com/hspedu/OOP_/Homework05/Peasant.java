package com.hspedu.OOP_.Homework05;

public class Peasant extends Employee{
    public Peasant(String name, double dateSal, int day, int grade) {
        super(name, dateSal, day, grade);
    }

    @Override
    public void printSal() {
        System.out.println("名字 :" + getName() + "年终奖 ：" + getDateSal() *
         getDay() * getGrade());
        super.printSal();
    }
}
