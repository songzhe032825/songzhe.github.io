package com.hsp.edu.exception;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ClassCastException {
    public static void main(String[] args) {
        A b = new B(); //向上转型
        B b2 = (B)b;//向下转型
        //但是接下来这样写,行吗？
        C c2 = (C)b;//我希望把b对象转成C 不可以因为B C 都是A 子类,两者没关系
        //Exception in thread "main" java.lang.ClassCastException
    }
}
class A{}
class B extends A{}
class C extends A{}
