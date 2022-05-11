package com.songzheedu.map;

import java.util.HashMap;

/**
 * @author 宋哲
 * @version 1.0
 */
public class MapMethod {
    public static void main(String[] args) {
        //演示Map常用方法
        HashMap map = new HashMap();
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("王","蓉");
        map.put("王宝强","马");
        map.remove("王");
        System.out.println("map =" + map);
        //获取键的某一个对象 返回对象形式
        /*Object 邓超 = map.get("邓超");*/
        Object val = map.get("邓超");

        //size 获取当前多少键值对
        System.out.println(map.size());
    }
}
