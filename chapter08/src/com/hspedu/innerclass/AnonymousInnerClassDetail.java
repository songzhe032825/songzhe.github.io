package com.hspedu.innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {//外部其他类
        // Outer05.this指的是outer05的对象 谁调用的f1() Outer05.this就是谁!!
        //用hashcode 来验证
        Outer05 outer05 = new Outer05();
        //创建实例对象调用f1()
        outer05.f1();
    }
}

class Outer05{
    private int n1 = 88;
    public void f1(){
        //创建基于类的匿名内部类
        //第一种调用方法
        //4.不能添加访问修饰符 因为他的地位本身就是局部变量 public new Person(){}很明显报错
        //5.作用域：只能在定义他的方法或代码中
        Person person = new Person(){
            //细节 如果没有重写hi() 那么根据继承关系就会找到下面Person类
            //输出System.out.println("person! hi~");
            @Override
            public void hi() {
                //3.可以直接访问外部类的所以成员 包括私有的
                System.out.println("匿名内部类重写了hi方法 n1 =" + n1 + "外部类的类名 n1= "+
                        Outer05.this.n1);
            }
        };
        person.hi();//1.动态绑定 真实的运行类型是Outer05$5 意味着真正找到的
        //是System.out.println("匿名内部类重写了hi方法");  并不是编译类型Person
        //中的hi() System.out.println("person! hi~");

        //2.第二种调用方法 也可以直接去调用  跟第一种匿名内部类不一样
        new Person(){
            //细节 如果没有重写hi() 那么根据继承关系就会找到下面Person类
            //输出System.out.println("person! hi~");
            @Override
            public void hi() {
                System.out.println("匿名内部类第二种重写了hi方法");
            }
            //匿名内部类本质还是个对象,我不管你写的有多复杂就本身来说就是个对象
            //既然是个匿名内部类对象就可以直接调用hi()方法 小括号里可以传参

            //小括号里可以传参 调用ok方法


            @Override
            public void ok(String str) {
                System.out.println("传参str");
                super.ok(str);
            }
        }.ok("sky");

        System.out.println("person 的匿名内部类的名称" + getClass());
    }
}

class Person{
    public void hi(){
        System.out.println("person! hi~");
    }
    public void ok(String str){
        System.out.println("Person ok() " + str);

    }
}