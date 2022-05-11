package com.songzheedu.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ArrayListSource {
    //看源码重难点
    public static void main(String[] args) {
        //1.ArrayList中维护了一个Object类型的数组elementData
        // transient Object[] elementData
        //这些数据最终都存放在elementData中
        List arrayList = new ArrayList();
        arrayList.add("新信息");
        arrayList.add("效率");
        arrayList.add("新能用");
        //解析底层原码  使用集合添加 1-10 数据
        for (int i = 0; i <=10; i++) {
            arrayList.add(i);
        }
        //使用集合添加 10 -15 数据
        for (int i = 11; i <= 15 ; i++) {
            arrayList.add(i);
        }
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(300);
    }
}
