package com.songzheedu.list_;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 宋哲
 * @version 1.0
 */
public class LinkedListCURD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        //添加某个结点对象
        linkedList.add(100);
        //删除某一个结点
        linkedList.remove(2);
        //修改某一个结点对象
        linkedList.set(1,999);
        //获取得到结点对象
        //get(1) 得到双向链表的第二个对象
        linkedList.get(1);
        System.out.println(linkedList); //999

        for (Object o :linkedList) {
            System.out.println("o =" + o);
        }
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("next=" + next);
        }
        //普通循环
        for (int i = 0; i <linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
