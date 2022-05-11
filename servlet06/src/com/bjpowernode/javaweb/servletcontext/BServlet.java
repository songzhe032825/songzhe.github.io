package com.bjpowernode.javaweb.servletcontext;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author 宋哲
 * @version 1.0
 */
public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //this调用本类 通过ServletConfig对象获取到ServletContext对象
        ServletContext application = this.getServletContext();
        out.print("<br>");
        out.print("application =" + application);

        Enumeration<String> initParameterNames = application.getInitParameterNames();
        //遍历初始化参数的name
        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            //根据name获取value
            String value = application.getInitParameter(name);
            out.print("<br>");
            out.print(name + "=" + value + "<br>");

            //动态获取应用根路径，根路径不要写死对项目部署不好  非常重要
            String contextPath = application.getContextPath();
            out.print("contextPath" + contextPath);
            //测试 在b中我能否存并取到数据？
            application.setAttribute("rose","321");
            Object userObj1 = application.getAttribute("rose");
            out.print("我在B中是否能拿到数据=" +userObj1);
        }
    }
}
