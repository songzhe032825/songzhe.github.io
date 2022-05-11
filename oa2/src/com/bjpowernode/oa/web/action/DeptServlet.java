package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.Dbutils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
 * 改造类爆炸问题
 * 使用模板类
 * 原先是六个请求对应六个servlet
 * 现在一个请求对应一个方法Service 一个业务Servlet对于一个请求
 * 比如：处理部门业务的DeptServlet 处理用户业务的UserServlet 处理银行卡业务的CardServlet
 * 统一使用模糊匹配@WebServlet("/dept/*")
 */

@WebServlet("/dept/*")
//@WebServlet({"/dept/list","/dept/save","/dept/edit","/dept/detail",
//"/dept/delete","/dept/modify"})
@SuppressWarnings({"all"})
public class DeptServlet extends HttpServlet {
    //模板方法
    @Override
    //重写service方法(因为service方法是doGet和doPost的上一次 只要写service所以以后不会再有
    // 405错误了)
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletPath路径
        String servletPath = request.getServletPath();
        if("/dept/list".equals(servletPath)){
            doList(request,response);
        } else if ("/dept/save".equals(servletPath)){
            doSave(request,response);
        } else if("/dept/edit".equals(servletPath)){
            doEdit(request,response);
        } else if ("/dept/detail".equals(servletPath)){
            doDetail(request,response);
        } else if("/dept/delete".equals(servletPath)){
            dodelete(request,response);
        } else if ("/dept/modify".equals(servletPath)){
            doModify(request,response);
        }
    }
    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取应用的根路径 为查询详情页面做铺垫
        String contextPath = request.getContextPath();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print(" <html>");
        out.print(" <head>");
        out.print("<meta charset='utf-8'>");
        out.print("<title>部门列表页面</title>");


        out.print("<script type='text/javascript'>");
        out.print("function del(dno){");
        out.print("if(window.confirm('亲 删了不可能恢复哦')){");
        //老子就是因为"/+contextPath+"这个害得我找了一晚上
        out.print("document.location.href = '"+contextPath+"/dept/delete?deptno='+dno");
        out.print("}");
        out.print("}");
        out.print("</script>");



        out.print("</head>");
        out.print("<body>");
        out.print("<h1>部门列表</h1>");
        out.print("<hr >");
        out.print("<table border='1px' align='center' width='50%'>");
        out.print("	<tr>");
        out.print("	<td>序号</td>");
        out.print("<td>部门编号</td>");
        out.print("<td>部门名称</td>");
        out.print("<td>操作</td>");
        out.print("	</tr>");
        //运用jdbc连接数据库 查询所有部门动态展示出来
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        //通过工具类开启连接
        try {
            conn = Dbutils.getConnection();
            //准备一条sql语句
            String sql ="select deptno,dname,loc from dept";
            //预编译处理sql语句
            ps = conn.prepareStatement(sql);
            //处理结果集
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("	<tr>");
                out.print("		<td>"+(++i)+"</td>");
                out.print("		<td>"+deptno+"</td>");
                out.print("		<td>"+dname+"</td>");
                out.print("		<td>");
                out.print("			<a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>修改</a>");
                out.print("			<a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
                //从超链接入手写查询界面<a href='/项目名/detail.html'>详情</a>"
                out.print("			<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
                out.print("		</td>");
                out.print("	</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //工具类关闭资源链接
            Dbutils.close(conn,ps,rs);
        }
        out.print("</table>");
        out.print("	<hr>");
        out.print("	<a href='"+contextPath+"/add.html'>新增部门</a>");
        out.print("</body>");
        out.print("</html>");
    }
    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
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


    private void dodelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }

}
