package com.hsp.writer;

/**
 * @author 宋哲
 * @version 1.0
 * 节点流做成处理流/包装流
 * BufferedReader 扩展了 FileReader 和 StringReader
 */
public class BufferedReader_ extends Reader{
    private Reader reader_; //属性是Reader类型

    public BufferedReader_(Reader reader_) {
        this.reader_ = reader_;
    }
    //方法更灵活 多次读取文件
    public void readFiles(int num ){
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }
    //扩展readerString 批量处理字符串数据
    public void readString(int num ){
        for (int i = 0; i <num ; i++) {
            reader_.readString();
        }
        System.out.println();
    }
}
