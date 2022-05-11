package com.hspedu;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 宋哲
 * @version 1.0
 * 通过反射修改私有成员变量
 * 1.定义PrivateTest类 有私有name属性并且属性值hellokitty
 * 2.提供getName的公有方法
 * 3.创建PrivateTest的类 利用Class类得到私有的name属性 修改私有的name属性值
 * 并调用getName()的方法打印name属性值
 */
public class Homework01 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //1.得到PrivateTest类对应的Class对象
        Class<PrivateTest> privateTestClass = PrivateTest.class;
        //2.创建对象实例
        PrivateTest privateObj = privateTestClass.newInstance();
        //3.得到name属性
        Field name = privateTestClass.getDeclaredField("name");
        //4.爆破 私有属性
        name.setAccessible(true);
        name.set(privateObj,"阿里巴巴");
        //5.得到getName()公有方法
        // getMethod() 公有方法
        // getDeclaredMethod() 私有方法
        Method getName = privateTestClass.getMethod("getName");
        //6.调用  因为getName 是公有的不需要爆破 直接调用 直接invoke即可
        Object invoke = getName.invoke(privateObj);//返回String
        System.out.println(invoke);
    }
}
class PrivateTest{
    private String name = "hellokitty";
    public String getName(){
        return name;
    }
}