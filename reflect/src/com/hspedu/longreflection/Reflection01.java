package com.hspedu.longreflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * 关于反射相关的四大类
 * 区别：传统方式和反射方式的区别 ？
 * 记住一点：和传统方式反过来就是反射
 * ：以成员变量为例子
 * 传统的方式：对象名.成员变量
 * 反射的方式：成员变量的对象名.get(对象名)
 */
@SuppressWarnings({"all"})
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        //通过toString()将类名转换成字符串形式用classfullpath来接受
        String classfullpath = properties.get("classfullpath").toString();//classfullpath  com.hspedu.Cat
        String method = properties.get("method").toString();
        System.out.println("classfullpath" + classfullpath);
        System.out.println("method" + method);

        //此时能通过new classfullpath来创建对象吗？？ 不能classfullpath变成字符串形式了
        //由此引出反射机制来解决
        //new Classpath()

        //接下来运用反射机制来解决问题
        //1.加载类 配置文件名称
        Class<?> aClass = Class.forName(classfullpath);
        //2.通过aClass 得到你想要的加载的类实例化对象
        Object o = aClass.newInstance();
        //3.通过getMethod得到加载的类com.hspedu.Cat的method方法对象
        //重点：在反射机制中 可以把方法当作对象去调用方法（面向对象中万物皆可对象）
        //这个反射机制是日后框架的灵魂
        Method method1 = aClass.getMethod(method);
        //4.通过method方法对象去调用实现方法
        Object invoke = method1.invoke(o);
        System.out.println("invoke :" + invoke);

        //类的成员方法  调用Cat类中的name成员私有属性 用getField()方法
        //Field field = aClass.getField("name");//报错调用不了
        Field nameField = aClass.getField("age");
        //nameField.get(o) 诠释了成员变量对象名.get(对象名)
        System.out.println(nameField.get(o));//调用公有属性运用反射机制完成

        //类的无参构造方法
        Constructor<?>[] constructors = aClass.getConstructors();//()中可以指定构造器的参数类型 当然没写就是无参了


        System.out.println(constructors);

        //类的形参构造方法 传进来的参数都是类对象
        Constructor<?> constructor = aClass.getConstructor(String.class);
        System.out.println(constructor);
        //这里传入String.class 就是String类的class对象
        //构造器是干嘛的？不就是"帮忙"构建对象的嘛！！！
        //所以构造器再创建对象 再次反射起来 比如
        constructor.getGenericExceptionTypes();

    }
}
