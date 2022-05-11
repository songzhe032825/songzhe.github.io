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
 */
@SuppressWarnings({"all"})
public class DeptModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取编号 并且编号是只读不可改变 其他数据也可以获取到
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        //获取连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = Dbutils.getConnection();
            String sql = "update dept set dname = ?,loc = ? where deptno = ?";
            //根据sql字段从左到右顺序处理
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            count= ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,null);
        }
        if (count==1) {
            //成功
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        } else{
            //失败
            //request.getRequestDispatcher("error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
}
