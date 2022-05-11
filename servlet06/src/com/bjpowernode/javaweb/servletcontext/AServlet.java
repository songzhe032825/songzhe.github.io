package com.bjpowernode.javaweb.servletcontext;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author 宋哲
 * @version 1.0
 */
public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //this调用本类 通过ServletConfig对象获取到ServletContext对象
        ServletContext application = this.getServletContext();
        out.print("<br>");
        out.print("宋哲你会越来越帅越来越有钱的");
        out.print("application =" + application);
        //获取上下文的初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        //遍历初始化参数的name
        while(initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            //根据name获取value
            String value = application.getInitParameter(name);
            out.print(name + "=" + value + "<br>");
            out.print("<br>");
        }
        //获取contextPath的应用上下文的跟 --动态获取根路径
        String contextPath = application.getContextPath();
        out.print(contextPath);
        out.print("<br>");
        //获取文件的绝对路径也叫真实路径
        //获取IO流 创建文件 项目部署到Linux等都需要真实路径
        String realPath = application.getRealPath("index.html");
        out.print("realPath的真实路径" + realPath);
        //准备数据
        User user = new User("jack", "123");
        User user1 = new User("rose", "321");
        //存数据 类似map集合中的put(k,v)
        application.setAttribute("user",user);
        //取数据 类似于map.get(k)
        Object userObj = application.getAttribute("user");
        //移除数据
        application.removeAttribute("rose");
        out.print("检验user是否合格=" + userObj);
    }
}
