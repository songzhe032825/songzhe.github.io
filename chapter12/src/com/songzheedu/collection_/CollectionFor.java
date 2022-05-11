package com.songzheedu.collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
public class CollectionFor {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦","罗贯中",23.4));
        list.add(new Book("水浒传","罗中",230.34));
        list.add(1,"可恶阿");
        System.out.println("list =" + list);

        //使用增强for循环的演示代码
        //底层仍然是迭代器iterator()
        //快捷键方式 I
        for(Object book : list){//表示从集合中有序的一个个的取出book : list(集合)
            System.out.println("book =" + book);
        }

        //还可以使用场景是数组形式 在Collection
        int[] nums = {13,45,555,2};
        for( int i : nums){ //表示从数组nums有序的一个个取出i元素
            System.out.println("i=" + i);
        }
    }
}
