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
 * 欢迎登陆页面
 */
@SuppressWarnings({"all"})
@WebServlet({"/welcome"})
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //最终有两个走向 if逻辑判断 要么是部门列表 要么是登陆页面
        //总思路是获取Cookie
        //先获取到所有的cookies 返回一个数组 可能返回null 长度必须大于0
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if(cookies != null){
            //遍历
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                //再跟前端的form表单的name属性交互判断
                if("username".equals(name)){
                    username = cookie.getValue();
                } else if("password".equals(password)){
                    password = cookie.getValue();
                }
            }
        }
        //要么”username“和”password“同时为空或者同时不为空
        //我要在这里使用username“和”password的变量
        if(username != null && password != null){
            //1.验证用户名和密码是否正确
            //JDBC代码
            Connection conn =null;
            PreparedStatement ps =null;
            ResultSet rs = null;
            boolean success = false;
            try {
                conn = Dbutils.getConnection();
                String sql = "select * from t_user where username = ? and password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    //验证登录成功
                    success = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Dbutils.close(conn,ps,rs);
            }
            //2.正确表示成功 错误表示失败
            //判断登录成功或失败之前用到session 然后是重定向
            if(success){
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect(request.getContextPath()+ "/dept/list");
            } else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        } else {
            //重定向 跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
}
