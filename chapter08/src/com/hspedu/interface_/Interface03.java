package com.hspedu.interface_;

public class Interface03 {
    /*说现在有一个项目经理 管理三个程序员 功能开发一个软件 为了控制
    * 和管理软件 项目经理可以定义一些接口 然后由程序员具体实现
    * 实际要求 ：3个程序员 编写3个类 分别完成对Mysql Oracle DB2数据库的连接connect close
    * */
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        //写个static不创建t 的对象
        t(mysqlDB);
        OracleDB oracleDB = new OracleDB();
        t(oracleDB);
        DB db = new DB();
        t(db);
    }

    //在测试类中 将来定义一个方法 去使用接口的功能就体现出来了
    //加个static加载类 不去创建对象去调用方法
    public static void t(DBInterface dbInterface){
        dbInterface.connect();
        dbInterface.connect();
    }
}
