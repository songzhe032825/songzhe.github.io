package com.hspedu.extend_01.improve_;

//父类  是Pupil 和 Graduate的父类
public class Student {

    public String name;
    public int age;
    private double score;
    //共有的方法
    public void setScore(double score) {
        this.score = score;
    }
    public  void  showInfo(){//和pupil不一样
        System.out.println("大学生名字" + name + "年龄" + age + "成绩" +score);
    }
}


