package com.songzheedu.collection_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Collections {
    public static void main(String[] args) {
        //创建ArrayList测试
        List list = new ArrayList();
        list.add("tom");
        list.add("milan");
        list.add("king");
        list.add("queen");

        System.out.println(list);
        //collection 工具类方法
        //1.对list元素的顺序进行反转
        java.util.Collections.sort(list);
        //2.我们按照字符串大小排序
        java.util.Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String) {
                    return ((String) o1).length() - ((String) o2).length();
                }else {
                    return 0;
                }
            }
        });
    }
}
