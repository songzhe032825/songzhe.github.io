package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.Dbutils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 宋哲
 * @version 1.0
 * 1.根据传过来的部门编号 删除部门
 * 2.根据部门编号连接数据库 但增删改不涉及结果集 但涉及到记录数
 * 3.开启事务 如果多表同时dml操作放在一个事务内 要么同时成功 要么同时失败
 * 4.判断是否成功 涉及到重定向 在这里先用请求转发机制
 */
@SuppressWarnings({"all"})


public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取部门编号
        String deptno = request.getParameter("deptno");
        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            //连接数据库
            conn = Dbutils.getConnection();
            //开启事务 自动提交事务关闭
            conn.setAutoCommit(false);
        //因为dml 所以没有结果集
        //执行sql语句
        String sql = "delete from dept where deptno = ?";
        //预编译
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            //返回值 影响数据库表中多少条记录
            //比如返回3 那就是删了3条
            count = ps.executeUpdate();
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,null);
        }
        //删除成功或失败 没讲过重定向 所以先用请求转发机制
        if (count == 1) {
            //代表删除成功 仍然调用部门列表页面 转发不行了
            //因为没有保存 取出数据所以转发不可以 换重定向
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        } else {
            //删除失败
            //request.getRequestDispatcher("error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
}
