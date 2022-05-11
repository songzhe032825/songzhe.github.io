package com.hspedu.reflection.question;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 宋哲
 * @version 1.0
 * 反射爆破创建实例
 */
public class ReflectionCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1.先获取User类的Class对象
        Class<?> aClass = Class.forName("com.hspedu.reflection.User");
        //2.通过public无参构造器创建实例
        Object o = aClass.newInstance();
        System.out.println(o);
        //3.通过public有参构造器创建实例
        //newInstance()无法传参 因此先构造getConstructor(String.class)//传有参构造  再创建实例
        Constructor<?> constructor = aClass.getConstructor(String.class);//括号里面的就是String
        Object hsp = constructor.newInstance("hsp");//括号里面的就是name " 白马变成hsp "
        System.out.println(hsp);
        //4.通过public非有参构造器创建实例
        //先创建私有的构造器getDeclaredConstructor()
        //再创建实例
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class, String.class);
        //爆破 使用反射可以访问私有属性/方法 反射yyds!
        declaredConstructor.setAccessible(true);//爆破 使用反射可以访问私有的构造器（其他）再反射面前一切都是纸老虎 封装性都被侦破

        Object song = declaredConstructor.newInstance(98, "song");
        System.out.println(song);

        //使用反射操作得到age属性
        Field age = aClass.getField("age");
        age.set(song,88);//通过反射来操作属性
        System.out.println(song);

        //使用反射操作私有属性name
        Field name = aClass.getDeclaredField("name");
        //获取属性值 1.注意当访问私有属性的时候 反射的爆破就可以强行访问私有属性
        name.setAccessible(true);
        name.set(song,"老韩");
        System.out.println(song);
        //获取属性值 2.如果我给属性赋个静态的 因为name是static属性 所以song也可以写成null
        name.set(null,"老韩");//必须是静态才能置空 不是静态千万别这样运用
        System.out.println(name.get(null));//必须是静态 不是静态千万别这样运用
    }
}

class User{
    public  int age = 10;
    private static String name = "白马";

    public User() {//无参public
    }

    public User(String name) { //public 有参构造器
        this.name = name;
    }

    public User(int age, String name) { //private 有参构造器
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
