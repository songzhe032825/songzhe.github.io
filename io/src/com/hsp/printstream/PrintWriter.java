package com.hsp.printstream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 字符输出流
 */
public class PrintWriter {
    public static void main(String[] args) throws IOException {
        //java.io.PrintWriter pw = new java.io.PrintWriter(System.out);
        java.io.PrintWriter pw = new java.io.PrintWriter(new FileWriter("d:\\f2.txt"));
        pw.print("北京欢迎您");
        pw.close();
    }
}
