package com.bjpowernode.javaweb.action;

import com.bjpowernode.javabean.Dept;
import com.bjpowernode.utils.Dbutils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
@WebServlet({"/dept/list"})
public class DeptListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/dept/list".equals(servletPath)){
            doList(request,response);
        }
    }
    //连接到数据库 获取数据 将数据通过jsp展示出来
    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义集合 目的：将要存放对象
        List<Dept> depts = new ArrayList<>();
        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Dbutils.getConnection();
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                //这些数据需要封装到一个dept实例化对象中 并且创建一个javaBean来封装数据
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //重点来了 这些数据我要封装到创建的对象中 代表一个苹果
                //现在我遍历100次会创建100个对象 此时我的思路是把这个100个对象
                //再封装到集合当中  相当于把100个零散的苹果放在一个编织袋子中一起拿
                Dept dept = new Dept();
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);
                //将所列出的部门对象放在集合中 用add方法
                depts.add(dept);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,rs);
        }
        //将集合存放再请求域当中
        request.setAttribute("deptList",depts);
        //转发 因为Jsp和Servlet都是一样的
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
