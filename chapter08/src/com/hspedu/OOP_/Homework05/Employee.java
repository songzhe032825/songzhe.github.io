package com.hspedu.OOP_.Homework05;

public class Employee {
    private String name;
    private double DateSal;
    private int day;
    private int grade ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDateSal() {
        return DateSal;
    }

    public void setDateSal(double dateSal) {
        DateSal = dateSal;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Employee(String name, double dateSal, int day, int grade) {
        this.name = name;
        DateSal = dateSal;
        this.day = day;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", DateSal=" + DateSal +
                ", day=" + day +
                ", grade=" + grade +
                '}';
    }

    public void printSal() {
        System.out.println("name :" + name + "年工资是 ：" +DateSal * day *grade);
    }
}