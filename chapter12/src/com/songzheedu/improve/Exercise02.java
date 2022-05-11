package com.songzheedu.improve;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 宋哲
 * @version 1.0
 */
@SuppressWarnings("all")
public class Exercise02 {
    public static void main(String[] args) {
        /*定义Employee类
         * 1.该类包含： 成员变量 name sal birthday 其中birthday为MyDate类的对象
         * 2.为每一个属性定义 getter setter 方法
         * 3.重写 toString 方法输出name Sal birthday
         * 4.MyDate类包含：private成员变量month day year 并未每一个属性定义getter  Setter方法
         * 5.创建类的3个对象 并把每一个对象放入ArrayList集合中(泛型) 对集合元素进行排序
         * 6.排序方式：调用ArrayList的sort方法 传入Comparator对象 先按照name排序
         * 如果相同 按照生日日期先后排序
         *
         *      * */
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("张三",3000.4,new MyDate(2000,2,5)));
        employees.add(new Employee("李四",5400.4,new MyDate(1990,2,5)));
        employees.add(new Employee("张三",3000.4,new MyDate(2000,4,5)));

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                //先判断o1 是否是Employee 类型
                if(!(e1 instanceof Employee && e2 instanceof Employee)){
                    System.out.println("类型不正确");
                    return 0;
                }
                //如果类型正确的话 就比较名字是不是相同
                int i = e1.getName().compareTo(e2.getName());
                if(i != 0){
                    //如果确实不同 就随便返回一个结果
                    return i;
                }
                //如果名字相同  就比较birthday 中的year  把主要代码封装的MyDate类中
                return e1.getBirthday().compareTo(e2.getBirthday());
            }
        });
    }
}
class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "\nname='" + name + '\'' +
                ", \nsal=" + sal +
                ", \nbirthday=" + birthday +
                '}';
    }
}