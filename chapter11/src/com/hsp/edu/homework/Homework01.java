package com.hsp.edu.homework;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework01 {//B C D
    public static void main(String[] args) {
            try {
                func();
                //try 代码块抛出异常下面代码绝对不执行 不输出A
                System.out.println("A");
                //捕获到异常
            } catch (Exception e) {
                e.printStackTrace();
                // 第二句执行catch语句C
                System.out.println("C");
            }
            //最后一步执行D
            System.out.println("D");
    }
    public static void func(){//静态方法
        try{
            //然后执行throw 语句
            throw new RuntimeException();
            //finally 一定要执行
        }finally {
            //先输出B finally优先
            System.out.println("B");
        }
    }
}
