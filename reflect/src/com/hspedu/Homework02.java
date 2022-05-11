package com.hspedu;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 宋哲
 * @version 1.0
 *  通过反射修改私有成员变量
 *  * 1.定义PrivateTest类 有私有name属性并且属性值JavaLang
 *  * 2.提供getName的公有方法
 *  * 3.创建PrivateExercise的类 利用Class类得到私有的name属性 修改私有的name属性值
 *  * 并调用getName()的方法打印name属性值
 *  */
public class Homework02 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //1.前提得到PrivateExercise所对应的Class类对象
        Class<PrivateExercise> privateExerciseClass = PrivateExercise.class;
        //2.创建对象
        PrivateExercise privateObj = privateExerciseClass.newInstance();
        //3.得到私有属性name privateExerciseClass类对象
        Field name = privateExerciseClass.getDeclaredField("name");
        //4.爆破
        name.setAccessible(true);
        //5.修改值 对象名
        name.set(privateObj,"天龙八部");
        //6.调用getName()的公共方法getMethod()
        Method getName = privateExerciseClass.getMethod("getName");
        //7.根据getName()方法对象调用invoke()
        Object invoke = getName.invoke(privateObj);
        System.out.println(invoke);
    }
}
//提供类的反射
class PrivateExercise{
    private String name = "JavaLang";
    public String getName(){
        return name;
    }
}