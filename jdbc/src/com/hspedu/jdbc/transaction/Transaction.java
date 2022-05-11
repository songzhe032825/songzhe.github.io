package com.hspedu.jdbc.transaction;

import com.hspedu.jdbc.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 宋哲
 * @version 1.0
 * 演示Jdbc中如何控制事务 回滚或提交
 */
@SuppressWarnings({"all"})
public class Transaction {
    @Test
    public void useTransaction() throws SQLException {
        //1.得到连接
        Connection connection = null;
        //2.组织一个sql
        String sql1 = " update account set balance = balance - 100 where  id = 1";
        String sql2 = " update account set balance = balance + 100 where  id = 2";
        //为什么要扩大作用域是因为 finally会用到preparedStatement
        PreparedStatement preparedStatement =null;

        //3.创建PrepareStatement
        try {
            connection = JdbcUtils.getConnection();
            //将connection 设置不自动提交 很重要哦！
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql1);
            //执行sql
            preparedStatement.executeUpdate();//执行sql语句

            //此时我故意加个异常语句
            //int i = 1/0;
            preparedStatement = connection.prepareStatement(sql2);
            //执行sql
            preparedStatement.executeUpdate();//执行sql语句

            //没有异常 我们就提交
            connection.commit();
        } catch (SQLException e) {
            //如果有异常语句 我们就回滚 即撤销事务sql语句
            System.out.println("执行发生异常 撤销执行sql");
            //默认回滚到事务开始开启的地方 connection.setAutoCommit(false);
            connection.rollback();
            e.printStackTrace();
        } finally {
            //4.关闭资源
            JdbcUtils.close(null,preparedStatement ,connection);
        }
    }

}
