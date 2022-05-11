package com.songzheedu.collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //先实例化List接口的子”类“ArrayList 并且故意让List接口来接受
        List list = new ArrayList();

        //add:添加单个元素
        list.add("Jack");//object的子类对象都可以存放
        list.add(10);//底层自动装箱转成Interger 本质：list.add(new Integer(10));
        list.add(true);//自动装箱过程
        System.out.println("list= " + list); //输出的已经不是基本数据类型  而是对象形式

        //remove: 删除指定元素或者索引
        //实现了方法的重载
        list.remove(0);//删除索引 返回是int类型
        list.remove("Jack");//删除指定某个元素 返回object的对象
        System.out.println("list= " + list);

        //contains: 查找元素是否存在
        System.out.println(list.contains("Jack")); //返回boolean类型

        //size : 获取元素个数
        System.out.println(list.size());//2

        //isEmpty :判断是否为空
        System.out.println(list.isEmpty());//返回bool

        //clear : 清空(集合元素全部消灭,慎重使用)
        //list.clear();

        //addAll : 添加多个元素
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("红");
        arrayList2.add("蓝");
        arrayList2.add("黄");
        list.addAll(arrayList2); //这里是直接把集合存放进去了
        System.out.println("arrayList2 =" + arrayList2);

        //containsAll : 判断查找多个元素是否存在
        System.out.println(arrayList2.containsAll(arrayList2)); //true

        //删除多个元素 我想直接删除多个元素也是放置一个集合进去
        arrayList2.add("黄");
        arrayList2.removeAll(arrayList2);
        System.out.println("arrayList2 =" +arrayList2);//为了验证效果只剩”黄“ 集合删了


    }
}
