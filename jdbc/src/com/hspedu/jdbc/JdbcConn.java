package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.lang.Class.forName;

/**
 * @author 宋哲
 * @version 1.0
 * 分析java连接mysql的五种连接方式
 */
@SuppressWarnings({"all"})
public class JdbcConn {
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url ="jdbc:mysql://localhost:3306/db02";
        //将用户名与密码封装到properties
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","hsp");
        //真正建立连接
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }
    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类 好处：动态加载 更灵活 减少依赖
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver =(Driver)aClass.newInstance();//反射加载Driver类目的拿到aClass对象
        String url ="jdbc:mysql://localhost:3306/db02";
        //将用户名与密码封装到properties
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","hsp");
        //真正建立连接
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用DriverManager替换Driver  可以进行注册 把driver对象放进去便于管理
        //反射加载Driver
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        //创建url ,password ,user
        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String password = "hsp";

        //DriverManager去管理Driver
        DriverManager.registerDriver(driver);
        DriverManager.getConnection(url,user,password);
    }
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        //老韩推荐第4种方式做开发
        //面试问的原因：Driver类底层中 有个静态代码块自动帮助我们注册DriverManager()
        //反射加载Driver 在加载Driver类完成自动注册
        Class.forName("com.mysql.jdbc.Driver");


        //创建url ,password ,user
        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String password = "hsp";

        //DriverManager去管理Driver
        DriverManager.getConnection(url,user,password);
    }
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //使用配置文件连接数据库更加灵活
        //通过properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取文件的V值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //通过反射加载Driver类自动完成注册
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
