package com.hspedu.OOP_.Homework05;

public class Teacher extends Employee{
    private double dateBone;
    public Teacher(String name, double dateSal, int day, int grade) {
        super(name, dateSal, day, grade);
    }

    public double getDateBone() {
        return dateBone;
    }

    public void setDateBone(double dateBone) {
        this.dateBone = dateBone;
    }

    @Override
    public void printSal() {
        System.out.println(" 名字 ：" + getName() + "年终奖 ：" +dateBone
         + getDateSal() * getDay() * getGrade());
        //不能重写super方法 因为老师工资不是按找父类员工计算的 所以自己写即可
        super.printSal();
    }
}
