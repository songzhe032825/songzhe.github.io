package com.hsp.edu.enum_;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//一. 演示自定义枚举实现
class Season{ //类
    private String name;
    private String desc; //描述

    //[作用域：在Season内部] 直接创建固定的对象  SPRING 枚举对象名必须大写
    //定义了四个常量池 固定的对象 可以优化底层代码 加final修饰符
    public final static Season SPRING = new Season("春天","温暖");
    public final static Season SUMMER = new Season("夏天","炎热");
    public final static Season AUTUMN = new Season("秋天","凉爽");
    public final static Season WINTER = new Season("夏天","寒冷");

    //1. 将构造器私有化 目的防止直接被new
    //2. 去掉所以set方法 只能读 不能修改  目的防止属性被修改
    //3. 在Season内部 直接创建固定的对象
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
