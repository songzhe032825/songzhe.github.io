package com.hspedu.OOP_.Homework10;

public class Doctor {
    /*编写Doctor类 name age job gender sal 相应的getter 和 setter 方法
    5个参数的构造器  重写父类的equals方法： public boolean equals(Object obj)
    并判断测试类中创建的两个对象是否相等  相等就是判断属性是否相等
    * */

    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", gender=" + gender +
                ", sal=" + sal +
                '}';
    }

    public boolean equals(Object obj){
        //判断两个对象是否相同
        if(this == obj){
            return true;
        }
        //判断 obj 是否是Doctor类型或子类
        //过关斩将  校验方式
        if(! (obj instanceof Doctor)){//运行类型不是Doctor的话
            return false;
        } else {
            //向下转型  因为obj的运行类型是Doctor 或者其子类类型
            Doctor doctor = (Doctor) obj;
            //比较属性
            return this.name.equals(doctor.name)  &&  this.age == doctor.age
                    && this.job.equals(doctor.job) && this.gender == doctor.gender
                    && this.sal == doctor.sal;
        }
    }
}
