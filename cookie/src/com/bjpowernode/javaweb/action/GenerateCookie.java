package com.bjpowernode.javaweb.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 */
@WebServlet({"/cookie/generate"})
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //cookie是保存浏览器 而java程序和服务器端 无法在
        //服务器端创建 怎么办？
        //在服务器创建Cookie对象
        Cookie cookie = new Cookie("productId", "123456");
        Cookie cookie1 = new Cookie("zhangshan", "654321");
        //设置cookie在一小时之后失效(保存在硬盘当中)
        //>0 硬盘中
        //<0 运行内存中
        cookie.setMaxAge(-1);
        cookie1.setMaxAge(-2);
        //关联路径是什么？很重要.这个只要是项目下的路径 cookie都接受 网络都能用
        //路径不一样 提交的cookie就不一样 因为cookie和关联路径有关
        //可能是百度cookie 也可能是京东cookie
        cookie.setPath(request.getContextPath());
        cookie1.setPath(request.getContextPath());
        //相应addCookie(cookie)给浏览器
        //此时浏览器的运行内存中拥有两个cookie
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }
}
