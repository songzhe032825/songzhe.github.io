package com.hsp.edu.exception;

/**
 * @author 宋哲
 * @version 1.0
 */
public class NullPointException_ {
    public static void main(String[] args) {
        String name = null;
        System.out.println(name.length());
        //Exception in thread "main" java.long NullPointException
    }
}
