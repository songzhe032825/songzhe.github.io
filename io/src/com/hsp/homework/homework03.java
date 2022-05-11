package com.hsp.homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 */
public class homework03 {
    public static void main(String[] args) throws IOException {
        String filePath="src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "");
        String color = properties.get("color") + " ";

        Dog dog = new Dog(name, age, color);
        System.out.println(dog);
        //将创建dog对象 序列化到 文件dog.dat 文件
        String serFilePath = "d:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serFilePath));
        objectOutputStream.writeObject(dog);

        objectOutputStream.close();
        System.out.println("dog对象序列化");
    }
    //在编写反序列化 ObjectInputStream
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String serFilePath= "d:\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog)objectInputStream.readObject();

        System.out.println("====反序列化后，dog=========");
        System.out.println(dog);
        objectInputStream.close();
    }
}
class Dog implements Serializable{
    private  String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
