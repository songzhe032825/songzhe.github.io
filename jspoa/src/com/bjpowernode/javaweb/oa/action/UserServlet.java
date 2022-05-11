package com.bjpowernode.javaweb.oa.action;

import com.bjpowernode.util.Dbutils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 宋哲
 * @version 1.0
 */
@WebServlet({"/user/login","/user/exit"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/user/login".equals(servletPath)){
            doLogin(request,response);
        } else if("/user/exit".equals(servletPath)){
            doExit(request,response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取session对象 销毁session
        HttpSession session = request.getSession(false);
        if(session != null){
            //手动销毁session对象
            session.invalidate();
            //跳转到登录页面 重定向
            response.sendRedirect(request.getContextPath());//这里只要定位到web根路径即可
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //我要做一件事 ？验证用户名和密码是否正确
        boolean success = false;
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //连接数据库验证用户名和密码
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Dbutils.getConnection();
            String sql = "select * from t_user where username=? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            //因为只有一条数据 所以不需要while循环
            if (rs.next()) {
                //验证登录成功
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutils.close(conn,ps,rs);
        }
        //思路：从这个判断这出发
        if (success){
            //必须获取到session对象 如果有就获取，如果没有就创建session对象
            HttpSession session = request.getSession();
            //将获取到session对像放在会话域中
            session.setAttribute("username",username);
            //首先如果用户登录成功之后 并且用户登陆时选择了十天免登录功能
            //此时应该在login方法中创建Cookie对象并存储用户名和密码
            //然后设置有效期和路径访问这个应用 最后cookie响应到浏览器
            //浏览器将其自动保存到硬盘文件中并且保存10天
            //登陆成功 并且用户选择十天免登录功能
            String f = request.getParameter("f");
            if("1".equals(f)){//这行代码防止空指针异常 并且下次自动登录
                //1.创建cookie对象 存储登录名
                Cookie cookie = new Cookie("username", username);
                //创建cookie对象 存储密码  正常需要加密在这里暂不需要
                Cookie cookie1 = new Cookie("password", password);
                //2.设置cookie的有效期为10天
                cookie.setMaxAge(60*60*24*10);
                cookie1.setMaxAge(60*60*24*10);
                //3.设置cookie的路径 只要访问这个应用 一定要携带这两个cookie
                cookie.setPath(request.getContextPath());
                cookie1.setPath(request.getContextPath());
                //4.响应给cookie到浏览器
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
            //成功 跳转到用户列表页面
            response.sendRedirect(request.getContextPath()+"/dept/list");
        } else {
            //失败 跳转到失败列表页面
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
