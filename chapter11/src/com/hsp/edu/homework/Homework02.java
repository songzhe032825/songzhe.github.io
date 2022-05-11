package com.hsp.edu.homework;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        //String[] args会发生ArrayIndexOutOfBoundException
        //args.length = 0;
        if (args[4].equals("john")) {
            System.out.println("AA");//可能发生NullPointerException
        } else {
            System.out.println("BB");
        }
        //String 类型 本身就是字符串
        Object o = args[2]; //String > OBJ 向上转型
        Integer I = (Integer) o; //报错 ClassCastException
        //改正 既然本身是字符串 String 向下转型就可以
        String S = (String) o;//可以
    }
}
