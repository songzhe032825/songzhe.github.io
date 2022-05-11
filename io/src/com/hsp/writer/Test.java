package com.hsp.writer;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //希望多次读取文件数据
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader());
        bufferedReader_.readFiles(10);


        //希望多次读取字符串数据
        BufferedReader_ bufferedReader_1 = new BufferedReader_(new StringReader());
        bufferedReader_1.readString(5);
    }
}
