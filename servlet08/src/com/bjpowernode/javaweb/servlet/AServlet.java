package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

/**
 * @author 宋哲
 * @version 1.0
 */
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date noTime = new Date();
        //向request域中绑定数据 也就是存数据
        request.setAttribute("sysTime",noTime);
        //BServlet像在A中取数据 怎么办？
        // 使用请求转发机制 需要在浏览器访问a而不是b 因为a有数据 b没数据
        //b想要数据需要这个转发机制从a这拿才行 所以只要a不报null就没问题
        request.getRequestDispatcher("/b").forward(request,response);
    }
}
