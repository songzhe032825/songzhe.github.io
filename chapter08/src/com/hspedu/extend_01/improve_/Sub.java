package com.hspedu.extend_01.improve_;

public class Sub extends Base{
    public Sub(){//无参构造器
        super();//隐藏了一个方法 默认调用的父类无参构造器  编译器的工作
        System.out.println("子类的Sub()构造器被调用...");
    }

    public Sub(String name,int age){
        //1.老师要调用父类无参构造器
        //super();//父类无参构造器 什么都不写默认就是调用super()
        //System.out.println("=====子类Sub(String name,int age)构造器被调用");
        //2.调用父类Base(String name) 构造器
        //super 必须在第一句话 哪怕是输出语句在前面也不行 会报错
        super("song");
        System.out.println("子类Sub(String name,int age)构造器被调用");
    }

    public void sayOk(){
        //非私有属性和方法可以在子类直接访问
        //但是私有属性和方法无法在子类直接访问 n4直接报错
        //要通过父类提供去访问
        System.out.println(n1 + " " +n2 +"" + n3 +"");
        test100();
        test200();
        test300();
       // test400();访问权力报错
        System.out.println("n4=" + getN4());
    }
}
