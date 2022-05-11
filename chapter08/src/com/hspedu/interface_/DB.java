package com.hspedu.interface_;

public class DB implements DBInterface{

    @Override
    public void connect() {
        System.out.println("连接DB");
    }

    @Override
    public void close() {
        System.out.println("关闭DB");
    }
}
