package com.hspedu.dao._utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * 基于德鲁伊数据库连接池的工具类
 */
@SuppressWarnings({"all"})
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //在静态代码块成ds的初始化 因为静态代码块加载JDBCUtilsByDruid类时只加载一次
    //因此数据源也就初始化一次
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //编写getConnection 方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接 老韩再次强调 数据库连接池中 close()不是真的与数据库断掉连接
    //而是吧使用的Connection对象放回到连接池中去
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        try{
            if(resultSet != null){
               resultSet.close();
            }
            if (statement != null){
                statement.close();
            }

            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
