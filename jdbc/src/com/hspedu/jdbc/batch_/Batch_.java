package com.hspedu.jdbc.batch_;

import com.hspedu.jdbc.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 宋哲
 * @version 1.0
 * 批处理sql数据
 */
public class Batch_ {
    @Test
    public void batch() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into admin2 values (null, ? ,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        //批处理开始时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack" + i);
            preparedStatement.setString(2,"666");
            //将sql语句加入到批处理包中
            preparedStatement.addBatch();
            //当用1000条记录 再批量执行 不需要立刻执行 需要存储1000条统一执行
            if((i+1%1000 == 0)){
                //批量执行语句
                preparedStatement.executeBatch();
                //清空一把
                preparedStatement.clearBatch();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("批处理方式 =" +(end- start) );
        //关闭连接
        JdbcUtils.close(null,preparedStatement,connection);
    }
}
