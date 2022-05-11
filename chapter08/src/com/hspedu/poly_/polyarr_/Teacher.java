package com.hspedu.poly_.polyarr_;

public class Teacher extends Person{
    private double sal;

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Teacher(String name, int age, double sal) {
        super(name, age);
        this.sal = sal;
    }

    @Override
    public String say() {
        return super.say()  +  "sa;"  + sal;
    }
    public void teach(){
        System.out.println("老师在" + getName() + "叫Java");
    }
}
