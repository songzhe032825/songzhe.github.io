package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * @author 宋哲
 * @version 1.0
 * 利用反射机制获取注解的信息里的 比如： "hello" ， {"/hello1","/hello2","/hello3"},
 * 等等
 * @WebServlet(name = "hello",urlPatterns = {"/hello1","/hello2","/hello3"},
 * loadOnStartup = 1,initParams = {@WebInitParam(name="username",value= "root"),@WebInitParam(name=
 * "password",value = "123")})
 */
public class ReflectServlet extends HttpServlet {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.根据反射获取 AnnotationServlet类(根路径拿到)
        Class<?> aClass = Class.forName("com.bjpowernode.javaweb.servlet.AnnotationServlet");
        //2.获取类之后再判断该类上有没有注解对象
        if (aClass.isAnnotationPresent(WebServlet.class)) {
            //3.获取类注解对象
            WebServlet annotation = aClass.getAnnotation(WebServlet.class);
            //4.再获取注解对象的属性值
            String[] value = annotation.value();
            //5.遍历
            for (int i = 0; i <value.length ; i++) {
                System.out.println("注解的信息=" + value[i]);
            }
        }
    }
}
