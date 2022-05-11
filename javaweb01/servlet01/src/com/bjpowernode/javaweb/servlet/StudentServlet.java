package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //设置响应的内容类型
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        //连接数据库JDBC
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            String url = "jdbc:mysql://localhost:3306/bjpowernode";
            String user ="root";
            String password = "hsp";
            conn = DriverManager.getConnection(url,user,password);
            //获取预编译数据库操作对象
            String sql = "select no,name from t_student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //执行sql
            while(rs.next()){
                String no = rs.getString("no");
                String name = rs.getString("name");
                out.print(no + "," + name + "<br>");
            }
            //处理结果集
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
