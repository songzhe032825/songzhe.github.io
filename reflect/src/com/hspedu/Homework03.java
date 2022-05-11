package com.hspedu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 宋哲
 * @version 1.0
 * 利用Class类的forName方法得到File类的class对象
 * 在控制台打印File类的所有构造器
 * 通过newInstance的方法创建File对象 并创建D：\mynew.txt文件
 */
public class Homework03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //提供路径的反射
        //1.创建File类对象 跟之前的区别是这个有路径提示
        Class<?>  files = Class.forName("java.io.File");
        //2.在控制台打印File类的[所有]构造器
        Constructor<?>[] declaredConstructors = files.getDeclaredConstructors();
        //3.遍历输出所有
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("file构造器 =" + declaredConstructor);
        }
        //4.运用构造器创建File对象 file构造器 =public java.io.File(java.lang.String)
        Constructor<?> dlc = files.getDeclaredConstructor(String.class);
        String fillAllPath = "d:\\mynew.txt";
        Object file = dlc.newInstance(fillAllPath);//创建File对象
        //5.此时file文件在内存中 接下来需要创建file对象[很重要的两句话]
        Method createNewFile = files.getMethod("createNewFile");
        Object invoke = createNewFile.invoke(file);
        System.out.println(invoke);
        //file运行类型就是File
        System.out.println(file.getClass());
        System.out.println("创建文件成功" + fillAllPath);
        System.out.println("创建文件成功" + fillAllPath);
    }
}
