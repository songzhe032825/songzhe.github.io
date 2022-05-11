package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * 演示德鲁伊的数据库连接池
 */
public class Druid {
    @Test
    public void druid() throws Exception {
        //1.加入 Druid.jar
        //2.加入配置文件 druid.properties 将该文件拷贝到项目的src目录
        //3.创建Properties对象 读取配置文件
        Properties properties = new Properties();
        //加载文件
        properties.load(new FileInputStream("src\\druid.properties"));

        //4.创建一个指定参数的数据库连接池 返回一个数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //拿到数据源就可以得到连接
        Connection connection = dataSource.getConnection();

        System.out.println("oh----");

        connection.close();
    }
}
