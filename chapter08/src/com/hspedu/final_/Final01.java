package com.hspedu.final_;

public class Final01 {
    public static void main(String[] args) {
       //请编写一个程序  能够计算圆形的面积 要求圆周率为3.14 赋值的位置时3个方式都写一下
        Circle circle = new Circle(5.0);
        System.out.println(circle.calArea());
    }
}

class Circle{
    //final 初始值的三种方式写法
    private double radius;

    //1.定义中赋值 最常用
    private final double PI=31.4;
    //2.构造器赋值
    public Circle(double radius) {
        this.radius = radius;
        //PI=3.13;
    }
    //3.代码块赋值
    {
        //PI=3.14；
    }
    public double calArea(){
        return PI * radius * radius;
    }
}


