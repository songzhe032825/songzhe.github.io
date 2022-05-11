package com.hspedu.innerclass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        //在主方法中调用 Outer08外部类下的平行的方法t1() 即可
        outer08.t1();
        //4.外部其他类 访问成员内部类的三种方式！！！！
        //第一种方式 ：外部类的对象去调用Inner08的实例化对象即可 老韩解读：
        //new Inner08()他其实在Outer08的内部 相当于Outer08的一个成员
        // 所以必须这样定义outer08.new Inner08(); 这是语法 规定
        Outer08.Inner08 inner08 = outer08.new Inner08();

        //第二种方式： 在外部类中 编写一个方法可以返回一个Inner08的实例
        //参考写过的t1()方法
    }
}
class Outer08{ //外部类
    private int n1 = 10;
    public String name = "张三";
    //定义个私有方法
    private void hi(){
        System.out.println("hi()方法 ...");
    }
    //区别:有没有发现Inner08这个成员内部类并没有定义在局部内 比如方法内或者代码块内
    //2.可以添加任意访问修饰符比如公共的 受保护的 默认的 私有的；因为成员变量可以添加
    //访问属性 成员内部类也是成员变量凭什么不能添加呢！
    // 举例子 ： private class Inner08{}
    public class Inner08{ //成员内部类
        public double sal = 99.9;
        private int n1 = 20;
        public void say(){
             double money =88.0;
            //可以直接访问外部类所以成员 包括私有的
            System.out.println("Outer外部 的 n1 =" + Outer08.this.n1
                    + "Outer 的 name ="  +name + "say方法的 money" + money);
            //私有方法 直接拿来使用
            hi();
        }
    }
    //在Outer08写个方法 可以直接使用
    public void t1(){
        //因为Inner08是一个成员  所以在外部类中的t1()可以直接拿来使用
        //3.创建成员内部类的对象实例化Inner08 并调用say()
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }
}
