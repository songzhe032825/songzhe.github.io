package com.songzheedu.homework;

import java.util.*;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        //1.使用HashMap类实例化一个Map类型对象m,键(String)和值(int)分别用于
        //存储员工的姓名工资 存入数据如下： jack-650元 tom-1200元 smith-2900元

        //2.将jack的工资更改为2600元
        //3.为所有员工工资加薪100元
        //4.遍历集合中所有的员工
        //5.遍历集合中所有的工资

        Map m = new HashMap();
        m.put("jack",650);
        m.put("tom",1200);
        m.put("smith",2900);
        System.out.println(m);
        //更改员工工资
        m.put("jack",2600);
        System.out.println(m);
        //所有员工工资加100
        Set keySet = m.keySet();
        for (Object key :keySet) {
            //本质就是更新而已
            m.put(key,(Integer)m.get(key) + 100); //因为值是obj类型 所有向下转型
        }
        System.out.println("m =" +m);
        //遍历集合中所有的员工 EntrySet
        Set entrySet = m.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry mp =(Map.Entry)iterator1.next();
            System.out.println(mp.getKey() + "-" + mp.getValue());
        }
        //遍历集合所有员工工资 通过values直接遍历即可
        Collection values = m.values();
        for (Object value :values) {
            System.out.println("工资 =" + value);
        }
    }
}
