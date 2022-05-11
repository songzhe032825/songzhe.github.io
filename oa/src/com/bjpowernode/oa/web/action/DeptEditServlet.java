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
 * 修改有两个部分组成 先查询再修改
 * 这是第一部分 获取编号先查询展示页面
 */
@SuppressWarnings({"all"})
public class DeptEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取根路径
        String contextPath = request.getContextPath();
        //动态打印到浏览器上
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='utf-8'>");
        out.print("<title>修改部门</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>修改部门</h1>");
        out.print("<hr >");
        out.print("<form action='"+contextPath+"/dept/modify' method='post'>");

        //1.先获取部门编号
        String deptno = request.getParameter("deptno");
        //2,连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Dbutils.getConnection();
            String sql = "select dname,loc from dept where deptno= ?";
            ps= conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs = ps.executeQuery();
            //查询之后肯定只有一条数据 因为显示的都是数据库表的列的字段名
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //动态输出网页效果展示
                out.print("部门编号：<input type='text' name ='deptno' value='"+deptno+"' readonly /><br>");
                out.print("部门名称：<input type='text' name='dname' value='"+dname+"'/><br>");
                out.print("部门省份：<input type='text' name='loc' value='"+loc+"'/><br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,rs);
        }
        out.print("<input type='submit' value='修改'/>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }
}
