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
@WebServlet({"/sendCookie"})
public class SendCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //浏览器发送cookie给服务器  服务器中的Java如何接受？
        //会返回一个数组 可能返回一个null
        //因为浏览器会返回多个cookie给服务器 所以返回数组
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie :cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("name=" + name + "value="+value );
            }
        }
    }
}
