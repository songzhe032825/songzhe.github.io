package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.Dbutils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 宋哲
 * @version 1.0
 * 1.获取部门的编号
 * 2.跟据部门编号获取连接数据库  根据部门编号获取部门所有信息
 * 3.将部门信息相应打印到浏览器上 显示一个详情
 */
@SuppressWarnings({"all"})
public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取部门的编号 dept/detail?deptno="+deptno+"
        String deptno = request.getParameter("deptno");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset='utf-8'>");
            out.print("<title>部门详情查询</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<hr >");
            out.print("<h1>部门详情</h1>");
            out.print("<hr >");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接数据库  根据部门编号获取部门所有信息
            conn = Dbutils.getConnection();
            //准备sql
            String sql="select dname,loc from dept where deptno = ?";
            //预处理
            ps = conn.prepareStatement(sql);
            //第一个？占位符是1
            ps.setString(1,deptno);
            //因为id是唯一标识 是主键 所以这个结果集一定只有一条记录
            rs = ps.executeQuery();
            while (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("部门编号:"+deptno+"<br>");
                out.print("部门名称:"+dname+"<br>");
                out.print("部门省份："+loc+"<br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,rs);
        }
        out.print("<input type='button' value='后退到主界面' onclick='window.history.back()' />");
        out.print("</body>");
        out.print("</html>");
    }
}
