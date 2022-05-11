package com.hspedu.jdbc.resultset;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 宋哲
 * @version 1.0
 * 演示select语句返回ResultSet,并取出结果
 */
@SuppressWarnings({"all"})
public class ResultSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        //使用配置文件连接数据库更加灵活
        //通过properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取文件的V值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");


        //1.通过反射加载Driver类自动完成注册
        Class.forName(driver);
        //2.建立连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3.得到Statement
        Statement statement = connection.createStatement();
        //4.组织sql 并且select语句全是列名  提醒：手机列sql语句不支持
        String sql = "select id, name ,sex,bordate from hsp_actor";
        //执行sql语句 返回单个 Result对象
        java.sql.ResultSet resultSet = statement.executeQuery(sql);
        //5.使用while取出数据
        /*resultSet指向表头 无法指向具体的哪个值 况且取出的是列
        所以需要while循环
        让光标向下移动 如果没有了返回false 执意继续循环就是空指针异常
        * */
        while(resultSet.next()){
            int id = resultSet.getInt(1);//获取此行的第一个列 是 0
            String name = resultSet.getString(2);//一行二列
            String sex = resultSet.getString(3);//一行三列
            Date date = resultSet.getDate(4);
        }
        //6.关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    public void close() {
    }
}
