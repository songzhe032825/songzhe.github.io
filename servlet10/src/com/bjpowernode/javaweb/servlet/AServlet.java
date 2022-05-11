package com.bjpowernode.javaweb.servlet;

import com.bjpowernode.javaweb.javaben.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 请求和重定向的区别：
 * 1.转发只有一次 重定向两次
 * 2.转发最终输出地址栏是其本身 重定向的地址栏是最终地址
 * 3.转发都是服务器内部资源跳转跟浏览器无关 重定向是response的响应能力
 * 将第一次的路径给浏览器 浏览器又会自发的向服务器再发一次请求 具体跳转的资源是由
 * 浏览器控制的 与服务器无关
 * 4.转发：只要请求路径 重定向：项目名+请求路径
 */
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建用户
        User user = new User();
        //给用户赋值
        user.setId(111);
        user.setName("宋");
        //将用户信息存储在请求域中
        request.setAttribute("userObj",user);
        //请求 只有请求名 浏览器地址栏永远是：
        //http://localhost:8080/servlet10/a 没变过
        //request.getRequestDispatcher("/b").forward(request,response);
        //重定向 项目名+请求路径
        //获取重定向时的根路径  request.getContextPath()
        //此时浏览器地址栏由 http://localhost:8080/servlet10/a 变成http://localhost:8080/servlet10/b
        response.sendRedirect(request.getContextPath()+"/b");
        }
}
