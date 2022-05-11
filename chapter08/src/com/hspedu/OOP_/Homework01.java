package com.hspedu.OOP_;

public class Homework01 {
    //定义一个Person 类 name  age  job  初始化Person对象数组 有3个person对象
    //按照age 从大到小进行排序提示  使用冒泡排序

    public static void main(String[] args) {
        Person[] person = new Person[3];
        person[0] = new Person("jordan",30,"JavaEE");
        person[1] = new Person("mary",40,"大数据");
        person[2] = new Person("tom",25,"Python");

        //输出当前对象数组
        for(int i = 0; i < person.length;i++) {
            System.out.println(person[i]);
        }

        //使用冒泡排序
        Person temp =null;
        for (int i = 0; i <person.length-1; i++) {
            for (int j = 0; j < person.length - i -1 ; j++) {
                //并按照 age 从大到小进行排序  如果前面的人的age < 后面人的年龄 就交换
                //按照名字的长度(length)从小到大 在if语句中改正
                if(person[j].getName().length() > person[j+1].getName().length()){
                    temp =person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }
        }
        System.out.println("排序后的效果");
        for(int i = 0; i < person.length;i++) {
            System.out.println(person[i]);
        }
    }
}
class Person{
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
