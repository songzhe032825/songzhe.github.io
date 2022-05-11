package com.hspedu;

import javax.lang.model.element.VariableElement;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 *
 * 如何创建猫咪的实例化
 */
public class Cat {
    private String name;
    public int age = 10;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    public void hi(){
        System.out.println("猫咪叫");
    }
}
