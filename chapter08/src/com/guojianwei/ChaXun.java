package com.guojianwei;

import com.song.Dog;

public class ChaXun {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog);//com.song.Dog@1540e19d hasdcode16进位

        //这种写法没问题
        com.use.Dog dog1 = new com.use.Dog();
        System.out.println(dog1);//com.use.Dog@677327b6

        System.out.println(Math.abs(-1));
    }

}
