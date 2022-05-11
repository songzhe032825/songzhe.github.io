package com.hspedu.innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();

        //6.外部其他类 使用静态内部类如何访问 有几种方式???
        //第一种方式：通过类名访问遵守访问权限问题 --私有不行
        // [外部类名.静态内部类名，但是静态内部类名私有无法访问]
        Outer.Inner02 inner02 = new Outer.Inner02();
        inner02.say();
        //第二种方式 ：编写一个方法 可以返回静态内部类的实例
        outer.getInner02();
    }
}
class Outer{
    private int n1 = 10;
    private static String name = "张三";
    private static void cry(){
        System.out.println("哭了");
    }
    //1.放在外部类的成员位置  而且关键字是static修饰
    //3.静态内部类是成员就会被访问修饰符修饰  public static class Inner02{}
    //4.作用域在整个类体
    public static class Inner02{
        private static String name = "张三";
        public void say(){
            //注意这里访问外部类的属性 千万不能加this 因为它是static
            System.out.println(Outer.name);
            //2.不能直接访问外部类的非静态成员 n1 不是静态属性
           // System.out.println(n1);报错
            //5.可以访问外部类所以静态成员 包括私有的比如静态方法cry();
            // 不能访问非静态的成员
            cry();
        }
    }
    public void show(){
        //外部类使用内部类
        new Inner02().say();
    }
    //编写一个方法 返回实例 Inner02
    public Inner02 getInner02(){
        return new Inner02();
    }
}
