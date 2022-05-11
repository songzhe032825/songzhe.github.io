package com.hspedu.extend_01;
//小学生
public class Pupil {
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
        System.out.println("小学生"  + name + "正在考小学数学" );
    }
    public  void  showInfo(){
        System.out.println("小学生名字" + name + "年龄" + age + "成绩" +score);
    }
}
