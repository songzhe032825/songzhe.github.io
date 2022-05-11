package com.hspedu.jdbc.myjdbc;

import com.hspedu.jdbc.myjdbc.JDBCInterface;
import com.hspedu.jdbc.myjdbc.MysqlJdbcImpl;

/**
 * @author 宋哲
 * @version 1.0
 */
public class TestJdbc {
    //完成对mysql的操作
    public static void main(String[] args) {
      JDBCInterface jdbcInterface = new MysqlJdbcImpl();
      jdbcInterface.getConnection();//通过接口来调用实现类 多态中的动态绑定
      jdbcInterface.crud();
      jdbcInterface.close();
    }
}
