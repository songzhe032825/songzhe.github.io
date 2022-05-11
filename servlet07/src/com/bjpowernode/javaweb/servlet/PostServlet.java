package com.bjpowernode.javaweb.servlet;

import com.bjpowernode.javaweb.servlet.GetServlet;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 宋哲
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class PostServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //相应一些内容到浏览器上
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //打印html语句
        out.print("<!doctype html>\n");
        out.print("<html>\n");
        out.print("\n");
        out.print("<head>\n");
        out.print("<title>post</title>\n");
        out.print("</head>\n");
        out.print("\n");
        out.print("<body>\n");
        out.print("<h1>post</h1>\n");
        out.print("</body>\n");
        out.print("\n");
        out.print("</html>");
    }
}
