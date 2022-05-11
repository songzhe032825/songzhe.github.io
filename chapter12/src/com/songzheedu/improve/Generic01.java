package com.songzheedu.improve;

import java.util.ArrayList;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Generic01 {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog("旺财"));
        dogs.add(new Dog("金毛"));
        dogs.add(new Dog("太低"));

        for (Dog dog :dogs) {
            System.out.println(dog.getName() + "-");
        }
        //必须传值
        Person<String> stringPerson = new Person<String>("蛤蟆书评");
    }
}
//1.引入泛型 加入我们程序员不小心添加一只猫 怎么解决？     · `
//2.表示集合只能放dog类型 其他不可以在存放
//3.遍历直接取Dog类型 而不是Obj类型
//4.public class ArrayList<E>{} E称为泛型 Dog是指定泛型的数据类型
//类似于E是类型形参 Dog是类型实参
class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Person<E> {
    // String s;//传统写法
    E s;//E表示s的数据类型 该数据类型实在定义person对象时候定义的 即在编译的时候
    //知道E是什么类型


    public Person(E s) {
        this.s = s;
    }
    //返回值类型
    public E f(){
        return s;
    }
}