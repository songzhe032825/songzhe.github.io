package com.hspedu.modifier;

//知识点：在B类里创建A对象去访问A类 因为在同一个包modifier下 就不需要引了 ，在不同的包下需要引入
public class B {
    public void say(){
        A a = new A();
        //在同一个包下 不同的类里面可以访问 public protected 和 默认修饰符属性或方法 无法访问私有的属性或方法
        System.out.println("n1=" +a.n1 + "n2=" +a.n2 + "n3=" +a.n3);
        a.m3();
        a.m2();
        a.m1();
    }
}
