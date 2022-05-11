package com.hspedu.interface_;

public class Interface02 {
    public static void main(String[] args) {

    }
}

//必须在A类里实现这个hi()的抽象方法  implements ：实现
class A implements AInterface{
    @Override
    public void hi() {
        System.out.println("hi........");
    }
}