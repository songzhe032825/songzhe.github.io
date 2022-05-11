package com.songzheedu.map;

import java.util.HashMap;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Map_ {
    public static void main(String[] args) {
        //map是接口无法实例化 使用实现类HashMap来去实现
        HashMap map = new HashMap();
        //注意 map的添加方法不再是add 而是put(K-V)
        map.put("no1","liu");//K-object  V-object 顶级类什么对象都可以
        map.put("no2",3);//K-object  V-object 顶级类什么对象都可以
        map.put("no2","zhang");//当k 相同时 会出现替换机制
        map.put("no3","zhang");//当k 可以添加 因为k不一样
        //底层还是hashmap 因此键值对也是无序的 为什么是无序的？
        //因为no1所配的索引可能靠后(比如3) no2所配的索引可能考前(比如1) 取出顺序就不一样
        System.out.println("map =" + map);
    }
}
