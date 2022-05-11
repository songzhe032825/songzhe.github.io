package com.hspedu.OOP_.Homework04;

public  class Staff extends Employee{
    private double bonus;
    public Staff(String name, double dateSal, int day, int grade) {
        super(name, dateSal, day, grade);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSal() {
        //普通员工工资 = 单日工资 * 天数 * 等级(1.0);
        System.out.println("普通员工信息名字和绩效 ：" + getName() +"奖金 ：="+
                bonus + getDateSal() +getDay() + getGrade());
        super.printSal();

    }
}
