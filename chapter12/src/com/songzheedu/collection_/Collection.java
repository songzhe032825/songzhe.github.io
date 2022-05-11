package com.songzheedu.collection_;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Collection {
    //警告错误  以前讲过
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //老韩解读
        /*1.集合主要是两组(单列 集合 双列集合)
        * 2.Collection 接口有两个重要的子接口分别是List  Set 他们的实现子类实现
        * 都是单例接口
        * 3.Map 接口的实现子类 是双列接口  存档K-V形式
        * 4.牢记两张图
        * */
        //ArrayList 存放的是单个对象形式出现 调用add remove get set等方法
        ArrayList arrayList = new ArrayList();
        arrayList.add("song");
        arrayList.add("zhe");
        arrayList.remove("s");
        arrayList.set(1,"tree");
        arrayList.get(2);
        //HashMap 双列集合 以键值对方式出现放在put方法内
        HashMap hashMap = new HashMap();
        hashMap.put("jack","rose");
        hashMap.get("liu");
        hashMap.remove("qq","ww");

        /*        Collection  单列接口                Map  双列接口
        *              |                              |
        *              |                              |
        *      List          Set                     6.HashMap --  LinkHashMap
        *                                            7.TreeMap
        * 1.ArrayList       4.HashSet                8.HashTable
        * 2.LinkList        5.TreeSet                     |extends
        * 3.Vector                                        |
        *                       |                    9.properties
        * */
    }
}
