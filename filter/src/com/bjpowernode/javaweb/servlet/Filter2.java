package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter begin");
        chain.doFilter(request,response);
        System.out.println("doFilter end");
    }

    @Override
    public void destroy() {

    }
}
