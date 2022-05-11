package com.hspedu.OOP_.Homework03;

public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Professor("Tom",54,"正教授",1.3);
        Teacher associate = new Associate("Jerry",34,"副教授",1.2);
        Teacher lecture = new Lecture("Jordan",28,"讲师",1.1);
        teacher.introduce();
        associate.introduce();
        lecture.introduce();
    }
}
