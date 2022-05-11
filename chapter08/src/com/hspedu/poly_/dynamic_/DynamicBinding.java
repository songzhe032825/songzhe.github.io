package com.hspedu.poly_.dynamic_;

public class DynamicBinding {
    public static void main(String[] args) {
        //动态绑定机制 方法看运行类型  属性没有动态绑定机制
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}

class A{
    public int i =10;
    public int sum(){
        //当子类重写方法注销后 父类的getI() +10产生动态绑定机制 此时调用a.sum中的a 是运行类型中的B
        //调用子类中的getI()
        return getI() + 10;
    }

    public int sum1(){
        //属性没有动态绑定机制
        return i +10;
    }
    public int getI(){
        return i;
    }
}

class B extends A{
    public int i =20;
    public int sum(){
        return i+20;
    }

   /* public int sum1(){
        return i +10;
    }*/
    public int getI(){
        return i;
    }
}
