package com.hspedu.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {

        //向上转型：父类的引用指向了子类的对象
        //语法：父类类型引用名  = new 子类类型();
        Animal animal  =  new Cat();
        System.out.println("ok");

        //可以调用父类的所有成员(须遵守访问的权限)
        animal.run();

        //但是不能调用子类特有成员的catchMouse 方法 因为在编译阶段  能调用那些成员是由编译类型决定的
        //最终的运行效果看子类(运行类型)的具体实现  即调用方法时，按照从子类中查找方法开始调用 跟继承一样
        animal.eat();
        animal.show();
        animal.sleep();
        //animal.catchMouse();就是多态的向下转型
        /*语法：子类类型  引用名  = (子类类型)  父类引用
        * 只能强转父类的引用   不能强转父类的引用
        * 要求父亲的引用必须指向的时当前目标类型的对象
        * 可以调用子类类型中所有的成员
        * */
        //意思就是把父类的引用animal 重新转回成子类的引用 cat
        //编译类型左边是cat  运行类型是强转后的子类引用(Cat)  animal
        Cat cat =(Cat) animal;
        //cat 的编译类型是 cat 运行类型是cat
        cat.catchMouse();
        System.out.println("ok~~");
    }
}
