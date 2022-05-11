package com.hspedu.OOP_.Homework04;

//部门经理工资 = 1000 + 单日工资 * 天数 * 等级(1.2)
public  class Manager extends Employee{
    //特有属性  奖金
    private double  bonus;
    //创建Manager对象时，奖金是多少并不是确定的 因为老师在构造器中  不给bonus
    //可以通过setBonus
    public Manager(String name, double dateSal, int day, int grade) {
        super(name, dateSal, day, grade);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public void  printSal() {
        //部门经理工资 = 1000 + 单日工资 * 天数 * 等级(1.2)
        System.out.println("部门经理名字和奖金 ：=" + getName() +"工资 ：="+
        bonus + getDateSal() + getDay() + getGrade());
        super.printSal();
    }
}
