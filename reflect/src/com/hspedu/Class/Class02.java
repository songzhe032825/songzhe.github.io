package com.hspedu.Class;

import com.hspedu.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 宋哲
 * @version 1.0
 * 演示Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        String classAllPath = "com.hspedu.Car";
        //1.获取到Car类 所对应的Class对象
        //<?> 表示不确定的Java类型
        Class<?> aClass = Class.forName("com.hspedu.Car");
        System.out.println(aClass);//aClass显示哪一个类的Class对象 om.hspedu.Car
        System.out.println(aClass.getClass());//运行类型 Java.lang.Class
        //2.包名
        System.out.println(aClass.getPackage().getName());//com.hspedu
        //3.得到全类名
        System.out.println(aClass.getName());//com.hspedu.Car
        //4.获取创建到Car的实例
        Car car = (Car) aClass.newInstance();
        //5.通过反射得到属性
        Field brand = aClass.getField("brand");
        //6.通过反射我想给属性赋值 set
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));
        //7.遍历所有属性字段获取
        Field[] fields = aClass.getFields();
        for ( Field f  :fields) {
            System.out.println(f.getName());//依次输出字段属性
        }
        //私有属性会报错 获取私有属性后面说
        System.out.println(brand.get(car));//通过brand拿到car的名字 “宝马”
        //进行反射
        Method hi = aClass.getMethod("hi");
        //通过方法名对象.对象名
        Object invoke = hi.invoke(car);
    }
}
