package com.songzheedu.set_;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 宋哲
 * @version 1.0
 */
public class LinkedHashSetSource {
    public static void main(String[] args) {
        //分析一下
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(456);
        set.add("hsp");
        set.add("123");
        set.add("987");

        //确定LinkedHashSet添加的数据是否真的有序？
        //1.加入和取出的顺序一致
        //2.debug  LinkedHashSet 底层维护LinkedHashMap(是HashMap子类)
        //3.LinkedHashSet 底层结构是(数组(Table) + 双向链表)[LinkedHashMap维护的是数组 + 双向链表]
        //4.添加第一次时 直接将数组table 扩容到16 而且结点类型不是Node 而是LinkedHashMao$Entry
        //5.数组是 HashMap$Node[] 存放的元素/数据 LinkedHashMap$Entry类型 多态现象-数组多态真正
        //实现双向链表的结构
    }
}
