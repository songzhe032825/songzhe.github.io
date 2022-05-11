package com.songzheedu.improve;

/**
 * @author 宋哲
 * @version 1.0
 */
public class CustomMethod {
    //泛型就是可以接受数据类型的一种数据类型引用
    public static void main(String[] args) {
        Car car = new Car();
        //3000.0,35f 会自动装箱 成包装类 因为泛型是引用类型而不是数据类型
        car.fly("宝马",3000.0,35f);//当调用方法时 传入参数编译器就会确定类型
        //给泛型创建对象时候在<>内部就最好确定引用类型
        Fish<String, Integer> fish  = new Fish<>();
        fish.cry(2365.0,'a');
    }
}

//泛型方法  可以定义普通类  也可以定义泛型类
class Car{
    public void run(){//普通方法

    }
    //说明：1. T R U 是泛型  2.泛型是给fly方法使用的
    public <T,R,U> void fly(T t,R r, U u){//泛型方法
        System.out.println(t.getClass());//class java.lang.String
        System.out.println(r.getClass());//这里实参3000.0会自动装箱后成为Double
        System.out.println(u.getClass());
    }

}
class Fish<T,R>{//泛型类
    //普通方法
    public void run(){

    }
    //泛型方法 必须使用
    public <Q,W> void cry(Q q, W w){
        System.out.println(q.getClass());
        System.out.println(w.getClass());
    }
    //说明 hi()不是泛型方法 没有<>的标识符！！！！而是hi方法使用类声明的泛型
    public void hi(T t,R r){

    }
}

