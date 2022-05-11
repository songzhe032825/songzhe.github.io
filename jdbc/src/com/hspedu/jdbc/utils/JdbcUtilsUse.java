package com.hspedu.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author 宋哲
 * @version 1.0
 * 演示使用dml 和 sel 语句
 */
@SuppressWarnings({"all"})
public class JdbcUtilsUse {
    @Test
    public void testSelect() {
    //1. 得到连接
    Connection connection = null;
    //2. 组织一个sql
    String sql = "select * from hsp_actor where id = ?";
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //3. 创建PreparedStatement 对象
        try {
        connection = JdbcUtils.getConnection();
        System.out.println(connection.getClass()); //运行类型：com.mysql.jdbc.JDBC4Connection
        preparedStatement = connection.prepareStatement(sql);
        //给占位符赋值
        preparedStatement.setInt(1, 5);//给?号赋值
        //执行, 得到结果集
            resultSet = preparedStatement.executeQuery();//执行sql语句
        //遍历该结果集
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date bordate = resultSet.getDate("bordate");
            String phone = resultSet.getString("phone");
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + bordate + "\t" + phone);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        //关闭资源
        JdbcUtils.close(null, preparedStatement, connection);
    }
}

    @Test
    public void Dml() {
        //1.得到连接
        Connection connection = null;
        //2.组织一个sql
        String sql = " update hsp_actor set name = ? where  id= ? ";
        //为什么要扩大作用域是因为 finally会用到preparedStatement
        PreparedStatement preparedStatement =null;

        //3.创建PrepareStatement
        try {
             connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符？赋值
            preparedStatement.setString(1,"xiaokeai");
            preparedStatement.setInt(2,4);
            //执行sql
             preparedStatement.executeUpdate();//执行sql语句
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            JdbcUtils.close(null,preparedStatement ,connection);
        }
    }
}
