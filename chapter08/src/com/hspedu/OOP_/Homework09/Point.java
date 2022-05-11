package com.hspedu.OOP_.Homework09;

public class Point {
    /* 设计一个Point类 其x 和 y 坐标可以通过构造器提供。提供一个子类LabeledPoint
    其构造器接受一个标签值和x,y坐标 比如new LabeledPoint("Black",1929,230,07),
    写出对应的构造器即可
     */
    private double X;
    private double Y;

    public Point(double x, double y) {
        this.X = x;
        this.Y = y;
    }
}
