package com.hspedu.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * 演示c3p0的使用
 */
@SuppressWarnings({"all"})
public class C3p0 {
    @Test
    //方式1：相关参数 在程序中指定user,url,password
    public void testC3P0_01() throws IOException, PropertyVetoException, SQLException {
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.(1)通过配置文件获取相关连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //(2).手动获取相关属性值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //3.给数据源对象comboPooledDataSource(体现连接池) 设置相关的参数
        //comboPooledDataSource 它来帮我管理连接的
        //因为连接池和mysql打通通道 所以一定要知道user,url,password driver的信息
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //4.给数据源comboPooledDataSource 设置相关的初始化数量
        comboPooledDataSource.setInitialPoolSize(10);
        //Max最大数量
        comboPooledDataSource.setMinPoolSize(50);

        //测试连接池的效率 测试对mysql 5000次操作
        long start = System.currentTimeMillis();
        for(int i = 0; i< 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//5.连接池最重要的方法 该方法就是从DataSource 接口实现的
            System.out.println("连接ok");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 5000连接mysql 耗时=" + (end - start));
    }

    //方法2：运用配置文件来完成数据源对mysql的连接
@Test
    public void testc3p0() throws SQLException {
        //1.先从配置文件名称创建数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp");
        //2.建立连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("0k~~~~~~`");
        //3.关闭
        connection.close();
    }
}
