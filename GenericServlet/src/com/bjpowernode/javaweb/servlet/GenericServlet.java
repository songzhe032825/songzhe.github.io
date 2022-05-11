package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 */
//定义抽象类并定义抽象service方法的原因是我只想让子类只重写service抽象方法其他不要重写（防止代码臃肿）
public abstract class GenericServlet implements Servlet {
    // servletConfig对象是tomcat服务器创建好传给init方法做形参的是局部变量
    //而且servletConfig是要在service方法中使用的 但是局部变量做不到啊，怎么办？
    //第一时间要想到定义局部变量而且tomcat服务器会100执行init方法保证传来的形参不为空
    //答：定义一个私有的成员变量默认为null
    private ServletConfig config;
    @Override
    //老子加final修饰符就是不想要init方法重写
    public final void init(ServletConfig servletConfig) throws ServletException {
        //此时this方法调用成员变量config 让形参servletConfig赋给config 这样config不为空
        this.config = servletConfig;
        this.init();
        System.out.println("6666");
    }
    //那么既然config成员变量有值了那么传过来就不为空了 返回config
    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    //定义一个init无参构造方法让子类重写
    public void init(){
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
