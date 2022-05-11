package com.hsp.inputstreams;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author 宋哲
 * @version 1.0
 * 使用ObjectInputStream 读取 data.dat并实现反序列化恢复数据
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception{
        //指定反序列化后 保存的文件格式 不是存文本格式（代表乱码） 而是按照他的格式保存
        String filePath = "d:\\data.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        //1.读取顺序(反序列化顺序)和自己保存数据(序列化)的保持一致 保存的值和数据类型返回程序中
        //2.否则会抛出异常

        //这里有很重要细节

        //如果我们希望调用dog的方法,需要向下转型
        //需要我们将dog定义拷贝到可以引用即可

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        System.out.println(ois.readObject());
        ois.close();
    }
}
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
