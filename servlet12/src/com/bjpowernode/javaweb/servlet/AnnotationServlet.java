package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 宋哲
 * @version 1.0
 * 注解的四个属性：
 * 1.name属性：用来指定servlet名字的 等同于xml文件中的<servlet-name></>
 * 2.urlPatterns属性：用来指定servlet的映射路径 返回String类型数组类型  可以有多个路径对应一个servlet类
 * 3.load-on-startup属性：表示启动服务器直接加载类 不需要创建无参构造方法 是int类型
 * 4.initParams属性：初始化参数  返回String类型数组类型 表示注解对象数组形式
 */
//输出/hello1
/*servletName=hello
servletPath=/hello1
value =123 name=password
value =root name=username*/
@WebServlet(name = "hello",urlPatterns = {"/hello1","/hello2","/hello3"},
loadOnStartup = 1,initParams = {@WebInitParam(name="username",value= "root"),@WebInitParam(name=
"password",value = "123")})
public class AnnotationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletName 调用方法直接获取
        String servletName = getServletName();
        System.out.println("servletName=" + servletName);

        //获取ServletPaths 获取路径
        String servletPath = request.getServletPath();
        System.out.println("servletPath=" + servletPath);

        //获取初始化参数 直接获取
        Enumeration<String> initParameterNames = getInitParameterNames();
        //遍历
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            //直接获取value
            String value = getInitParameter(name);
            System.out.println("value =" + value + "name=" + name);
        }
    }
}
