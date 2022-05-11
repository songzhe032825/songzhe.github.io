package com.hspedu.jdbc.utils;

import com.hspedu.jdbc.resultset.ResultSet;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * JdbcUtils工具类
 */

public class JdbcUtils {
    //定义相关的属性(4个) 因为只需要一份 因此我们做出static
    private static String user;//用户名
    private static String password;//密码
    private static String url;//url
    private static String driver;//驱动名

    //在static代码块初始化
    static {
        Properties properties = new Properties();
        try {
            //就是因为加个："src：\\mysql.properties"害老子找了两个小时的错
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取相关属性
             user= properties.getProperty("user");
             password = properties.getProperty("password");
             url = properties.getProperty("url");
             driver = properties.getProperty("driver");
        } catch (IOException e) {
            //实际开发中我们需要将编译异常转换成运行时异常
            //对于调用者既可以调用异常进行捕获 也可以默认处理 毕竟运行时异常不需要立刻处理
            throw new RuntimeException(e);
        }
    }
    //连接数据库 返回Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭资源
    /*1.ResultSet结果集
    * 2.statement 或者 PreparedStatement
    * 3.Connection
    * 4.如果需要关闭资源 就传入对象 要不然传入null
    * */
    public static void close(ResultSet set, Statement statement, Connection connection){
        //判断是否为空 null
        try {
            if(set != null){
                set.close();
            }

            if(statement != null){
               statement.close();
            }

            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
