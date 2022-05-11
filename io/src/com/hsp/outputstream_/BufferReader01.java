package com.hsp.outputstream_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author 宋哲
 * @version 1.0
 * 演示BufferReader使用
 */
public class BufferReader01 {

    public BufferReader01(FileReader fileReader) {
    }

    public static void main(String[] args) throws Exception{
        String filePath = "d:\\song.txt";
        //创建bufferReader 对象
        //读取bufferReader 实际上底层依然是 FileReader节点流 因为bufferReader只是包装了一下
        //真正做处理的还是FileReader节点流
        //bufferReader01.readLine(); 按行读取文件
        //说明：1.new FileReader(filePath，true) 表示以追加的方式写入
        //2.new FileReader(filePath) 表示以覆盖的方式写入

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line ; //按行读取 效率高
        //当返回null的时候 表示文件读取完毕
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        //关闭流 实际上要关闭FileReader 但是只需要关闭处理流就行
        //底层自动关闭节点流 追源码
        bufferedReader.close();
    }
}
