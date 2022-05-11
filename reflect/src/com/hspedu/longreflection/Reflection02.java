package com.hspedu.longreflection;

import com.hspedu.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 宋哲
 * @version 1.0
 * 反射的调用优化
 */
@SuppressWarnings({"all"})
public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        m1();
        m2();
        //Field() 成员属性/字段
        //Method() 方法
        //Constructor //构造器
        m3();//优化后
    }
    
    //传统方法
    public static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i <900000; i++) {
            cat.hi();
        }
        long end =System.currentTimeMillis();
        System.out.println("传统方法调用hi 耗时=" + (end - start));
    }
    //反射机制调用方法
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //不需要Cat类去创建了 用Class类去创建去调用配置文件classfullpath
        Class<?> aClass = Class.forName("com.hspedu.Cat");
        //创建对象
        Object o = aClass.newInstance();
        //开始实施反射机制 去调用配置文件的Method
        Method hi = aClass.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i <900000; i++) {
            //cat.hi();
            hi.invoke(o);
        }
        long end =System.currentTimeMillis();
        System.out.println("传统方法调用hi 耗时=" + (end - start));
    }

    //反射优化  关闭访问检测
    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //不需要Cat类去创建了 用Class类去创建去调用配置文件classfullpath
        Class<?> aClass = Class.forName("com.hspedu.Cat");
        //创建对象
        Object o = aClass.newInstance();
        //开始实施反射机制 去调用配置文件的Method
        Method hi = aClass.getMethod("hi");
        //取消在反射调用方法时 取消访问调用
        hi.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i <900000; i++) {
            //cat.hi();
            hi.invoke(o);
        }
        long end =System.currentTimeMillis();
        System.out.println("传统方法调用hi 耗时=" + (end - start));
    }
}
