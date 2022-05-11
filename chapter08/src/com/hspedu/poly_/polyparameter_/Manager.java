package com.hspedu.poly_.polyparameter_;

public class Manager extends Employee{
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, double sal, double bonus) {
        super(name, sal);
        this.bonus = bonus;
    }

    public void manager(){
        System.out.println("经理"  + getName() + "正在工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
