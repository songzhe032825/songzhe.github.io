package com.songzheedu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
         List list = new ArrayList();
         list.add(new Book("红楼梦","罗贯中",23.4));
         list.add(new Book("水浒传","罗中",230.34));
         list.add(1,"可恶阿");
        System.out.println("list =" + list);
        //老师需求 我要遍历集合 有序的把书一本本拿出来 涉及到Iterator迭代器
        //1.先得到 list 对应的 迭代器 我们知道只要Collection接口的必须要实现
        //iterator()
        Iterator iterator = list.iterator();
        //2.使用while 循环遍历即可
        while (iterator.hasNext()){//先判断是否还有数据
            //如果有数据 那就用next()执行
            //返回一个元素是Object  编译类型Object
            // 运行类型 ：new Book 取决于真正存放的数据类型
            Object obj = iterator.next();
            System.out.println("obj=" + obj);//实现toString方法动态绑定
        }
        //快捷键 生成while循环 >>>>>  itit
        //显示所有的快捷键  ctrl + j

        //3.当退出while 循环时 此时iterator的迭代器 指向最后的元素
        //iterator.next();//报异常 NoSuchElementException
        //4.如果还想遍历 需要重置迭代器
        System.out.println("====第二次遍历=====");
        iterator = list.iterator();//重置迭代器
    }
}
class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
