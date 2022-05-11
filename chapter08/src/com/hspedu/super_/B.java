package com.hspedu.super_;

public class B extends A{
    //访问父类的属性  但不能访问父类的private属性 [案例] super.属性名
    public void hi(){
        System.out.println(super.n1 + "n1" + super.n2 + "n2" + super.n3 );
    }
    //访问父类的方法  不能访问父类的private方法 super.方法名(参数列表)
    public void hello(){
         super.test100();
         super.test200();
         super.tes300();
    }
}
