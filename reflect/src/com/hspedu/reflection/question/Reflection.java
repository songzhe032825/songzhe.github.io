package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * 反射机制
 */
@SuppressWarnings({"all"})
public class Reflection {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
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
        Object o =aClass.newInstance();
        //3.通过getMethod得到加载的类com.hspedu.Cat的method方法对象
        //重点：在反射机制中 可以把方法当作对象去调用方法（面向对象中万物皆可对象）
        //这个反射机制是日后框架的灵魂
        Method method1 = aClass.getMethod(method);
        //4.通过method方法对象去调用实现方法
        Object invoke = method1.invoke(o);
        System.out.println("invoke :" + invoke);
    }
}
