package com.hspedu.interface_;

//外部其他类 与class Outer 平级
public class InnerClass01 {
    public static void main(String[] args) {
        //演示一把
        Outer outer = new Outer(100);
        outer.m1();
        //验证outer的hashcode  和  Outer.this的hashcode  地址是不是一样的
        //Outer@1540e19d  地址一样证明这里的值已经传到里面去了
        System.out.println("outer hashcode="  + outer);
    }
}

class Outer{
    private int n1;//属性
    private void m2(){}//私有方法
    public Outer(int n1) { //构造器
        this.n1 = n1;
    }

    public void m1(){//方法
        System.out.println("m1()");

        //内部类  在Outer类的内部  内部类东西细节太多了
        //1.局部内部类定义在局部位置 通常在方法中
        //3.不能添加访问修饰符 比如public不可以 【但是可以使用final修饰】就代表Inter不能被继承了
        //4.作用域：仅仅在定义他的方法或代码块中实现

        class Inter{ //内部类本质还是个类
            //2..可以直接访问外部类的[所有成员] 包含私有属性
            private int n1 =800;//此时内部类的属性n1 和外部类的n1重名 遵循就近原则
            public  void  f1(){
                //5.局部内部类可以直接访问外部成员  比如下面形式 外部类的n1 和 m2()
                //7.如果外部类和局部内部类重名时 遵循就近原则  如果想访问外部类成员 则可以使用
                //(外部类名.this去访问)
                //访问外部类Outer私有属性n1 包括私有方法
                //但是我就想访问外面属性n1=100 怎么办呢？ 【外部类名.this.成员】 ”为啥加this 因为不是静态的“
                //老韩解读Outer.this 本质就是外部类的对象 去调用成员属性 即哪个对象调用m1() Outer.this就是谁的对象
                System.out.println("Outer.this hashcode="  + Outer.this);//hashcode对象16进制地址Outer@1540e19d
                System.out.println("n1=" + n1 + "外部类的n1= " +Outer.this.n1);//800  遵循就近原则
                m2();
            }
    }
        //外部类如何使用内部类Inter呢？
        //6.答：[外部类在方法m1()中] 可以创建 Inter的对象 并调用方法
        new Inter().f1();
    //代码块
    {
        System.out.println("这是代码块");
    }

    }
}
