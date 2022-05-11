package com.hsp.printstream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author 宋哲
 * @version 1.0
 * 演绎 PrintStream_ 字节打印流
 */
public class PrintStream_ {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream out = System.out;
        //默认情况下 打印流输出数据的位置是标准输出即显示器
        out.println("join");
        // PrintStream 本身是字节流
        //因为print 底层使用的是write 所以我们直接调用write进行打印输出
        out.write(10);
        //可以修改打印流输出位置
        //修改成文件中
        System.setOut(new PrintStream("d:\\t1.txt"));
        //会场输出到修改后的文件 而不是标准文件之中
        System.out.println("hello,duck");
        out.close();
    }
}
