package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 宋哲
 * @version 1.0
 */
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //在B这拿A的数据
        Object obj = request.getAttribute("sysTime");
        //打印到浏览器
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("obj对象是" + obj);
        System.out.println("obj对象是" + obj);

        //获取客户端的ip地址
        String add = request.getRemoteAddr();
        System.out.println("add地址=" +add);
    }
}
