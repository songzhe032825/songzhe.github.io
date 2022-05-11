package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 宋哲
 * @version 1.0
 */
public class RequestTestHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输出到控制台
          response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //封装的request对象后 获取参数的集合map
        Map<String, String[]> parameterMap = request.getParameterMap();
        //获取map中所有的keys 拿到keys
        Set<String> keys = parameterMap.keySet();
        //拿到key后 遍历keySet这个对象
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
            System.out.println("我胡汉三又回来了~~~~~~~");
            //通过key获取value
            String[] values = parameterMap.get(key);
            //输出的是一维数组 [Ljava.lang.String;@710168c6
            out.print(key + "=" + values);
            //因此 我要遍历toString的一维数组
            for(String value : values){
                System.out.print(value + ",");
            }
            //换行
            System.out.println();
            //动态获取应用的根路径 项目名别无所谓 永远获取最新的根路径
            String contextPath = request.getContextPath();
            System.out.println("contextPath应用的根路径" + contextPath);

            //获取请求方式
            String method = request.getMethod();
            System.out.println(method);
            //获取请求的uri
            String requestURI = request.getRequestURI();
            System.out.println(requestURI);
            //获取Servlet path
            String servletPath = request.getServletPath();
            System.out.println(servletPath);
        }
    }

}
