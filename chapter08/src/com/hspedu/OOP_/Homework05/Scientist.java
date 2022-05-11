package com.hspedu.OOP_.Homework05;

public class Scientist extends Employee{
    private double yearEndBonus;
    public Scientist(String name, double dateSal, int day, int grade) {
        super(name, dateSal, day, grade);
    }

    public double getYearEndBonus() {
        return yearEndBonus;
    }

    public void setYearEndBonus(double yearEndBonus) {
        this.yearEndBonus = yearEndBonus;
    }

    @Override
    public void printSal() {
        System.out.println("名字 ：" + getName() + "年终奖 ：" +
                yearEndBonus + getDateSal() * getDay() * getGrade());
        super.printSal();
    }
}
