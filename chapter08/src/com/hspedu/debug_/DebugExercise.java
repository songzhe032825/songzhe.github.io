package com.hspedu.debug_;

public class DebugExercise {
    //加深对调式理解
    public static void main(String[] args) {
        //想看对象的创建流程 打个断点
        /*1.加载 Person类信息
        2.默认初始化  显示初始化  构造器初始化
        3.返回对象的地址
        * */
        Person person = new Person("jack",20);
        System.out.println(person);
    }
}
class Person{
    private String name;
    private int age;

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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
