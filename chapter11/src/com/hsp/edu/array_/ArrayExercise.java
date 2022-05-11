package com.hsp.edu.array_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ArrayExercise {
    public static void main(String[] args) {
        /*自定义Book类 里面包含的name和price 按price排序(从大到小)。要求使用
        * 两种方式排序  有一个Book[] books =5本书对象
        *
        * 使用前面学习过的传递  实现Comparator接口匿名内部类 也称为定制排序
        * Book[] books = new Book[4];
        * books[0] = new Book("红楼梦",100);
        * books[1] = new Book("金瓶梅",90);
        * books[2] = new Book("青年文摘",5);
        * books[3] = new Book("java从入门到放弃",300);
        * */
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",100);
        books[1] = new Book("金瓶梅",90);
        books[2] = new Book("青年文摘",5);
        books[3] = new Book("java从入门到放弃",300);
        Arrays.sort(books, new Comparator() {
            @Override
            //compare 底层要求返回 必须是整数int 类型
            public int compare(Object o1, Object o2) {
                Book book1 = (Book)o1;
                Book book2 = (Book)o2;
                //2.按照署
                //名长度从大到小排序
                //return book2.getName().length() - book1.getName().length();
                //这里进行转换因为价格是double 类型导致int精度小无法接受
                // 而且要满足重写方法不能随意修改int值
                double priceValue = book2.getPrice() - book1.getPrice();
                if(priceValue > 0){
                    return -1;
                }else if(priceValue < 0){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        //必须输出
        System.out.println(Arrays.toString(books));
    }
}
class Book{
    private String name;
    private double price;

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

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
