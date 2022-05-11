package com.hspedu.poly_;

public class Master {
    public String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //完成主人给狗 喂食 骨头
    public void feed(Dog dog,Bone bone){
        System.out.println("主人"  +  name +"给" +dog.getName() + "吃" +bone.getName());
    }
//本类 方法重载

    //主人给 小猫 为黄花鱼
    public void feed(Cat cat,Fish fish){
        System.out.println("主人"  +  name +"给" +cat.getName() + "吃" +fish.getName());
    }
}
