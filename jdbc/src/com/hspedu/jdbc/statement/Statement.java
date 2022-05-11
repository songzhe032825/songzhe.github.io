package com.hspedu.jdbc.statement;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;

import java.util.Calendar;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author 宋哲
 * @version 1.0
 * 演示sql注入问题
 */
@SuppressWarnings({"all"})
public class Statement  {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        //让用户输入管理员和密码
        System.out.println("请输入管理员的名字：");//next() 当接收到空格或者' 就是表示结束
        String admin_name = scanner.nextLine();//老韩说名 如果希望看到sql注入 这里需要nextLine()
        System.out.println("请输入管理员的密码：");
        String admin_pwd = scanner.nextLine();

        //通过properties对象获取配置文件和信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //1.注册驱动
         Class.forName(driver);
         //2.建立连接
        Connection connection = DriverManager.getConnection(url, password,user );
        //3.得到Statement
        java.sql.Statement statement = connection.createStatement();
        //4.组织sql
        String sql = "select name,pwd from admin where name = ' "
                +admin_name +" ' and pwd=' " + admin_pwd + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){ //如果有数据显示 比如1 代表成功
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        //5.关闭资源
        resultSet.close();
        connection.close();
        statement.close();
    }
}
