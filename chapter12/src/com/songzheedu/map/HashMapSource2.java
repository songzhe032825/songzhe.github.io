package com.songzheedu.map;

import java.util.HashMap;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HashMapSource2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        for (int i = 0; i <=12 ; i++) {
            map.put(new A(i), "java");//12
        }
        System.out.println("map =" + map);
    }
}
class A{
    private int num;

    public A(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return num == a.num;
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "A{" +
                "num=" + num +
                '}';
    }
}
