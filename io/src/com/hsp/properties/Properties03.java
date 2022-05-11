package com.hsp.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * 使用Properties 类来"添加/修改内容"mysql.properties 文件
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来创建配置文件 修改配置文件内容
        Properties properties = new Properties();
        //添加
        //以前集合讲过知识点 如果该文件没有key不存在就是创建 key存在就是修改或者替换
        //底层源码还是hashtable 所以核心代码依然是hashtable
        properties.setProperty("charset","utf-8");
        properties.setProperty("user","tom");//注意保存 是中文的 unicode码值
       // properties.setProperty("pwd","888888");
        properties.setProperty("pwd","9999");
        //将添加的内容存储在键值k-v对当中即可
        properties.store(new FileOutputStream("src\\mysql2.properties"),null);
        System.out.println("保存配置文件成功");
    }
}
