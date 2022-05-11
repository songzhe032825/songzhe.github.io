package com.songzheedu.map;

import java.util.*;

/**
 * @author 宋哲
 * @version 1.0
 */
public class MapExercise {
    public static void main(String[] args) {
        /*使用HashMap添加3个员工对象 要求：
        * 键: 员工id
        * 值：员工对象
        *
        * 并且遍历显示工资 > 18000的员工(遍历方式至少两种)
        * 员工类 ： 姓名 工资 员工id
        * */
        HashMap hashMap = new HashMap();
        hashMap.put(1,new Employee(1,"张三",3000000.4));
        hashMap.put(2,new Employee(2,"李四",4000.5));
        hashMap.put(3,new Employee(3,"王五",5000.6));

        //1.遍历 KeySet
        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            //先获取value 
            Employee emp = (Employee)hashMap.get(key);
            if(emp.getSal() > 18000){
                System.out.println(emp);
            }
        }
        //迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            //获取value值
            Employee employee =(Employee)hashMap.get(key);
            if(employee.getSal() > 1433){
                System.out.println(employee);
            }
        }
        //2.遍历EntrySet (重难点 ！！！！！！)
        Set entrySet = hashMap.entrySet();
        for (Object entry: entrySet) {
            //先将entry 向下转型 Map.Entry
            Map.Entry mp = (Map.Entry)entry;
            //通过Map.Entry 特有方法获取K-V
            Employee employee =(Employee)mp.getValue();
            if(employee.getSal() > 23232){
                System.out.println(employee);
            }
        }
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry =  iterator3.next();
            Map.Entry mp3 = (Map.Entry)entry;
            Employee employee =(Employee)mp3.getValue();
            if(employee.getSal() > 22222 ){
                System.out.println(employee);
            }
        }
        //根据values获取 for增强
        Collection values = hashMap.values();
        for (Object value : values) {
            //获取Emp 对象
            Employee employee =(Employee)hashMap.get(value);
            if(employee.getSal() > 2889898){
                System.out.println(employee);
            }
        }
        //迭代器
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            //获取Emp对象
            Employee employee =(Employee)hashMap.get(value);
            if(employee.getSal() > 28){
                System.out.println(employee);
            }
        }
    }
}
class Employee{
    private int id;
    private String name;
    private double sal;

    public Employee(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
