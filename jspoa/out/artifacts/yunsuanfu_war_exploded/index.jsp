<%@ page import="com.bjpowernode.oa.student.Student" %>
<%@page contentType="text/html; charset=UTF-8" %>
${"abc" == "abc"}<br>
${"abc"} == ${"abc"}<br>
<%
  Object obj = new Object();
  request.setAttribute("k1",obj);
  request.setAttribute("k2",obj);
%>
${k1 == k2}<br>

<%
  String a = new String("haha");
  String b = new String("hihi");
  request.setAttribute("haha",a);
  request.setAttribute("hihi",b);
%>
${a==b}<br>
<%--在EL表达式中"=="调用equals方法--%>
<%
  Object o1 = new Object();
  Object o2 = new Object();
  request.setAttribute("o1",o1);
  request.setAttribute("o2",o2);
%>
${o1==o2} <br>

${o1 eq o2} <br>

<%
  Student c = new Student();
  Student d = new Student();
  request.setAttribute("s1",c);
  request.setAttribute("s2",d);
%>

${s1 == s2} <br>
${s1 eq s2} <br>

${empty param.username}



