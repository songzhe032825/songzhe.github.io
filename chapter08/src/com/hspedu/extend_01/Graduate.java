package com.hspedu.extend_01;
//大学生类  模拟大学生考试的简单情况
public class Graduate {
    public String name;
    public int age;
    private double score;

       public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void testing(){
        System.out.println("大学生"  + name + "正在考大学数学" );
    }
    public  void  showInfo(){//和pupil不一样
        System.out.println("大学生名字" + name + "年龄" + age + "成绩" +score);
    }
}

