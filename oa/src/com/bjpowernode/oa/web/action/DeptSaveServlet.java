package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.Dbutils;
import jakarta.servlet.RequestDispatcher;
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
public class DeptSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取部门编号 部门名称 部门省份的信息
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps =null;
        int count = 0;
        //2.连接数据库
        try {
            conn = Dbutils.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into dept(deptno,dname,loc) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);
            count = ps.executeUpdate();
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
        //判断是否添加成功
        if (count==1) {
            //添加成功 注意这里有个细节 我请求是post 方法也是doPost
            //但是list展示界面是get 怎么办？不解决就是405 重定向，后面说
          //  request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }  else {
           // request.getRequestDispatcher("error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
}
