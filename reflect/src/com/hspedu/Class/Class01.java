package com.hspedu.Class;

import com.hspedu.Car;

/**
 * @author 宋哲
 * @version 1.0
 * 演示得到Class对象四大方式
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.类的全路径 编译阶段(第一阶段) Class.forName()
        String classAllPath = "com.hansedu.Car";//通过获取配置文件的方式获取
        Class<?> csl1 = Class.forName("com.hansedu.Car");
        //2.已知具体的类 直接通过类的Class 获取即可 类加载阶段(第二阶段)
        //多用于参数传递
        Class<Car> csl2 = Car.class;
        System.out.println(csl2);
        //3.获取class类对象  对象.getClass()
        //创建对象实例 获取Class对象 第三阶段(运行阶段)
        Car car = new Car();
        Class<? extends Car> csl3 = car.getClass();
        //4.类加载器【4种加载器】获取Class类对象
        //(1).先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass(classAllPath);//通过获取配置文件的方式获取
        System.out.println(cls4);
    }
}
