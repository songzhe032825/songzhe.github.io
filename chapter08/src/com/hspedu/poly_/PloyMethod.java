package com.hspedu.poly_;

public class PloyMethod {
    //多态具体表现分两种 ： 方法  和   对象（重难点  核心）
    // 这里先说  方法多态
    //知识点1：方法重载体现多态
    //这里我们传入不同的参数  就会调用sum 方法 就体现多态
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.sum(10,20));
        System.out.println(a.sum(20,35,55));
    //知识点2 ：方法重写也体现多态
    //对象不同导致调用方法也不同
           B b = new B();
           a.say();
           b.say();
    }
}

class B{
    public void say(){
        System.out.println("B say() 方法被调用");
    }
}

class A extends B{
    //方法重载
    public int sum(int n1,int n2){
        return n1 + n2;
    }
    public int sum(int n1 ,int n2, int n3){
        return  n1 +n2 + n3;
    }
      public void say(){
        System.out.println("A say() 方法被调用");
    }
}
