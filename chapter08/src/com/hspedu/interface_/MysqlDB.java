package com.hspedu.interface_;

public class MysqlDB implements DBInterface{ //alt + enter
    //mysql 数据库
    @Override
    public void close() {
        System.out.println("连接MYSQL");
    }

    @Override
    public void connect() {
        System.out.println("关闭MYSQL");
    }
}
