package com.bjpowernode.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author 宋哲
 * @version 1.0
 * JDBC工具类
 */
public class Dbutils {
    //静态变量在类加载执行 自上而下顺序
    //绑定我们属性资源文件的
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");
    //根据key来获取value key从properties中拿
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    //注册驱动只需要注册一次 所以放在代码块内 工具类的类加载执行
    static {
        try {
            //注册驱动 还不能写死 万一要连接oracle数据库呢？
           // Class.forName("com.mysql.jdbc.Driver");写死代码不提倡
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        //获取数据库的连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    //释放资源
    //connection 连接对象
    //ps 数据库操作对象
    //rs 结果集对象
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
