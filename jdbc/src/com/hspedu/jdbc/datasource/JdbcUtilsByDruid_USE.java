package com.hspedu.jdbc.datasource;

import com.hspedu.jdbc.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author 宋哲
 * @version 1.0
 * 使用德鲁伊来演示dml 和 sle 抛弃传统方式
 */
@SuppressWarnings({"all"})
public class JdbcUtilsByDruid_USE {
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
        connection =JDBCUtilsByDruid.getConnection();
        System.out.println(connection.getClass());//德鲁伊运行类型类 ：class com.alibaba.druid.pool.DruidPooledConnection
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
        JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
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
             connection = JDBCUtilsByDruid.getConnection();
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
            JDBCUtilsByDruid.close(null,preparedStatement ,connection);
        }
    }
    @Test
    //土方法来解决ResultSet = 封装 =》ArrayList
    public ArrayList<Actor> testSelectTorrayList() {
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "select * from hsp_actor where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Actor> list = new ArrayList();
        //3. 创建PreparedStatement 对象
        try {
            connection =JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//德鲁伊运行类型类 ：class com.alibaba.druid.pool.DruidPooledConnection
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

                //每循环一次拿到记录封装到创建的Actor类
                //Actor对象放到list集合的对象中
                list.add(new Actor(id,name,sex,bordate ,phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
        return  list;
    }
}
