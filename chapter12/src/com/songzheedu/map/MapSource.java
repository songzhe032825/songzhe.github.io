package com.songzheedu.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 宋哲
 * @version 1.0
 */
public class MapSource {
    public static void main(String[] args) {
        //源码分析
         HashMap map = new HashMap();
        map.put("no1", "liu");
        map.put("no2", 3);
        map.put("no2", "zhang");
        map.put("no3", "zhang");
        //遍历 entrySet() 存放的类型就是Entry
        Set set = map.entrySet();
        for (Object o : set) {
            //向下转型
            Map.Entry entry = (Map.Entry) o;
            System.out.println("key =" + entry.getKey() + "value =" + entry.getValue());
        }
    }
}