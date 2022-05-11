<%--
  Created by IntelliJ IDEA.
  User: songzhe0328
  Date: 2022/4/22
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
fdfasdsadsadasdsadsad 老子在jsp翻译引擎眼中就是字符串

<%
    System.out.println("加了此符号 我仍然在service方法内和java程序一样");
    System.out.println("输出成员变量i=" + i);
%>
<%--下面这个不常用 线程安全问题 --%>
<%!
    //成员静态变量
    private static int i = 10;
    //代码块
    static {
        System.out.println("不好意思 我们加叹号后 在service方法外了 只在类中了");
    }
    //方法
    public void jsp(){
        System.out.println("hhhhhhh");
    }
%>
涉及到变量的
<%= 100+200%>




