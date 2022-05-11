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
        //从请求域拿到数据
        Object userObj = request.getAttribute("userObj");
        //将拿到的数据打印到浏览器
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("userObj" + userObj);
    }
}
