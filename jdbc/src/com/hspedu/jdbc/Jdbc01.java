package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * JDBC编写步骤快速入门
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        //2.建立连接
        String url ="jdbc:mysql://localhost:3306/db02";
        //将用户名与密码封装到properties
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","hsp");
        //真正建立连接
        Connection connect = driver.connect(url, properties);
        //3.写sql语句
        String sql = "update hsp_actor set name = 'luhan' where id =1" ;
        //statement可以执行sql语句并返回结果 如果是dml形式比如正确的话返回一条 错误返回0条
        Statement statement = connect.createStatement();
        int row = statement.executeUpdate(sql);
        System.out.println(row > 0 ? "成功" : "失败");
        //4.关闭连接
        statement.close();
        connect.close();
    }
}
