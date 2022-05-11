package com.hsp.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 配置文件
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //取出mysql.properties文件里面的id 用户
        //传统方法
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\mysql.properties"));
        //读取
        String line= "";
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
            //拆数据
            String[] split = line.split("=");
            System.out.println(split[0] + "值是：" + split[1]);
            //虽然读出来 但是修改麻烦并不方便 写一个类可以拿到某一个值就行了
        }
        bufferedReader.close();
    }
}
