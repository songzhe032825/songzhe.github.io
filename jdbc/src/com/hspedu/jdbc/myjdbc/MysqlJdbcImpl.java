package com.hspedu.jdbc.myjdbc;

import com.hspedu.jdbc.myjdbc.JDBCInterface;

/**
 * @author 宋哲
 * @version 1.0
 * mysql数据库 实现了JDBC的接口
 * mysql数据库厂商开发
 */
public class MysqlJdbcImpl implements JDBCInterface {

    @Override
    public Object getConnection() {
        System.out.println("得到Mysql连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成mysql的增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭");
    }
}
