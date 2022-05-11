package com.hspedu.jdbc.myjdbc;

/**
 * @author 宋哲
 * @version 1.0
 * JDBC提供接口
 */
public interface JDBCInterface {
    //连接
    public Object getConnection();
    //crud
    public void crud();
    //关闭
    public void close();
}
