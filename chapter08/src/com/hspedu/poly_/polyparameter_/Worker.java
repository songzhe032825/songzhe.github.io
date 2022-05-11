package com.hspedu.poly_.polyparameter_;

public class Worker extends Employee{
    public Worker(String name, double sal) {
        super(name, sal);
    }
    public void worker(){
        System.out.println("工人"  + getName() + "正在工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() ;
    }
}
