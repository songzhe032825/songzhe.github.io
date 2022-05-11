package com.songzheedu.set_;

import java.util.Comparator;

/**
 * @author 宋哲
 * @version 1.0
 */
public class TreeSet {
     public TreeSet(Comparator comparator) {
     }

     public static void main(String[] args) {
          //传统的无参构造创建TreeSet依旧是无序的 所以TreeSet提供了构造器
          //该构造器可以传入比较器 并且比较器是匿名内部类
          TreeSet treeSet = new TreeSet(new Comparator() {
               @Override
               public int compare(Object o1, Object o2) {
                    return 0;
               }
          });
     }
}
