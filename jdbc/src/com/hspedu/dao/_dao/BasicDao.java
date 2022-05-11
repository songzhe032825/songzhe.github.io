package com.hspedu.dao._dao;

import com.hspedu.jdbc.datasource.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 * 开发BasicDao 是其他Dao的父类
 */
@SuppressWarnings({"all"})
//<T> :将来操作哪一种表由泛型决定
public class BasicDao<T> {//泛型指定具体的类型 可由泛型决定比如：Actor Order goods
    private QueryRunner qr = new QueryRunner();
    //1.开发通用的dml方法 针对任意表
    public int update(String sql,Object...parameters) throws SQLException {//传入一个参数和可变的形参值
        //定义connection 初始化为空
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);//编译异常 》》运行异常
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }

    }
/*1.第一个参数：sql 可以有 ？的占位符
* 2.第两个参数：clazz： clazz传入一个类的Class对象(通过反射) 比如 Actor.class
* 3.第三个参数：parameters 传入 ？的具体值 可以是多个
* */
    //2.返回多个对象 及查询结果是多行(因为一行数据对应一个对象 ) 针对任意表
    //根据Actor.class的类型返回对应的List集合
    public List<T> queryMulti(String sql,Class<T> clazz, Object...parameters){
        //定义connection 初始化为空
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            List<T> list = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);//编译异常 》》运行异常
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
    //3.查询单行结果的通用方法
    public T querySingle(String sql,Class<T> clazz,Object...parameters){
        //定义connection 初始化为空
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            T t = qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);//编译异常 》》运行异常
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
    //4.查询单行单列的方法，即返回单值的方法
    public Object queryScalar(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            Object  scalar = qr.query(connection, sql, new ScalarHandler(), parameters);
            return scalar;
        } catch (SQLException e) {
            throw new RuntimeException(e);//编译异常 》》运行异常
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
