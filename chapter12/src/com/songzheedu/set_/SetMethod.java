package com.songzheedu.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 宋哲
 * @version 1.0
 */
public class SetMethod {
    //以Set接口实现类HashSet 来讲解set的接口方法
    public static void main(String[] args) {
         Set hashSet = new HashSet();
        //1.set 是无序的(添加取出不一致) 并且不能有重复元素
        hashSet.add("jack");
        hashSet.add("tom");
        hashSet.add("luhan");
        hashSet.add("qiu");
        //2.可以添加有且只能存放一个null 且元素还不能重复
        hashSet.add(null);
        hashSet.add(null);

        //3.说明是否添加成功add方法后会返回boolean值 true or false
        System.out.println(hashSet.add("john"));//T
        System.out.println(hashSet.add("lucy"));//T
        System.out.println(hashSet.add("john"));//F
        System.out.println(hashSet.add("rose"));//T
        System.out.println(hashSet.add("kobe"));//T
        //可以通过remove指定删除某一个对象
        hashSet.remove("john");
        System.out.println("hashSet =" + hashSet); //输出的3个名称无法保证按照顺序执行
        //判断是否为空
        hashSet.isEmpty();
        //转换成数组
        Object[] objects = hashSet.toArray();
        System.out.println("objects =" + objects);
        System.out.println(hashSet);
        //1.使用迭代器

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("next =" +next);
        }
        //2.使用增强for循环
        for (Object o :hashSet) {
            System.out.println("iterator=" +hashSet);
        }
        //3.普通for循环  Set接口对象不能普通for循环 无法获取索引
        /*for (int i = 0; i <hashSet.size() ; i++) {
            //Set接口没有提供get()方法
            System.out.println(hashSet.);
        }*/
    }

}
