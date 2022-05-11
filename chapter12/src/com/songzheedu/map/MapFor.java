package com.songzheedu.map;

import java.util.*;

/**
 * @author 宋哲
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("王","蓉");
        map.put("王宝强","马");
        map.remove("王");
        System.out.println("map =" + map);

        //第一组 keySet  取出所有的Key 通过key取出对应的value
        Set keySet = map.keySet();
        //增强for循环
        for (Object key :keySet) {
            //取出所有的Key 通过key取出对应的value
            System.out.println(key + "-" + map.get(key));
        }
        //迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        //第二组 把所有的values全部取出 这里可以使用三钟方式
        Collection values = map.values();
        for (Object value : values ) {
            System.out.println(value + "-" +map.get(value));
        }
        //第三组：通过EntrySet 取出K-V
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            //向下转型Map.Entry 本身HashMap$Node但是没有提供方法
            // 所以把entry 转成 Map.entry
            Map.Entry m = (Map.Entry) entry;
            //使用Map.Entry 特有的两个办法getKey() getValue()
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object entry =  iterator1.next();
            //向下转型
            Map.Entry m2 = (Map.Entry) entry;
            System.out.println(m2.getKey() + "-" + m2.getValue());
        }
    }
}
