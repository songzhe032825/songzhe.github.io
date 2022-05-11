package com.hspedu.jdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 * 通过德鲁伊连接池和DBUtils工具类完成对actor表的crud
 */
//1.演示返回结果是多行记录的 用list接收 在这里说明一下如果有其他方法
    //调用testQueryMany() 那么就返回ArrayList<>
public class DBUtils_Use {
    @Test
    public void testQueryMany() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils类和接口 先引入jar包加入到本地项目中
        //3.创建QueryRunner类 该类封装Sql语句 是线程安全的 能完成增删改查批处理的操作
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id,name,sex from hsp_actor where id = ?";
        //4.执行query()方法返回ArrayList结果集
        //核心知识点：query()方法是执行一个sql语句 得到Result结果集 并且把result结果集封装到ArrayList集合中返回
        //传入参数 ：（1）connection连接
        //（2）sql:执行查询sql语句可带?号
        //（3）new BeanListHandler<Actor>(Actor.class) : 表示底层通过反射机制获取Actor类中的属性
        //并且结果集放入到ArrayList中
        //（4）1：传参sql语句中的？占位符就是可变形参值 可有多个值
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<Actor>(Actor.class), 2);
        System.out.println("输出集合ArrayList的信息值");
        //5.输出验证一下list信息 通过for循环
        for (Actor actor: list) {
            System.out.println(actor);//如果输出默认值的话 记得给Actor类中的set赋值即可
        }
        //6.关闭连接 释放资源 将数据源返回给连接池
        JDBCUtilsByDruid.close(null,null,connection);
    }
    @Test
    //2.演示返回结果是单行记录的 单个对象
    public void testQuerySingle() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.创建QueryRunner类 该类封装Sql语句 是线程安全的 能完成增删改查批处理的操作
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id,name,sex from hsp_actor where id = ?";
        //3.queryRunner()返回单个对象
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        //验证actor信息
        System.out.println(actor);
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
    @Test
    //3.演示单行记录的某一个列的数据 (需要另一个api)返回单个对象 可能为空
    //Scalar 标量 单行单列的某值
    public void testScalar() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.创建QueryRunner类 该类封装Sql语句 是线程安全的 能完成增删改查批处理的操作
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from hsp_actor where id = ?";
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(obj);
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
    @Test
    //4.完成德鲁伊+ 阿帕奇 的dml操作
    public void testUpdate() throws SQLException {
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.创建QueryRunner类 该类封装Sql语句 是线程安全的 能完成增删改查批处理的操作
        QueryRunner queryRunner = new QueryRunner();
        //3.1组织sql语句 注意执行dml : queryRunner.update() 包括删和改
        //3.2 返回的值是受影响的行数 (affected : 受影响的)
        String sql = " update hsp_actor set name = ? where  id= ? ";
        //受影响的行数 0行 1行 2行 。。。。
        int affectRow = queryRunner.update(connection, sql, "张三丰", 4);
        System.out.println(affectRow > 0 ? "执行成功" :"没有受到行数影响");

        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
}



