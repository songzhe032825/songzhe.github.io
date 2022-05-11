package com.songzheedu.list_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ListExercise02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //使用List的实现类添加三本图书 并遍历 打印如下：
        /*
        * 名称 ： xx    价格：  xx     作者 ： xx
        * 名称 ： xx    价格：  xx     作者 ： xx
        * 名称 ： xx    价格：  xx     作者 ： xx
        *
        * 要求:
        * 1.按价格排序 从低到高(冒泡排序)
        * 2.要求使用ArrayList LinkedList 和 Vector 实现
        * */

        List list = new ArrayList();
        list.add(new Book("还珠格格",38.5,"琼瑶"));
        list.add(new Book("基督山伯爵",68,"大仲马"));
        list.add(new Book("茶花女",77.5,"小仲马"));

        //增强for循环
        for (Object book:list) {
            System.out.println(book);
        }

        //冒泡排序 sort
        sort(list);
        System.out.println("=====排序后=========");
    }
    public  static void  sort(List list){
        int listSize = list.size();
        for (int i = 0; i <listSize-1; i++) {
            for (int j = 0; j <listSize-1-i; j++) {
                //取出对象Book 向下转型
                //知识点：list取出的元素都是obj类型 而getPrice的价格方法
                //是Book特有的方法 所以要想得到只能向下转型
                //错误代码示范：
               /* Object book1 = list.get(j);
                Object book2 = list.get(j+1);*/
                //正确的代码示范：
                Book book1 = (Book)list.get(j);
                Book book2  = (Book)list.get(j+1);
                //从小到大 比较价格
                if(book1.getPrice() > book2.getPrice()){
                    //交换直接用set方法就行 不需要temp中间变量
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }
}

class Book{
    private String name;
    private double price;
    private String actor;

    public Book(String name, double price, String actor) {
        this.name = name;
        this.price = price;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", actor='" + actor + '\'' +
                '}';
    }
}
