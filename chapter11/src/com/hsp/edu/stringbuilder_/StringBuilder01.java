package com.hsp.edu.stringbuilder_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class StringBuilder01 {
    public static void main(String[] args) {
        //1.StringBuilder继承了AbstractStringBuilder类 继承了所有方法
        //2.实现了Serializable接口 说明 StringBuilder的对象是可串行化的
        //所谓可串行化的是既可以网络传输也可以保存文件
        // 序列化 所谓序列化即可以保存类型和数据本身 存放再堆中
        //StringBuilder 是final类无法被继承
        //StringBuilder不是线程安全的即存在多线程问题；单线程是最好的选择在没有并发情况下
        //StringBuilder的方法 没有做互斥的处理 既没有synchronized 关键字
        //StringBuilder 和 StringBuffer 二者区别在于 ：
        //StringBuilder是单线程 StringBuffer 是多线程
        StringBuilder stringBuilder = new StringBuilder();
    }
}
