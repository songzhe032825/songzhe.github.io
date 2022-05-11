package com.hspedu.jdbc.preparedstatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author 宋哲
 * @version 1.0
 * 通过 PreparedStatementDml 解决sql注入问题
 */
@SuppressWarnings({"all"})
public class PreparedStatementDml {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        //让用户输入管理员和密码
        System.out.println("请输入名字：");//next() 当接收到空格或者' 就是表示结束
        String admin_name = scanner.nextLine();//老韩说名 如果希望看到sql注入 这里需要nextLine()
        System.out.println("请输入密码：");
        String admin_pwd = scanner.nextLine();

        //通过properties对象获取配置文件和信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //1.注册驱动
        Class.forName(driver);
        //2.建立连接
        Connection connection = DriverManager.getConnection(user, password, url);
        //4.组织sq
        //添加数据
        String sql = "insert into admin values (?, ? )";
        //3.得到PreparedStatement
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //给 ?占位符 赋值 此方法才是解决注入问题的根本
        //第一个参数是索引值
        //第二参数是sql语句中的参数值
        preparedStatement.setString(1,admin_name);
        preparedStatement.setString(2,admin_pwd);
        //注意：preparedStatement.executeQuery(sql)是会报错的 原因在上面sql语句已经赋值了
        //
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "成功" : "失败");
        //5.关闭资源
        connection.close();
        preparedStatement.close();
    }
}
