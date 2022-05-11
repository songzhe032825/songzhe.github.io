package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

/**
 * @author 宋哲
 * @version 1.0
 */
public class LoginServlet extends GenericServlet{

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //我给成员变量属性定义私有化 子类像访问比如LoginServlet就给提供get set方法
        //需求我想访问getServletConfig的对象怎么办？this方法调用本类的所有方法属性等
        ServletConfig servletConfig = this.getServletConfig();

        //思路一个问题：有没有一种可能 需要我在loginServlet中重写init方法？
        //肯定的 因为当父类中的init方法无法执行代表着什么 定义的成员变量Config为null
        //(无奈）只能走子类的init方法 这样需要重写init方法
        //(父类心有不甘)但是如果不想要重写子类的init方法 因为子类方法会破坏父类的算法怎么办？
        //答：给父类一个fina修饰符这样子类无法重写init 方法了 会报错

        //但是父类开心 子类不开心了 子类也想要重写init方法怎么办？？
        System.out.println("service服务启动成功");
    }

    @Override
    public void init() {
        //super调用父类的方法
        super.init();
        System.out.println("子类调用成功了");
    }
}
