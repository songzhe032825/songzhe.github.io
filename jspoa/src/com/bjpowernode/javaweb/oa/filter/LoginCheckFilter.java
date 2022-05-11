package com.bjpowernode.javaweb.oa.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 * 拦截器
 */
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取请求路径
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession(false);
        //"/index.jsp","/index.jsp", "/user/login","/user/exit" 如果是 就放心不拦截
        //(session != null && session.getAttribute("username") != null)) 代表用户登录了 也放行
        if("/index.jsp".equals(servletPath) || "/index.jsp".equals(servletPath) ||
               "/user/login".equals(servletPath) ||"/user/exit".equals(servletPath)
        || (session != null && session.getAttribute("username") != null)) {
            //继续往下走
            chain.doFilter(request,response);
        } else {
            //重定向 返回到登录页面 除了上诉情况其他情况走这里 不准放行进行拦截
            response.sendRedirect(request.getContextPath() + "/index.jsp");//这里只要定位到web根路径即可
        }
    }

}
