package com.hspedu.singleton;

public class SingleTon02 {
    public static void main(String[] args) {
        Cat instance = Cat.getInstance();
        System.out.println(instance);
        System.out.println(Cat.n1);
        //再次调用getInstance()
        Cat instance1 = Cat.getInstance();
        System.out.println(instance1);
        //判读是否是同一个对象
        System.out.println(instance == instance1);
    }
}
//懒汉式的单例模式

//需求：希望在程序运行过程中,只能创建一个Cat对象
class Cat{
    private String name;
    public static int n1 =999;
    /*1.仍然私有化构造器
    *2.定义一个Static静态属性对象
    *3.提供一个公共的静态方法 返回cat对象。
    * 4.懒汉式 只有当用户使用getInstance时 才返回cat对象
    * */
    //这里不能new 如果new了就是饿汉式
    private static Cat cat;

    //在getInstance()里判断是否有对象 并创建
    public static Cat getInstance(){
        if(cat == null){//如果没有创建猫对象 
            //那就创建一下
            cat = new Cat("小可爱");
        }
        return cat;
    }
    //这样保证外面无法new
    private Cat(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}


