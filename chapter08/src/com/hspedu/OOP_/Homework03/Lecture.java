package com.hspedu.OOP_.Homework03;

public class Lecture extends Teacher{
    public Lecture(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }
    public void  introduce(){
        System.out.println(super.getName()+ super.getAge() +super.getPost()+super.getSalary());
    }
}
