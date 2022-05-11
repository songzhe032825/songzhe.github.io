package com.hspedu.satitic;

public class codeBlockDetail04 {
    public static void main(String[] args) {
        //面试考点 重难点：我们看一下创建一个子类时(继承关系) 静态代码块
        //静态属性初始化 普通代码块 普通属性初始话 构造方法调用顺序是什么？
        /*1.类加载 父类的静态代码块和静态属性，优先级看定义的顺序执行
        * 2.类加载 子类的静态代码块和静态属性，优先级看定义的顺序执行
        * 3.父类的普通的代码块和属性 优先级看定义的顺序执行
        * 4.父类的构造方法
        * 5.子类的普通代码块和属性 优先级看定义的顺序执行
        * 6.子类的构造方法
        * */
        new B02();
    }
}

class A02{
    //静态属性
    private static int n1 = getVal01();
    //静态代码块
    static{
        System.out.println("A02是一个静态代码块");//(2)
    }
    //普通代码块
    {
        System.out.println("A02是一个普通代码块");//(5)
    }
    //普通属性
    private int n3 =getVal02();

    //静态方法
    public static int getVal01(){
        System.out.println("getVal01"); //(1)
        return 10;
    }
    //普通方法
    public int getVal02(){
        System.out.println("getVal02");//(6)
        return 10;
    }

    public A02(){
        //1.隐藏一个super 2.隐藏普通代码块
        System.out.println("A02是一个构造器");//(7)
    }
}
class B02 extends A02{
    //子类静态的属性
    private static int n3 =getVal03();

    //子类静态的代码块
    static{
        System.out.println("B02是一个静态代码块");//(4)
    }

    //子类的普通属性
    public int n5 = getVal04();

    //子类的普通代码块
    {
        System.out.println(" B02的第一个普通代码块");//(9)
    }

    //子类的静态方法
    public  static int getVal03(){
        System.out.println("getVal03()");//(3)
        return 10;
    }
    //子类的普通成员方法
    public int getVal04(){
        System.out.println("getVal04");//(8)
        return 10;
    }
    //子类的构造器
    public B02(){
        //1.super
        //2.隐藏了普通代码块
        System.out.println("B02的无参构造器");//(10)
    }
}
