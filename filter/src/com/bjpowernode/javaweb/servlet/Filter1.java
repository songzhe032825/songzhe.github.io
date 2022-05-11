package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 */
@WebFilter("*.do")
public class Filter1 implements Filter {
    public Filter1(){
        System.out.println("执行无参构造方法");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行init方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter在Servlet类之前执行");
        //chain表示链条 这一行代码表示执行下一个过滤器 执行目标程序Servlet
        //言外之意：下面有过滤器继续执行下一个过滤器 没有过滤器的话执行Servlet
        chain.doFilter(request,response);
        System.out.println("doFilter在Servlet类之后执行");
    }

    @Override
    public void destroy() {
        System.out.println("执行destroy方法");
    }
}
