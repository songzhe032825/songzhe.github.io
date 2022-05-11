package com.hspedu.innerclass;

public class AnonymousInnerClass {
    //匿名内部类
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        //老虎在哭
        outer04.method();
    }
}
class Outer04{//外部类
    private int n1 =10;//属性

    public void method(){ //方法下
        //基于接口的匿名内部类  解读
        //1.想要使用实现A接口  并创建对象？传统写法 比如Tiger
        //2.创建传统tiger对象 有多态体现  而且要在外部类去实例化并调用method()
        //3.问题来了,我不想创建Tiger对象 并创建一次后面就不用了 很浪费，怎么办？
        //4.可以使用匿名内部类去简化开发效率：思路！我不想创建Tiger但是还想显示"老虎在哭"
        //核心来了：编译类型和运行类型要搞懂就可以了
        //5.Tiger的编译类型是?IA 接口类型
        //6.Tiger的运行类型是?(重点) 匿名内部类 XXXX 名字就是外部类加上$1=> Outer04$1
        /*
        * 我们看底层原码匿名内部类  并且会分配名称类名：Outer04$1
        * class XXXX implements IA{
        *     @Override
            public void cry() {
                System.out.println("老虎叫唤");
            }
        * }
        *
        * */
        /*IA tiger = new Tiger();
        tiger.cry();*/
        //7.jdk底层在创建匿名内部类 Outer04$1 立即马上就创建了Outer04$1的实例，并且把地址返回给tiger
        //8.匿名内部类使用一次不能使用了，但是tiger对象可以反复使用反复调用
        //这里创建多态实例化写法
        IA tiger = new IA(){
            //重写实现接口A的cry()方法
            @Override
            public void cry() {
                System.out.println("老虎叫唤");
            }
        //这里括号外有分号
        };
        //此时用tiger对象调用cry()方法
        tiger.cry();
        //我就想看tiger运行类型的名称 tiger.getClass() 就是获取该对象的运行类型
        System.out.println("tiger运行类型的名称" + tiger.getClass());//Outer04$1

        //演示基于类的匿名内部类 需要传参
        //分析：1.不加{}就是实例Father对象 但是加了{}那就是匿名内部类
        //2.father 编译类型 是Father
        //3.father运行类型是 ：匿名内部类 Outer04$2(顺序编号 )
        //4.同时也返回了  匿名内部类 Outer04$2
        //5.注意（"JACK"）这个实参会自动传给Father的构造器
        //6.在匿名内部类中无法创建构造器  因为类名是系统默认给的类名不知道无法创建
        Father father = new Father("JACK"){
            @Override
            public void test() {
                super.test();
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("father对象的运行类型="  + father.getClass()); //Outer04$2
        father.test();

        //基于抽象的匿名内部类 运行类型的名称Outer04$3
        Animal animal =  new Animal(){
            //记住【必须实现抽象类中的方法】 然后用animal去接受
            @Override
            void eat() {
                System.out.println("吃饭了吗？");
            }
        };
        animal.eat();
        System.out.println("朕想看看Animal的运行类型" + animal.getClass());//Outer04$3
    }
}

interface IA{ //接口
    public void cry();
}

/*class Tiger implements IA{

    @Override
    public void cry() {
        System.out.println("老虎在哭");
    }
}*/


class Father{ //类
    public Father(String name) { //构造器
        super();
        System.out.println("接受到了JACK的name" + name);
    }
    public void test(){//方法

    }
}
abstract class  Animal{
    abstract void eat();//不要加访问修饰符
}