package com.bjpowernode.javaweb.oa.action;

import com.bjpowernode.javabean.Dept;
import com.bjpowernode.util.Dbutils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
@SuppressWarnings({"all"})
@WebServlet({"/dept/list","/dept/detail","/dept/delete","/dept/save","/dept/edit","/dept/modify"})
public class DeptServletList extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //思路：作为一个路口验证 如果已经验证过了可以去做，如果没有跳转到登陆页面
        //首先先获取session必须是当前的 如果获取不到就返回null (而且session不要创建的)
        String servletPath = request.getServletPath();
        if ("/dept/list".equals(servletPath)) {
            doList(request, response);
        } else if ("/dept/detail".equals(servletPath)) {
            doDetail(request, response);
        } else if ("/dept/delete".equals(servletPath)) {
            dodelete(request, response);
        } else if ("/dept/save".equals(servletPath)) {
            doSave(request, response);
        } else if("/dept/edit".equals(servletPath)){
            doEdit(request,response);
        } else if("/dept/modify".equals(servletPath)){
            doModify(request,response);
        }
    }

    private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            response.sendRedirect(request.getContextPath()+"/error.jdp");
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为需要将部门对象封装到请求域中 所以定义到外面
        Dept dept = new Dept();
        //获取部门编号 前端form表单提交数据  ?dno=<%=dept.getDeptno()%>
        String deptno = request.getParameter("deptno");
        //根据部门编号获取部门信息 将部门信息封装成一个苹果 而且苹果只有一个
        //无需袋子 显然部门只有有一个 ，将部门信息放在request当中
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs  = null;
        try {
            conn = Dbutils.getConnection();
            String sql = "select dname,loc from dept where deptno = ?";
            ps= conn.prepareStatement(sql);
            //此代码是给'？'占位符赋值 赋什么值？1：代表一个问号 值：代表dno
            ps.setString(1,deptno);
            rs= ps.executeQuery();
            //这个结果集当中只有一条数据 不需要while循环 而是if
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //将数据封装到对象中
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,rs);
        }
        request.setAttribute("dept",dept);
        request.getRequestDispatcher("/edit.jsp").forward(request,response);
    }


    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //增删改不需要创建对象封装起来 而查询需要创建对象 甚至创建集合封装起来
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
            //给三个占位符赋值
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
        }
    }

    private void dodelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取部门编号 前端form表单提交数据  ?dno=<%=dept.getDeptno()%>
        //重点是我要获取dno编号
        String deptno = request.getParameter("deptno");
        //获取连接
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = Dbutils.getConnection();
            String sql = "delete from dept where deptno = ?";
            ps= conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,deptno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,null);
        }
        if (count==1) {
            //动态获取路径
            String contextPath = request.getContextPath();
            //删除成功 重定向到展示页面
            response.sendRedirect(contextPath+"/dept/list");
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为需要将部门对象封装到请求域中 所以定义到外面
        Dept dept = new Dept();
        //获取部门编号 前端form表单提交数据  ?dno=<%=dept.getDeptno()%>
        String deptno = request.getParameter("deptno");
        //根据部门编号获取部门信息 将部门信息封装成一个苹果 而且苹果只有一个
        //无需袋子 显然部门只有有一个 ，将部门信息放在request当中
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs  = null;
        try {
            conn = Dbutils.getConnection();
            String sql = "select dname,loc from dept where deptno = ?";
            ps= conn.prepareStatement(sql);
            //此代码是给'？'占位符赋值 赋什么值？1：代表一个问号 值：代表dno
            ps.setString(1,deptno);
            rs= ps.executeQuery();
            //这个结果集当中只有一条数据 不需要while循环 而是if
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //将数据封装到对象中
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,rs);
        }
        request.setAttribute("dept",dept);
        request.getRequestDispatcher("/detail.jsp").forward(request,response);
    }

    //连接数据库并通过展示数据
    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //定义集合 构建一个编织袋
        List<Dept> depts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Dbutils.getConnection();
            String sql ="select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            //这里没有问号 所以不需要赋值
            rs= ps.executeQuery();
            while (rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //重点来了 现在我要给这三个数据进行封装 通过javabean
                //接下来 我想给这dept实例化对象 相当于我循环一百次会有一百个苹果
                Dept dept = new Dept();
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);
                //现在我要散装的100个苹果 我需要一个编织袋 给他们装到一起 想到了集合
                //定义完集合 我需要调用add给部门对象装起来
                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutils.close(conn,ps,rs);
        }
        //接下来我需要给集合存放起来 用作用域存放集合
        request.setAttribute("deptList",depts);
        //转发 因为JSP与Servlet都是一个Servlet 内部调用数据
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
