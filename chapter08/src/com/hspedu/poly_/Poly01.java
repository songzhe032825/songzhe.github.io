package com.hspedu.poly_;

public class Poly01 {
    public static void main(String[] args) {
        Master master = new Master("Tom");
        Dog dog = new Dog("yellow", 3);
        Bone bone = new Bone("肉");

        master.feed(dog, bone);

        Cat cat = new Cat("小花猫",4);
        Fish fish = new Fish("草鱼");

        master.feed(cat,fish);
    }
}
