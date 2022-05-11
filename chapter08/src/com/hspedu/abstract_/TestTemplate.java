package com.hspedu.abstract_;

public class TestTemplate {
    //需求：有多个类  完成不同的任务job
    //要求能够得到各自完成任务时间
    //请编程实现

    public static void main(String[] args) {
        AA aa = new AA();
        aa.calculateTimes();//打断点 oop多态机制

        BB bb = new BB();
        bb.calculateTimes();
    }
}
