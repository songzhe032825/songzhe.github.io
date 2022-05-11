package com.hspedu.poly_.detail_;

public class Cat extends Animal{
    @Override
    public void eat() {
        super.eat();
        System.out.println("猫吃鱼");
    }
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
