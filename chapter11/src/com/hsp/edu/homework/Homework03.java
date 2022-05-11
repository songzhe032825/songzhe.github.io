package com.hsp.edu.homework;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        try {
            showException();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");
    }
    public static void showException() throws Exception{
        throw new Exception();
    }
}

