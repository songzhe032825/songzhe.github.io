package com.hspedu.extend_.exercise;

public class ExtendsExercise01 {
    public static void main(String[] args) {
        B b = new B();
        //输出结果 ： a b name b
    }
}
    class A {
    //3.走到这里先输出“a”
        A() {
            System.out.println("a");
        }

        A(String name) {
            System.out.println("a name");
        }
    }

    class B extends A {
    //1.根据创建对象B()流程先找到这里 然后this("abc") 这个关键字会调用本类的构造器B(String name )
        B() {
            this("abc");//<3>
            //5.最后输出这句话 b
            System.out.println("b");
        }
//2.走到这里 会有一个隐藏条件super() 方法去调用父类A
        B(String name) {
            super(); //<1>
            //4.在输出b name
            System.out.println("b name");//<2>
        }
    }


