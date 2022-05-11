package com.bgpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.Enumeration;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ConfigTestServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //输出内容类型
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //获取config对象
        ServletConfig config = this.getServletConfig();
        System.out.println("宋哲你努力的样子真他妈的帅啊啊啊啊啊啊啊啊啊");
        //输出该对象
        out.print("config打印到浏览器" + config);
        //获取标签<servlet-name>configTestServlet</servlet-name>
        String servletName = config.getServletName();
        out.print("<br>");
        System.out.println("TEST啦啦啦 =" + servletName);

        //此时通过ServletConfig对象的两个方法 可以获取到web.xml文件中
        //的初始化参数的配置信息
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        //遍历web.xml中的name信息
        while(initParameterNames.hasMoreElements()){//获取几个元素
            //取出元素
            String name = initParameterNames.nextElement();
            String value = config.getInitParameter(name);
            out.print("<br>");
            out.print(name + "=" + value);
        }
        //上面都是底层源码的实现原理不需要通过configServlet获取
        //直接this调用即可
        this.getInitParameterNames();
       // this.getInitParameter();
    }
}
